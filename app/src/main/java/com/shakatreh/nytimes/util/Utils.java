package com.shakatreh.nytimes.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.shakatreh.nytimes.R;

public class Utils {

    public synchronized static void showAlertDialog(Context context, String title, String message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.close, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}
