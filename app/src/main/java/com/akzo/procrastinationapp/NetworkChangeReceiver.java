package com.akzo.procrastinationapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        final ConnectivityManager connMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        assert connMgr != null;
        final android.net.NetworkInfo wifi = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        final android.net.NetworkInfo mobile = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        assert wifi != null;
        assert mobile != null;
        if (wifi.isAvailable() || mobile.isAvailable()) {
            Log.d("MY_DEBUG_TAG", "network changed");
            Toast.makeText(context,"Go and do the task!!!", Toast.LENGTH_LONG).show();
        }
    }
}
