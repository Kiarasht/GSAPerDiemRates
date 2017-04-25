package com.restart.perdiem.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.restart.perdiem.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateAdapterViewHolder> {
    private final onListItemClick mOnListItemClickListener;
    private List<String> mDataSet;

    /**
     * Initialize adapter by bring some data to create onClick listeners and gain access to resources
     *
     * @param listener for tapping on recyclerview
     */
    public StateAdapter(onListItemClick listener) {
        mOnListItemClickListener = listener;
    }

    public interface onListItemClick {
        void onStateListItemClick(int index);
    }

    /**
     * Managing our main recyclerview
     */
    public class StateAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final ExpandableLayout expandableLayout;
        private final TextView mState;

        /**
         * Setup the basic layout of a row in the recycler view. Create both the click and long click listeners.
         */
        StateAdapterViewHolder(View view) {
            super(view);

            mState = (TextView) view.findViewById(R.id.state);
            expandableLayout = (ExpandableLayout) itemView.findViewById(R.id.expandable_layout);
            expandableLayout.setInterpolator(new OvershootInterpolator());
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onStateListItemClick(getAdapterPosition());
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
    public StateAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StateAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.state_row, parent, false));
    }

    /**
     * On a bind, setup the properties of the ViewHolder by also knowing which position it current
     * rests in
     *
     * @param holder   incoming attached ViewHolder
     * @param position position it is in the adapter
     */
    @Override
    public void onBindViewHolder(StateAdapterViewHolder holder, int position) {
        holder.mState.setText(mDataSet.get(position));
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
    public void setDataSet(List<String> dataSet) {
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    /**
     * Get the current data list
     */
    public List<String> getDataSet() {
        return mDataSet;
    }
}
