package com.restart.perdiem.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.restart.perdiem.R;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityAdapterViewHolder> {
    private final onListItemClick mOnListItemClickListener;
    private List<String[]> mDataSet;

    /**
     * Initialize adapter by bring some data to create onClick listeners and gain access to resources
     *
     * @param listener for tapping on recyclerview
     */
    public CityAdapter(onListItemClick listener) {
        mOnListItemClickListener = listener;
    }

    public interface onListItemClick {
        void onCityListItemClick(int index);
    }

    /**
     * Managing our main recyclerview
     */
    public class CityAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mCity;
        public final TextView mCounty;

        /**
         * Setup the basic layout of a row in the recycler view. Create both the click and long click listeners.
         */
        CityAdapterViewHolder(View view) {
            super(view);

            mCity = (TextView) view.findViewById(R.id.city);
            mCounty = (TextView) view.findViewById(R.id.county);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onCityListItemClick(getAdapterPosition());
        }
    }

    /**
     * Inflate the layout so we can access each of the individual views
     *
     * @param parent
     * @param viewType
     * @return view to use and find our widgets
     */
    @Override
    public CityAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CityAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.city_row, parent, false));
    }

    /**
     * On a bind, setup the properties of the ViewHolder by also knowing which position it current
     * rests in
     *
     * @param holder   incoming attached ViewHolder
     * @param position position it is in the adapter
     */
    @Override
    public void onBindViewHolder(CityAdapterViewHolder holder, int position) {
        holder.mCity.setText(mDataSet.get(position)[0]);
        holder.mCounty.setText(mDataSet.get(position)[1]);
    }

    /**
     * Recycler view size is based on the size of our data list
     *
     * @return size of recyclerview
     */
    @Override
    public int getItemCount() {
        if (mDataSet == null) return 0;
        return mDataSet.size();
    }

    /**
     * Set the data list of recyclerview to a new one
     *
     * @param dataSet the new data list
     */
    public void setDataSet(List<String[]> dataSet) {
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    /**
     * Get the current data list
     */
    public List<String[]> getDataSet() {
        return mDataSet;
    }
}