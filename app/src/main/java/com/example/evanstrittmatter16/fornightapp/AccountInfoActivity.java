package com.example.evanstrittmatter16.fornightapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;


public class AccountInfoActivity extends AppCompatActivity {

    private  String acc;
    private List<Stats> stats;
    private String wins;

    private TextView accountInfo;
    private TextView totalStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountinfo);
        wireWidgets();

        Intent accountIntent = getIntent();
        acc = accountIntent.getStringExtra("account");
        Intent statIntent = getIntent();
        stats = statIntent.getParcelableArrayListExtra("stats");
        //Toast.makeText(this, "this works again" + acc, Toast.LENGTH_SHORT).show();



        ;
        wins = stats.get(8).getValue();


//        Stats is:
//                0 Top 5
//                1 Top 3
//                2 Top 6
//                3 Top 10
//                4 Top 12
//                5 Top 25
//                6 Score
//                7 Matches played
//                8 wins
//                9 Win%
//                10 Kills
//                11 k/d
        //

        accountInfo.setText("If you want more information about your account, your Account ID is: " + acc);
        totalStats.setText("You have " + wins + " wins." + "\n" + "\n" +
                "Your score is " + stats.get(6).getValue() + "." + "\n" + "\n" +
                "You have " + stats.get(10).getValue() + " kills, however your K/d is only " + stats.get(11).getValue() + "." + "\n" + "\n" +
                "So far you have placed in the top 25: " + stats.get(5).getValue() + " times,  in the top 10: " + stats.get(3).getValue() + " times, and  in the top 3: " + stats.get(1).getValue() + " times."
        );


    }



    private void wireWidgets() {
        accountInfo = findViewById(R.id.textview_accountinfo_accountid);
        totalStats = findViewById(R.id.textview_accountinfo_totalwins);
    }


}
