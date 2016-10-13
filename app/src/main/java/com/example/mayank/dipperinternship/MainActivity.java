package com.example.mayank.dipperinternship;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final int LOCATION_REQ_CODE = 100;

    TextView navname;
    TextView navemail;
    FirebaseAuth firebaseAuth;
    static FirebaseUser user;
    Boolean doublepress= false;
    CoordinatorLayout coordinatorLayout;
    GoogleApiClient mGoogleApiClient;
    Button button;
    NotificationCompat.Builder notify;
    static final int unique_id=9722;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Crashlytics
        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();

        button=(Button)findViewById(R.id.bidding);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cordinatorlayout);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Dipper");

        notify=new NotificationCompat.Builder(this);
        notify.setAutoCancel(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,BiddingActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

       if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_REQ_CODE);
            return;
        }
        //scheduleNotify();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You are calling MAYANK AGGARWAL(9585418609).",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "9585418609"));
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        navname=(TextView)header.findViewById(R.id.accountname);
        navemail=(TextView)header.findViewById(R.id.accountemail);


        Calendar c=Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
            @Override
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                Toast.makeText(MainActivity.this,"Google play services error..",Toast.LENGTH_SHORT).show();
            }
        }).addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();


        if(user!=null){
            navname.setText(user.getDisplayName().toString());
            navemail.setText(user.getEmail().toString());
            if(timeOfDay >= 0 && timeOfDay < 12){
                Snackbar.make(coordinatorLayout, "Good Morning,"+user.getDisplayName().toString(), Snackbar.LENGTH_LONG).show();
            }else if(timeOfDay >= 12 && timeOfDay < 16){
                Snackbar.make(coordinatorLayout, "Good Afternoon,"+user.getDisplayName().toString(), Snackbar.LENGTH_LONG).show();
            }
            else if(timeOfDay >= 16 && timeOfDay < 21){
                Snackbar.make(coordinatorLayout, "Good Evening,"+user.getDisplayName().toString(), Snackbar.LENGTH_LONG).show();
            }else if(timeOfDay >= 21 && timeOfDay < 24){
                Snackbar.make(coordinatorLayout, "Welcome,"+user.getDisplayName().toString(), Snackbar.LENGTH_LONG).show();
            }
        }
        else{
            if(timeOfDay >= 0 && timeOfDay < 12){
                Snackbar.make(coordinatorLayout, "Good Morning,You Logged In As Guest.", Snackbar.LENGTH_LONG).show();
            }else if(timeOfDay >= 12 && timeOfDay < 16){
                Snackbar.make(coordinatorLayout, "Good Afternoon,You Logged In As Guest.", Snackbar.LENGTH_LONG).show();
            }
            else if(timeOfDay >= 16 && timeOfDay < 21){
                Snackbar.make(coordinatorLayout, "Good Evening,You Logged In As Guest.", Snackbar.LENGTH_LONG).show();
            }else if(timeOfDay >= 21 && timeOfDay < 24){
                Snackbar.make(coordinatorLayout, "Welcome,You Logged In As Guest.", Snackbar.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(doublepress){
                super.onBackPressed();
                return;
            }
            doublepress=true;
            Toast.makeText(MainActivity.this,"Press Again To Exit",Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doublepress=false;
                }
            },2000);
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_logout) {
            if(user!= null){
                user=null;
                navname.setText("Guest");
                navemail.setText("No Email,Register To Our App.");
                firebaseAuth.signOut();

                Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {

                    }
                });
                Toast.makeText(MainActivity.this, "You are logged out.", Toast.LENGTH_SHORT).show();

            }
            else
                Toast.makeText(MainActivity.this, "Please Sign In First", Toast.LENGTH_SHORT).show();

        }else if (id == R.id.nav_about) {
            Intent i = new Intent(MainActivity.this,About.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        }
        else if (id == R.id.nav_notify) {
            show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==LOCATION_REQ_CODE){
            if(permissions[0]==android.Manifest.permission.ACCESS_FINE_LOCATION){
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                  //  locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);

                }
            }
        }
    }


    private void scheduleNotify()
    {
        Intent notificationIntent = new Intent(this, LocationService.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,0,1000,pendingIntent);

    }

    public void show(){
        notify.setSmallIcon(R.drawable.ic_launcher);
        notify.setContentTitle("Dipper Co.");
        String name="Mayank recieved message from Dipper.";
        notify.setContentText(name);
        notify.setStyle(new NotificationCompat.BigTextStyle().bigText(name));
        notify.setWhen(System.currentTimeMillis());
        notify.setDefaults(Notification.DEFAULT_VIBRATE+Notification.DEFAULT_SOUND+Notification.DEFAULT_LIGHTS);
        notify.setPriority(2);
        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notify.setContentIntent(pendingIntent);
        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(unique_id,notify.build());
    }

}
