package com.bignerdranch.android.criminalintent;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Adam on 10/5/2015.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private Date mTime;
    private boolean mSolved;
    private String mSuspect;

    public Crime(){
        //generate unique id
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public UUID getId(){
        return mId;
    }

    public String getTitle(){
        return mTitle;
    }

    public void setTitle(String title){
        mTitle = title;
    }

    public Date getDate(){
        return mDate;
    }

    public void setDate(Date date){
        mDate = date;
    }

    public boolean isSolved(){
        return mSolved;
    }

    public void setSolved(boolean solved){
        mSolved = solved;
    }

    public String getSuspect(){
        return mSuspect;
    }

    public void setSuspect(String suspect){
        mSuspect = suspect;
    }

    public Date getTime() { return mTime;}

    public void setTime(Date time) {mTime = time;}
}
