package com.prography.playeasy.main.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.prography.playeasy.R;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.mypage.activity.MyPage;
import com.prography.playeasy.util.UIHelper;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


public class Main extends AppCompatActivity {

    private static final String TAG = "JWT_TOKEN";
    private HorizontalCalendar horizontalCalendar;
    //매치 화면 정보 받아오는 화면인데 아직 구현 안됨
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_custom);

        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.MainToolbar));
        UIHelper.bottomNavigationInitialize(this, findViewById(R.id.bottomNavigation));

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                //do something
            }
        });

        Log.d(TAG, TokenManager.get(getApplicationContext()));


    }



    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.myPageNavigatation:
                Intent movedMypage = new Intent(this, MyPage.class);
                startActivity(movedMypage);
                break;

        }
        return super.onOptionsItemSelected(item);
    }



}
