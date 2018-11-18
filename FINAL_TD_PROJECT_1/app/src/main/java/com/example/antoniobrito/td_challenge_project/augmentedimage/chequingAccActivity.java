package com.example.antoniobrito.td_challenge_project.augmentedimage;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.antoniobrito.td_challenge_project.common.helpers.CircleMenu2;
import com.example.antoniobrito.td_challenge_project.common.helpers.OnMenuSelectedListener;

public class chequingAccActivity extends AppCompatActivity {

    String arrayName[] = {"unlimited", "allinclusive", "unlimited", "everyday", "student" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chequing_acc);

        CircleMenu2 circleMenu2 = (CircleMenu2) findViewById(R.id.circle);
        circleMenu2.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.td_button_up, R.drawable.td_button_down)
                .addSubMenu(Color.parseColor("#ffffff"),R.drawable.unlimitedpiggy)
                .addSubMenu(Color.parseColor("#ffffff"),R.drawable.allinclusivepiggy)
                .addSubMenu(Color.parseColor("#ffffff"),R.drawable.minimumpiggy)
                .addSubMenu(Color.parseColor("#ffffff"),R.drawable.studentpiggy)
                .addSubMenu(Color.parseColor("#ffffff"),R.drawable.everydaypiggy)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {

                        if(index == 0){
                            Intent intent =null;
                            intent = new Intent(chequingAccActivity.this, allInclusiveAct.class);
                            startActivity(intent);
                        }

                    }
                });
    }
}
