package com.example.mayank.dipperinternship;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstantService extends FirebaseInstanceIdService {

    public static final String token="token";
    @Override
    public void onTokenRefresh() {
        Log.v(token, FirebaseInstanceId.getInstance().getToken().toString());
    }
}
