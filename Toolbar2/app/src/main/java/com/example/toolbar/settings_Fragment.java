package com.example.toolbar;

import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class settings_Fragment extends Fragment
{
    TextView textView;
    Button button;
    View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_settings_, container, false);

        textView = rootview.findViewById(R.id.time_tv);
        button = rootview.findViewById(R.id.time_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                final Calendar c = Calendar.getInstance();

                int hour = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minOfDay) {
                        String AM_PM = null;
                        if(hourOfDay>12)
                        {
                            hourOfDay=(hourOfDay-12);
                            AM_PM ="PM";
                        }
                        else if(hourOfDay<12)
                        {
                            AM_PM ="AM";
                        }
                        else
                        {
                            AM_PM = "PM";
                        }
                        textView.setText( hourOfDay + ":" + minOfDay+" "+AM_PM);
                    }
                },hour,min,false);
                timePickerDialog.show();
            }
            });

        return rootview;


    }
}