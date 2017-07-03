package com.restart.perdiem.dialog;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class SimpleDialogBuilder {

    public static void SimpleDialogBuilder(Context context, String acknowledge) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setTitle("This is title");

        // set dialog message
        alertDialogBuilder.setMessage("This is the message")
                .setCancelable(false)
                .setNeutralButton(acknowledge, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        alertDialogBuilder.show();
    }

    public static void SimpleDialogBuilder(Context context, String positive, String negative) {

    }
}
