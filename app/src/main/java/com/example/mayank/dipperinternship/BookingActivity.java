package com.example.mayank.dipperinternship;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayank.dipperinternship.api.ApiBooking;
import com.example.mayank.dipperinternship.api.ApiCalls;
import com.example.mayank.dipperinternship.api.Values;
import com.example.mayank.dipperinternship.model.BiddingClass;
import com.example.mayank.dipperinternship.model.BookingClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookingActivity extends AppCompatActivity implements Values{


    TextView crat,upat,loadid,shipid,mat,tid,lcid,connameid,pickup,drop,consname,yourrate,bookrate,total,paystatus;
    Button button;
    static String truckid,shipperstatus,truckerstatus,utrcode,petrocard,challan;

    Gson gson;
    Retrofit retrofit;

    ProgressDialog progressDialog;
   BookingClass booking=new BookingClass();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>Booking</font>"));


        crat=(TextView)findViewById(R.id.createdat);
        upat=(TextView)findViewById(R.id.updatedat);
        loadid=(TextView)findViewById(R.id.loadid);
        shipid=(TextView)findViewById(R.id.shipid);
        mat=(TextView)findViewById(R.id.material);
        tid=(TextView)findViewById(R.id.truckerid);
        lcid=(TextView)findViewById(R.id.supervisorid);
        connameid=(TextView)findViewById(R.id.consigner);
        pickup=(TextView)findViewById(R.id.from);
        drop=(TextView)findViewById(R.id.to);
        consname=(TextView)findViewById(R.id.consignee);
        yourrate=(TextView)findViewById(R.id.yourrate);
        bookrate=(TextView)findViewById(R.id.bookingprice);
        total=(TextView)findViewById(R.id.totalrate);
        paystatus=(TextView)findViewById(R.id.payment);
        button=(Button)findViewById(R.id.vehicle);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BookingActivity.this,VehicleInfo.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        getBooking();
    }
    public void setUpRetrofit() {
        gson=new GsonBuilder().create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS).writeTimeout(50, TimeUnit.SECONDS).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public void getBooking() {
        setUpRetrofit();
        gson=new Gson();

        progressDialog=new ProgressDialog(BookingActivity.this);
        progressDialog.setMessage("Wait");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiBooking apiCalls = retrofit.create(ApiBooking.class);
        Call<JsonObject> call = apiCalls.dbCallback();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                booking=gson.fromJson(response.body(),BookingClass.class);
                crat.setText(String.valueOf(booking.getCreated_at()));
                upat.setText(String.valueOf(booking.getUpdated_at()));
                loadid.setText(String.valueOf(booking.getLoad_id()));
                shipid.setText(String.valueOf(booking.getShipper_id()));
                mat.setText(String.valueOf(booking.getMaterial_type()));
                tid.setText(String.valueOf(booking.getTrucker_id()));
                lcid.setText(String.valueOf(booking.getLoading_supervisor_id()));
                connameid.setText(String.valueOf(booking.getConsigner_id()));
                pickup.setText(String.valueOf(booking.getPickup_address()));
                consname.setText(String.valueOf(booking.getConsignee_name()+"("+booking.getConsignee_id()+")"));
                drop.setText(String.valueOf(booking.getDrop_address()));
                yourrate.setText(getIntent().getExtras().getString("updatedprice"));
                bookrate.setText(String.valueOf(booking.getBooking_price()));
                total.setText(String.valueOf(booking.getTotal_amount()));
                paystatus.setText(String.valueOf(booking.getPayment_state()));

                shipperstatus=String.valueOf(booking.isPending_shipper_confirmation());
                truckerstatus=String.valueOf(booking.isPending_trucker_confirmation());
                truckid=String.valueOf(booking.getTrucker_request_id());
                challan=String.valueOf(booking.getChallan_no());
                petrocard=String.valueOf(booking.getPetrocard_percentage());
                utrcode=String.valueOf(booking.getUTR_code());


                Log.v("Req",response.body().toString());
                progressDialog.dismiss();
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.v("Req", "Error in api");
                Toast.makeText(BookingActivity.this,"Check your internet connection",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
