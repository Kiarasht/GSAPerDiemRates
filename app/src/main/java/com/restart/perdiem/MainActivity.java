package com.restart.perdiem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.restart.perdiem.adapter.CityAdapter;
import com.restart.perdiem.adapter.StateAdapter;
import com.restart.perdiem.adapter.StateAdapter.StateAdapterViewHolder;
import com.restart.perdiem.adapter.ZipAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.restart.perdiem.data.PlaceManager.STATES;
import static com.restart.perdiem.data.PlaceManager.STATE_CITY_MAPPER;

public class MainActivity extends AppCompatActivity implements PlaceSelectionListener, StateAdapter.onListItemClick, ZipAdapter.onListItemClick, CityAdapter.onListItemClick {

    private static final String TAG = ".MainActivity";
    private static final int REQUEST_SELECT_PLACE = 9876;
    private static final int UNSELECTED = -1;
    private int selectedItem = UNSELECTED;

    private StateAdapter mState;
    private ZipAdapter mZip;
    private RecyclerView mRecyclerState;
    private RecyclerView mRecyclerZIP;
    private FloatingActionButton mSearchButton;
    private TextView mZipWarning;
    private List<Place> mPlaces;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switchViews(item.getItemId());
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlaces = new ArrayList<>();

        LinearLayoutManager stateManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration stateDecoration = new DividerItemDecoration(this, stateManager.getOrientation());
        LinearLayoutManager zipManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerState = (RecyclerView) findViewById(R.id.locationRecycler);
        mRecyclerZIP = (RecyclerView) findViewById(R.id.zipRecycler);
        mZipWarning = (TextView) findViewById(R.id.zipWarningTextView);
        mSearchButton = (FloatingActionButton) findViewById(R.id.search);

        mRecyclerState.setLayoutManager(stateManager);
        mState = new StateAdapter(this, this);
        mRecyclerState.setHasFixedSize(true);
        mRecyclerState.addItemDecoration(stateDecoration);
        mState.setDataSet(STATES);
        mRecyclerState.setAdapter(mState);

        mRecyclerZIP.setLayoutManager(zipManager);
        mZip = new ZipAdapter(this);
        mRecyclerZIP.setHasFixedSize(false);
        mZip.setDataSet(mPlaces);
        mRecyclerZIP.setAdapter(mZip);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .setFilter(new AutocompleteFilter.Builder().setCountry("US").build())
                            .build(MainActivity.this);
                    startActivityForResult(intent, REQUEST_SELECT_PLACE);
                } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        switchViews(R.id.navigation_home);
    }

    private void switchViews(int itemId) {
        switch (itemId) {
            case R.id.navigation_home:
                mSearchButton.hide();
                mZipWarning.setVisibility(View.GONE);
                mRecyclerState.setVisibility(View.GONE);
                mRecyclerZIP.setVisibility(View.GONE);
                break;
            case R.id.navigation_address:
                mSearchButton.show();

                mRecyclerState.setVisibility(View.GONE);

                if (mZip.getDataSet().size() > 0) {
                    mZipWarning.setVisibility(View.GONE);
                    mRecyclerZIP.setVisibility(View.VISIBLE);
                } else {
                    mRecyclerZIP.setVisibility(View.GONE);
                    mZipWarning.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.navigation_states:
                mSearchButton.hide();
                mZipWarning.setVisibility(View.GONE);
                mRecyclerState.setVisibility(View.VISIBLE);
                mRecyclerZIP.setVisibility(View.GONE);
                break;
            default:
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SELECT_PLACE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                this.onPlaceSelected(place);
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                this.onError(status);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPlaceSelected(Place place) {
        mPlaces.add(place);
        mZipWarning.setVisibility(View.GONE);
        mRecyclerZIP.setVisibility(View.VISIBLE);
        mZip.notifyItemInserted(mPlaces.size() - 1);
    }

    @Override
    public void onError(Status status) {

    }

    @Override
    public void onStateListItemClick(int index) {
        StateAdapterViewHolder holder = (StateAdapterViewHolder) mRecyclerState.findViewHolderForAdapterPosition(selectedItem);
        if (holder != null) {
            holder.mState.setSelected(false);
            holder.expandableLayout.collapse();
        }

        holder = (StateAdapterViewHolder) mRecyclerState.findViewHolderForAdapterPosition(index);
        if (index == selectedItem) {
            selectedItem = UNSELECTED;
        } else {
            holder.mState.setSelected(true);
            holder.expandableLayout.expand();
            selectedItem = index;

            LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            DividerItemDecoration decoration = new DividerItemDecoration(this, manager.getOrientation());
            holder.mRecyclerCity.setLayoutManager(manager);
            holder.mCity = new CityAdapter(this);
            holder.mRecyclerCity.setHasFixedSize(true);
            holder.mRecyclerCity.addItemDecoration(decoration);
            holder.mCity.setDataSet(STATE_CITY_MAPPER.get(holder.mState.getText().toString()));
            holder.mRecyclerCity.setAdapter(holder.mCity);
        }
    }

    @Override
    public void onAddressListItemClick(int index) {

    }

    @Override
    public void onCityListItemClick(int index) {

    }
}
