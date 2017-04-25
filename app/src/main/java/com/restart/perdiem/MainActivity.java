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

import com.restart.perdiem.adapter.StateAdapter.StateAdapterViewHolder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.restart.perdiem.adapter.StateAdapter;
import com.restart.perdiem.adapter.ZipAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.restart.perdiem.data.PlaceManager.STATES;

public class MainActivity extends AppCompatActivity implements PlaceSelectionListener, StateAdapter.onListItemClick, ZipAdapter.onListItemClick {

    private static final String TAG = ".MainActivity";
    private static final int REQUEST_SELECT_PLACE = 9876;

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
        mState = new StateAdapter(this);
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
        StateAdapterViewHolder holder = (StateAdapterViewHolder) mRecyclerState.findViewHolderForAdapterPosition(index);
        if (holder != null) {
            holder.expandableLayout.toggle();
        }
    }

    @Override
    public void onAddressListItemClick(int index) {

    }
}
