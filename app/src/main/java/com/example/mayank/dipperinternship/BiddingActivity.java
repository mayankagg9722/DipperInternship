package com.example.mayank.dipperinternship;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayank.dipperinternship.api.ApiCalls;
import com.example.mayank.dipperinternship.api.Values;
import com.example.mayank.dipperinternship.model.BiddingClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.Util;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BiddingActivity extends AppCompatActivity implements Values{

    TextView crat,upat,pid,pickup,info,from,to,qprice,lqprice,tid,gps,status;
    Gson gson;
    Retrofit retrofit;
    Button button;
    ProgressDialog progressDialog;
    EditText upprice;
    BiddingClass bidding=new BiddingClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidding);


        ActionBar actionBar=getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>Bidding</font>"));

        crat= (TextView) findViewById(R.id.createdat);
        upat= (TextView) findViewById(R.id.updatedat);
        pid= (TextView) findViewById(R.id.postid);
        pickup= (TextView) findViewById(R.id.pickupdate);
        info= (TextView) findViewById(R.id.info);
        from= (TextView) findViewById(R.id.from);
        to= (TextView) findViewById(R.id.to);
        qprice= (TextView) findViewById(R.id.quoted);
        lqprice= (TextView) findViewById(R.id.lastquoted);
        tid= (TextView) findViewById(R.id.truckid);
        gps= (TextView) findViewById(R.id.gps);
        status= (TextView) findViewById(R.id.status);
        upprice=(EditText)findViewById(R.id.updateprice);

        button=(Button)findViewById(R.id.book);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(upprice.getText().toString().equals(""))
                {
                    Toast.makeText(BiddingActivity.this,"Enter updated price",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent=new Intent(BiddingActivity.this, BookingActivity.class);
                    intent.putExtra("updatedprice",upprice.getText().toString());
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                }
            }
        });

        getBidding();

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

    public void getBidding() {

        setUpRetrofit();
        gson=new Gson();
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Wait");
        progressDialog.setCancelable(false);
        progressDialog.show();
        ApiCalls apiCalls = retrofit.create(ApiCalls.class);
        Call<JsonObject> call = apiCalls.dbCallback();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                bidding=gson.fromJson(response.body(),BiddingClass.class);

                crat.setText(String.valueOf(bidding.getCreated_at()));
                upat.setText(String.valueOf(bidding.getUpdated_at()));
                pid.setText(String.valueOf(bidding.getId()));
                pickup.setText(String.valueOf(bidding.getPickup_date()));
                info.setText(String.valueOf(bidding.getTrucks_no_available())+" Trailer of "+String.valueOf(bidding.getTonnage())+" tons");
                from.setText(String.valueOf(bidding.getRoute_start()));
                to.setText(String.valueOf(bidding.getRoute_end()));
                qprice.setText(String.valueOf(bidding.getQuoted_price()));
                lqprice.setText(String.valueOf(bidding.getLast_quoted_price()));
                tid.setText(String.valueOf(bidding.getTrucker_id()));
                gps.setText(String.valueOf(bidding.getHas_GPS()));
                status.setText(String.valueOf(bidding.getRequest_state()));
                Log.v("Req",response.body().toString());
                progressDialog.dismiss();
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(BiddingActivity.this,"Check your internet connection",Toast.LENGTH_SHORT).show();
                Log.v("Req", "Error in api");
                progressDialog.dismiss();
            }
        });
    }
}
