package com.game.dubaisattagame.models;

import android.app.ProgressDialog;
import android.content.Context;

public class DialogLIB {
    public static ProgressDialog ProgressDialogShow(Context context, ProgressDialog progressDialog, String msg) {
        if (progressDialog == null)
            progressDialog = new ProgressDialog(context);

        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(false);


        try {
            progressDialog.show();
        } catch (Exception ex) {
            String ss = "";
        } finally {
            return progressDialog;
        }
    }

    public static void ProgressDialogDismiss(ProgressDialog progressDialog) {
        if (progressDialog != null)
            progressDialog.dismiss();
    }
}
