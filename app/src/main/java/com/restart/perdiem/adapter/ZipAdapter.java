package com.restart.perdiem.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.restart.perdiem.R;

import java.util.List;

public class ZipAdapter extends RecyclerView.Adapter<ZipAdapter.ZipAdapterViewHolder> {
    private List<Place> mDataSet;
    private Activity mActivity;
    private ZipAdapter mZipAdapter;

    /**
     * Initialize adapter by bring some data to create onClick listeners and gain access to resources
     */
    public ZipAdapter(Activity activity) {
        mActivity = activity;
        mZipAdapter = this;
    }

    /**
     * Managing our main recyclerview
     */
    class ZipAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mName;
        private final TextView mAddress;
        private final ImageView[] mPrice;
        private final ImageView[] mRating;
        private final ImageButton mShare;
        private final ImageButton mDelete;

        /**
         * Setup the basic layout of a row in the recycler view. Create both the click and long click listeners.
         */
        ZipAdapterViewHolder(View view) {
            super(view);
            mName = (TextView) view.findViewById(R.id.name);
            mAddress = (TextView) view.findViewById(R.id.address);

            mPrice = new ImageView[5];
            mPrice[0] = (ImageView) view.findViewById(R.id.free);
            mPrice[1] = (ImageView) view.findViewById(R.id.inexpensive);
            mPrice[2] = (ImageView) view.findViewById(R.id.moderate);
            mPrice[3] = (ImageView) view.findViewById(R.id.expensive);
            mPrice[4] = (ImageView) view.findViewById(R.id.veryExpensive);

            mRating = new ImageView[5];
            mRating[0] = (ImageView) view.findViewById(R.id.bad);
            mRating[1] = (ImageView) view.findViewById(R.id.poor);
            mRating[2] = (ImageView) view.findViewById(R.id.okay);
            mRating[3] = (ImageView) view.findViewById(R.id.good);
            mRating[4] = (ImageView) view.findViewById(R.id.great);

            mShare = (ImageButton) view.findViewById(R.id.share);
            mDelete = (ImageButton) view.findViewById(R.id.delete);
            mShare.setOnClickListener(this);
            mDelete.setOnClickListener(this);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.share:
                    onShare();
                    break;
                case R.id.delete:
                    onDelete();
                    break;
                case R.id.zip_root_view:
                    Toast.makeText(mActivity, "Root", Toast.LENGTH_SHORT).show();
            }
        }

        private void onShare() {
            Place current = mDataSet.get(getAdapterPosition());

            String result = current.getId() + "\n" +
                    current.getAddress() + "\n" +
                    current.getAttributions() + "\n" +
                    current.getLatLng() + "\n" +
                    current.getLocale() + "\n" +
                    current.getName() + "\n" +
                    current.getPhoneNumber() + "\n" +
                    current.getPlaceTypes() + "\n" +
                    current.getPriceLevel() + "\n" +
                    current.getRating() + "\n" +
                    current.getViewport() + "\n" +
                    current.getWebsiteUri() + "\n";

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, result);
            sendIntent.setType("text/plain");
            mActivity.startActivity(Intent.createChooser(sendIntent, mActivity.getString(R.string.share)));
        }

        private void onDelete() {
            AlertDialog.Builder deleteDialog = new AlertDialog.Builder(mActivity);

            deleteDialog.setTitle(R.string.delete)
                    .setMessage(mActivity.getString(R.string.delete_message) + " " + mDataSet.get(getAdapterPosition()).getName() + "?")
                    .setCancelable(false)

                    .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            mDataSet.remove(getAdapterPosition());
                            mZipAdapter.notifyItemRemoved(getAdapterPosition());
                        }
                    })

                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            deleteDialog.show();
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

        int priceLevel = mDataSet.get(position).getPriceLevel();

        for (int i = 0; i < priceLevel; ++i) {
            holder.mPrice[i].setVisibility(View.VISIBLE);
        }

        float ratingLevel = mDataSet.get(position).getRating();

        if (ratingLevel != -1) {
            for (int i = 0; i < 5; ++i) {
                if (ratingLevel >= 1) {
                    holder.mRating[i].setImageDrawable(ResourcesCompat.getDrawable(mActivity.getResources(), R.drawable.ic_star, null));
                } else if (ratingLevel > 0) {
                    holder.mRating[i].setImageDrawable(ResourcesCompat.getDrawable(mActivity.getResources(), R.drawable.ic_star_half, null));
                } else {
                    holder.mRating[i].setImageDrawable(ResourcesCompat.getDrawable(mActivity.getResources(), R.drawable.ic_star_border, null));
                }

                holder.mRating[i].setVisibility(View.VISIBLE);
                ratingLevel -= 1;
            }
        }
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
