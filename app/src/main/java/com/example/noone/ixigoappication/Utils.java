package com.example.noone.ixigoappication;

import com.example.noone.ixigoappication.dataModels.ApiOutput;
import com.example.noone.ixigoappication.dataModels.FlightsDatum;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by NoOne on 7/28/2016.
 */
public class Utils {
    public static class Time {
        public String date;
        public String time;
    }
    public static Time getTiming(String millis) {
        Time time = new Time();

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, hh:mm a");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.parseLong(millis));
            String formattedString = formatter.format(calendar.getTime());

            time.date = formattedString.split(",")[0].trim();
            time.time = formattedString.split(",")[1].trim();

        } catch (Exception e) {
            time.date = "";
            time.time = "";
        }

        return time;
    }

    public static void sortAccordingToPrice(ApiOutput apiOutput) {
        if (apiOutput != null && apiOutput.getFlightsData() != null) {
            List<FlightsDatum> list = apiOutput.getFlightsData();

            Collections.sort(list, new Comparator<FlightsDatum>() {
                @Override
                public int compare(FlightsDatum o1, FlightsDatum o2) {
                    return Integer.parseInt(o1.getPrice()) - Integer.parseInt(o2.getPrice());
                }
            });
        }
    }

    public static void sortAccordingToTakeOffTimings(ApiOutput apiOutput) {
        if (apiOutput != null && apiOutput.getFlightsData() != null) {
            List<FlightsDatum> list = apiOutput.getFlightsData();

            Collections.sort(list, new Comparator<FlightsDatum>() {
                @Override
                public int compare(FlightsDatum o1, FlightsDatum o2) {
                    return (int)(Long.parseLong(o1.getTakeoffTime()) - Long.parseLong(o2.getTakeoffTime()));
                }
            });
        }
    }

    public static void sortAccordingToLandingTimings(ApiOutput apiOutput) {
        if (apiOutput != null && apiOutput.getFlightsData() != null) {
            List<FlightsDatum> list = apiOutput.getFlightsData();

            Collections.sort(list, new Comparator<FlightsDatum>() {
                @Override
                public int compare(FlightsDatum o1, FlightsDatum o2) {
                    return (int)(Long.parseLong(o1.getLandingTime()) - Long.parseLong(o2.getLandingTime()));
                }
            });
        }
    }
}
