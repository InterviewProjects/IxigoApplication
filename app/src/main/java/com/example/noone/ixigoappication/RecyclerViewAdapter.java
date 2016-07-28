package com.example.noone.ixigoappication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.noone.ixigoappication.dataModels.ApiOutput;
import com.example.noone.ixigoappication.dataModels.FlightsDatum;

/**
 * Created by NoOne on 7/28/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    Context mContext;
    ApiOutput mApiOutput;

    public RecyclerViewAdapter(Context context, ApiOutput apiOutput) {
        this.mContext = context;
        this.mApiOutput = apiOutput;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_item, parent, false);

        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FlightsDatum flightsDatum;
        if (mApiOutput != null && (flightsDatum = mApiOutput.getFlightsData().get(position)) != null) {
            ItemHolder itemHolder = (ItemHolder) holder;

            // set flight type
            String flightType = "";
            if (mApiOutput.getAirlineMap().containsKey(flightsDatum.getAirlineCode())) {
                flightType = mApiOutput.getAirlineMap().get(flightsDatum.getAirlineCode());
            }
            itemHolder.flightType.setText(flightType);

            // set flight path
            String flightPath = "";
            if (!TextUtils.isEmpty(flightsDatum.getOriginCode()) && !TextUtils.isEmpty(flightsDatum.getDestinationCode())
                    && mApiOutput.getAirportMap().containsKey(flightsDatum.getOriginCode())
                    && mApiOutput.getAirportMap().containsKey(flightsDatum.getDestinationCode())) {
                flightPath = mApiOutput.getAirportMap().get(flightsDatum.getOriginCode()) + " To " +
                        mApiOutput.getAirportMap().get(flightsDatum.getDestinationCode());
            }
            itemHolder.flightPath.setText(flightPath);

            // set class
            String className = "";
            if (!TextUtils.isEmpty(flightsDatum.getClass_())) {
                className = flightsDatum.getClass_();
            }
            itemHolder.classPath.setText(className);

            // set take off timings
            String takeOffMillis = flightsDatum.getTakeoffTime();
            if (!TextUtils.isEmpty(takeOffMillis)) {
                Utils.Time time = Utils.getTiming(takeOffMillis);

                itemHolder.takeOffDate.setText(time.date);
                itemHolder.takeOffTime.setText(time.time);
            }

            // set landing timings
            String landingTimings = flightsDatum.getLandingTime();
            if (!TextUtils.isEmpty(landingTimings)) {
                Utils.Time time = Utils.getTiming(landingTimings);

                itemHolder.landingDate.setText(time.date);
                itemHolder.landingTime.setText(time.time);
            }

            String price ="";
            if (!TextUtils.isEmpty(flightsDatum.getPrice())) {
                price = "Rs." + flightsDatum.getPrice();
            }
            itemHolder.price.setText(price);
        }
    }

    @Override
    public int getItemCount() {
        if (mApiOutput == null || mApiOutput.getFlightsData() == null) {
            return 0;
        } else {
            return mApiOutput.getFlightsData().size();
        }
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        TextView flightType;
        TextView flightPath;
        TextView classPath;
        TextView takeOffDate;
        TextView takeOffTime;
        TextView landingDate;
        TextView landingTime;
        TextView price;


        public ItemHolder(View itemView) {
            super(itemView);

            flightType = (TextView) itemView.findViewById(R.id.flight_type);
            flightPath = (TextView) itemView.findViewById(R.id.flight_path);
            classPath = (TextView) itemView.findViewById(R.id.class_type);
            takeOffDate = (TextView) itemView.findViewById(R.id.take_off_date);
            takeOffTime = (TextView) itemView.findViewById(R.id.take_off_time);
            landingDate = (TextView) itemView.findViewById(R.id.landing_date);
            landingTime = (TextView) itemView.findViewById(R.id.landing_time);
            price = (TextView) itemView.findViewById(R.id.price_value);
        }
    }
}
