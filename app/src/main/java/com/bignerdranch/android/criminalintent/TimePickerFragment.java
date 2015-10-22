package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextClock;
import android.widget.TimePicker;
import android.text.format.DateFormat;


import java.sql.Time;
import java.sql.Timestamp;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Adam on 10/21/2015.
 */
public class TimePickerFragment extends android.support.v4.app.DialogFragment {
    public static final String EXTRA_TIME = "com.bignerdranch.android.criminalintent.date";
    private Date mTimer;

    public static TimePickerFragment newInstance(Date time){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_TIME, time);

        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);

        return fragment;
    }

    private void sendResult(int resultCode){
        if(getTargetFragment() == null){return;}

        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME, mTimer);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mTimer = (Date) getArguments().getSerializable(EXTRA_TIME);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mTimer);
        int hour = calendar.get(calendar.HOUR_OF_DAY);
        int minute = calendar.get(calendar.MINUTE);

        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_time, null);

        TimePicker mTimePicker = (TimePicker) v.findViewById(R.id.dialog_time_time_picker);
        mTimePicker.setCurrentHour(hour);
        mTimePicker.setCurrentMinute(minute);

        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){
           @Override
        public void onTimeChanged(TimePicker view, int hour, int minute){
               mTimer.setHours(hour);
               mTimer.setMinutes(minute);
           }
        });

        return new AlertDialog.Builder(getActivity()).setView(v).setTitle(R.string.time_picker_title).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendResult(Activity.RESULT_OK);
            }
        }).create();
    }

}


