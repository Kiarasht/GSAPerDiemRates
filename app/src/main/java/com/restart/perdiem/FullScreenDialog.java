package com.restart.perdiem;

import android.app.Dialog;
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


public class FullScreenDialog extends DialogFragment {
    private ActionBar mActionBar;

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
        return inflater.inflate(R.layout.dialog_fragment_layout, container, false);
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