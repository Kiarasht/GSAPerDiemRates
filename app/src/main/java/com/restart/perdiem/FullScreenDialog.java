package com.restart.perdiem;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class FullScreenDialog extends DialogFragment {
    private DateTimePickerListener mPickerListener;
    private DateFormat mDateFormat;
    private DateFormat mTimeFormat;

    public ActionBar getmActionBar() {
        return mActionBar;
    }

    private ActionBar mActionBar;
    private EditText mStartingDate;
    private EditText mStartingTime;
    private EditText mEndingDate;
    private EditText mEndingTime;
    private int mLastId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setTitle(getArguments().getString("title"));

        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_close_clear_cancel);
        }

        mPickerListener = new DateTimePickerListener();
        mDateFormat = new SimpleDateFormat(getString(R.string.dateFormat), Locale.getDefault());
        mTimeFormat = new SimpleDateFormat(getString(R.string.timeFormat), Locale.getDefault());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        final Window window = dialog.getWindow();

        if (window != null) {
            window.getAttributes().windowAnimations = R.style.DialogAnimation;
            return dialog;
        } else {
            return new Dialog(getActivity());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_layout, container, false);

        Date now = new Date();
        String date = mDateFormat.format(now);
        String time = mTimeFormat.format(now);

        mStartingDate = (EditText) view.findViewById(R.id.starting_date);
        mStartingDate.setText(date);
        mStartingDate.setOnClickListener(mOnClickListener);

        mStartingTime = (EditText) view.findViewById(R.id.starting_time);
        mStartingTime.setText(time);
        mStartingTime.setOnClickListener(mOnClickListener);

        mEndingDate = (EditText) view.findViewById(R.id.ending_date);
        mEndingDate.setText(date);
        mEndingDate.setOnClickListener(mOnClickListener);

        mEndingTime = (EditText) view.findViewById(R.id.ending_time);
        mEndingTime.setText(time);
        mEndingTime.setOnClickListener(mOnClickListener);



        return view;
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mLastId = v.getId();
            Calendar calendar = Calendar.getInstance();

            try {
                switch (v.getId()) {
                    case R.id.starting_date:
                        calendar.setTime(mDateFormat.parse(mStartingDate.getText().toString()));
                        break;
                    case R.id.starting_time:
                        calendar.setTime(mTimeFormat.parse(mStartingTime.getText().toString()));
                        break;
                    case R.id.ending_date:
                        calendar.setTime(mDateFormat.parse(mEndingDate.getText().toString()));
                        break;
                    case R.id.ending_time:
                        calendar.setTime(mTimeFormat.parse(mEndingTime.getText().toString()));
                        break;
                }
            } catch (ParseException e) {
                calendar = Calendar.getInstance();
            }

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            switch (v.getId()) {
                case R.id.starting_date:
                    new DatePickerDialog(getActivity(), mPickerListener, year, month, day);
                    break;
                case R.id.starting_time:
                    new TimePickerDialog(getActivity(), mPickerListener, hour, minute, false);
                    break;
                case R.id.ending_date:
                    new DatePickerDialog(getActivity(), mPickerListener, year, month, day);
                    break;
                case R.id.ending_time:
                    new TimePickerDialog(getActivity(), mPickerListener, hour, minute, false);
                    break;
                default:
            }
        }
    };

    private class DateTimePickerListener implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
        /**
         * Called when the user is done setting a new date and the dialog has
         * closed.
         *
         * @param view       the picker associated with the dialog
         * @param year       the selected year
         * @param month      the selected month (0-11 for compatibility with
         *                   {@link Calendar#MONTH})
         * @param dayOfMonth th selected day of the month (1-31, depending on
         */
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            switch (mLastId) {
                case R.id.starting_date:
                    mStartingDate.setText(mDateFormat.format(calendar.getTime()));
                    break;
                case R.id.ending_date:
                    mEndingDate.setText(mDateFormat.format(calendar.getTime()));
                    break;
            }
        }

        /**
         * Called when the user is done setting a new time and the dialog has
         * closed.
         *
         * @param view      the view associated with this listener
         * @param hourOfDay the hour that was set
         * @param minute    the minute that was set
         */
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calendar.set(Calendar.MINUTE, minute);

            switch (mLastId) {
                case R.id.starting_time:
                    mStartingTime.setText(mTimeFormat.format(calendar.getTime()));
                    break;
                case R.id.ending_time:
                    mEndingTime.setText(mTimeFormat.format(calendar.getTime()));
                    break;
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.save_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MainActivity mainActivity = (MainActivity) getActivity();
        FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();

        switch (item.getItemId()) {
            case R.id.save:
                fragmentManager.popBackStack();
                mActionBar.setDisplayHomeAsUpEnabled(false);
                mActionBar.setTitle(R.string.app_name);
                mainActivity.mNavigation.setVisibility(View.VISIBLE);
                return true;
            case android.R.id.home:
                fragmentManager.popBackStack();
                mActionBar.setDisplayHomeAsUpEnabled(false);
                mActionBar.setTitle(R.string.app_name);
                mainActivity.mNavigation.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}