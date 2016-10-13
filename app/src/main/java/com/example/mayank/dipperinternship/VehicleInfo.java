package com.example.mayank.dipperinternship;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class VehicleInfo extends AppCompatActivity {

    TextView truckid,truckconf,shipconf,utr,per,challan;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_info);


        ActionBar actionBar=getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>Driver/Vehicle</font>"));

        truckid=(TextView)findViewById(R.id.truckerid);
        truckconf=(TextView)findViewById(R.id.truckerstatus);
        shipconf=(TextView)findViewById(R.id.shipperstatus);
        utr=(TextView)findViewById(R.id.utrcode);
        per=(TextView)findViewById(R.id.petrocard);
        challan=(TextView)findViewById(R.id.challan);
        button=(Button)findViewById(R.id.call);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VehicleInfo.this,"You are calling MAYANK AGGARWAL(9585418609).",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "9585418609"));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        truckid.setText(BookingActivity.truckid);
        truckconf.setText(BookingActivity.truckerstatus);
        shipconf.setText(BookingActivity.shipperstatus);
        utr.setText(BookingActivity.utrcode);
        per.setText(BookingActivity.petrocard);
        challan.setText(BookingActivity.challan);
    }
}
