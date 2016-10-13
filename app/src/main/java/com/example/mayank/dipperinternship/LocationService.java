package com.example.mayank.dipperinternship;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.firebase.client.Firebase;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by mayank on 12-10-2016.
 */
public class LocationService extends BroadcastReceiver implements LocationListener {

    Context ctx;
    Firebase firebase;
    String useradd="";

    @Override
    public void onReceive(Context context, Intent intent) {
        this.ctx=context;
        Firebase.setAndroidContext(context);
        firebase=new Firebase("https://dipperinternship.firebaseio.com/");
        firebase.child("Location").push().setValue(useradd);
        Log.v("push",useradd);
    }

    @Override
    public void onLocationChanged(Location location) {
        Geocoder geocoder=new Geocoder(ctx, Locale.getDefault());
        String result =
                "\naltitude = " + location.getAltitude() +
                        "\nlatitude = " + location.getLatitude() +
                        "\nlongitude = " + location.getLongitude();

        try{
            List<Address> addresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            Address address=addresses.get(0);
            for(int i=0;i<address.getMaxAddressLineIndex();i++)
                useradd=useradd+address.getAddressLine(i).toString()+"\n";
            useradd=useradd+(address.getCountryName().toString())+"\n"+result;

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {
        Toast.makeText(ctx,"GPS Disabled",Toast.LENGTH_SHORT).show();
    }
}


