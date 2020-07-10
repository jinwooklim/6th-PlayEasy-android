package com.prography.playeasy.match.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.lib.HorizontalCalendarManager;
import com.prography.playeasy.main.activity.Main;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.service.MatchService;
import com.prography.playeasy.util.PlayeasyServiceFactory;
import com.prography.playeasy.util.UIHelper;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class MatchCreate extends AppCompatActivity {

    private TimePicker sTimePicker;
    private TimePicker eTimePicker;
    Spinner matchtype;

    LocationDto locationDto;

    MatchDto matchDto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_create);

        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.matchCreateToolBar));

        HorizontalCalendarManager.initialize(this, new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

            }
        });

        /*TimePicker*/
        sTimePicker = findViewById(R.id.timePickerStart);
        eTimePicker = findViewById(R.id.timePickerEnd);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.진행방식, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        matchtype.setAdapter(adapter);
        //경기 진행 방식 스피너 아직 미구
        matchtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            }


        );
    }
//        findViewById(R.id.matchCreateConfirm).setOnClickListener((v) -> {
//            MatchRequestDto requestDto = new MatchRequestDto(
//                    ((EditText)findViewById(R.id.matchCreateTitle)).getText().toString(),
//                    ((EditText)findViewById(R.id.matchCreateType)).getText().toString(),
//                    ((EditText)findViewById(R.id.matchCreateDescription)).getText().toString(),
//                    ((EditText)findViewById(R.id.matchCreateLocation)).getText().toString(),
//                    Integer.valueOf(((EditText)findViewById(R.id.matchCreateFee)).getText().toString()),
//                    new Date(),
//                    new Date(),
//                    Integer.valueOf(((EditText)findViewById(R.id.matchCreateHomeQuota)).getText().toString())
//            );

//            MatchService service = PlayeasyServiceFactory.getInstance(MatchService.class);
//         //   service.createMatch(requestVO, this.getApplicationContext());
//        });
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.write_confirm, menu);
        MatchPostRequestDto requestVO = new MatchPostRequestDto();
        MatchService service = PlayeasyServiceFactory.getInstance(MatchService.class);
        service.createMatch(requestVO, this.getApplicationContext());

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.createMatch:
                Intent writeBack = new Intent(this, Main.class);
                startActivity(writeBack);


                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
