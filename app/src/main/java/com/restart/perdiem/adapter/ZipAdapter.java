package com.restart.perdiem.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.location.places.Place;
import com.restart.perdiem.R;

import java.util.List;

public class ZipAdapter extends RecyclerView.Adapter<ZipAdapter.ZipAdapterViewHolder> {
    private final onListItemClick mOnListItemClickListener;
    private List<Place> mDataSet;

    /**
     * Initialize adapter by bring some data to create onClick listeners and gain access to resources
     *
     * @param listener for tapping on recyclerview
     */
    public ZipAdapter(onListItemClick listener) {
        mOnListItemClickListener = listener;
    }

    public interface onListItemClick {
        void onAddressListItemClick(int index);
    }

    /**
     * Managing our main recyclerview
     */
    class ZipAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mName;
        private final TextView mAddress;
        private final TextView mLocation;

        /**
         * Setup the basic layout of a row in the recycler view. Create both the click and long click listeners.
         */
        ZipAdapterViewHolder(View view) {
            super(view);
            mName = (TextView) view.findViewById(R.id.name);
            mAddress = (TextView) view.findViewById(R.id.address);
            mLocation = (TextView) view.findViewById(R.id.location);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onAddressListItemClick(getAdapterPosition());
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
    public ZipAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ZipAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.zip_row, parent, false));
    }

    /**
     * On a bind, setup the properties of the ViewHolder by also knowing which position it current
     * rests in
     *
     * @param holder   incoming attached ViewHolder
     * @param position position it is in the adapter
     */
    @Override
    public void onBindViewHolder(ZipAdapterViewHolder holder, int position) {
        holder.mName.setText(mDataSet.get(position).getName());
        holder.mAddress.setText(mDataSet.get(position).getAddress());
        holder.mLocation.setText(mDataSet.get(position).getLatLng().toString());
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
    public void setDataSet(List<Place> dataSet) {
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    /**
     * Getter for the data set the adapter is holding
     *
     * @return the current data set
     */
    public List<Place> getDataSet() {
        return mDataSet;
    }
}
