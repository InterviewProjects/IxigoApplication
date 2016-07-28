package com.example.noone.ixigoappication;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.noone.ixigoappication.dataModels.ApiOutput;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView recyclerView;
    RecyclerViewAdapter mAdapter;
    ApiOutput mApiOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout sortLayout = (LinearLayout) findViewById(R.id.sort_layout);
        sortLayout.setOnClickListener(this);

        mApiOutput = new ApiOutput();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new RecyclerViewAdapter(this, mApiOutput);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        Call<ApiOutput> call = ApiRestAdapter.getRestService().getDataFromServer();
        call.enqueue(new Callback<ApiOutput>() {
            @Override
            public void onResponse(Call<ApiOutput> call, Response<ApiOutput> response) {
                ApiOutput apiOutput = response.body();
                mApiOutput.setAirlineMap(apiOutput.getAirlineMap());
                mApiOutput.setAirportMap(apiOutput.getAirportMap());
                mApiOutput.setFlightsData(apiOutput.getFlightsData());

                if (mAdapter != null) {
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ApiOutput> call, Throwable t) {
                System.out.println("no");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sort_layout:
                showSortDialog();
                break;
        }
    }

    Dialog sortDialog;
    private void showSortDialog() {
        if (sortDialog != null) {
            sortDialog.dismiss();
        }
        sortDialog = new Dialog(this);
        sortDialog.setTitle("SORT");
        sortDialog.setContentView(R.layout.sort_layout);

        TextView priceSort = (TextView) sortDialog.findViewById(R.id.price_sort);
        TextView takeOffSort = (TextView) sortDialog.findViewById(R.id.take_off_sort);
        TextView landingSort = (TextView) sortDialog.findViewById(R.id.landing_sort);

        priceSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.sortAccordingToPrice(mApiOutput);

                if (mAdapter != null) {
                    mAdapter.notifyDataSetChanged();
                }

                sortDialog.dismiss();
            }
        });

        takeOffSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.sortAccordingToTakeOffTimings(mApiOutput);

                if (mAdapter != null) {
                    mAdapter.notifyDataSetChanged();
                }

                sortDialog.dismiss();
            }
        });

        landingSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.sortAccordingToLandingTimings(mApiOutput);

                if (mAdapter != null) {
                    mAdapter.notifyDataSetChanged();
                }

                sortDialog.dismiss();
            }
        });

        sortDialog.show();
    }
}
