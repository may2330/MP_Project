package com.integratedideas.speechandaudio;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class HomeActivity extends Activity {

    private int r_left,r_right;
    private AlertDialog.Builder ad;

    public DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Button b1 = (Button)findViewById(R.id.b1);
        final Button b2 = (Button)findViewById(R.id.b2);
        final Button b3 = (Button)findViewById(R.id.b3);
        final Button b4 = (Button)findViewById(R.id.b4);

        final ListView lvPeople = (ListView)findViewById(R.id.lvPeople);
        Person person = new Person();

        lvPeople.setVisibility(View.VISIBLE);

        String etDBName = "testDB";
        dbHelper = new DBHelper(HomeActivity.this, etDBName, null, 1); dbHelper.testDB();

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                b1.setBackgroundResource(R.drawable.balad2);
                b2.setBackgroundResource(R.drawable.dance);
                b3.setBackgroundResource(R.drawable.pop);
                b4.setBackgroundResource(R.drawable.trot);

                if (dbHelper == null) {
                    dbHelper = new DBHelper(HomeActivity.this, "TEST", null, 1);
                }

                List people = dbHelper.getBaladMusicData();
                lvPeople.setAdapter(new PersonListAdapter(people, HomeActivity.this));

            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                b1.setBackgroundResource(R.drawable.balad);
                b2.setBackgroundResource(R.drawable.dance2);
                b3.setBackgroundResource(R.drawable.pop);
                b4.setBackgroundResource(R.drawable.trot);

                if (dbHelper == null) {
                    dbHelper = new DBHelper(HomeActivity.this, "TEST", null, 1);
                }
                List people = dbHelper.getDanceMusicData();
                lvPeople.setAdapter(new PersonListAdapter(people, HomeActivity.this));

            }
        });

        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                b1.setBackgroundResource(R.drawable.balad);
                b2.setBackgroundResource(R.drawable.dance);
                b3.setBackgroundResource(R.drawable.pop2);
                b4.setBackgroundResource(R.drawable.trot);

                if (dbHelper == null) {
                    dbHelper = new DBHelper(HomeActivity.this, "TEST", null, 1);
                }
                List people = dbHelper.getPopMusicData();
                lvPeople.setAdapter(new PersonListAdapter(people, HomeActivity.this));
            }
        });

        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                b1.setBackgroundResource(R.drawable.balad);
                b2.setBackgroundResource(R.drawable.dance);
                b3.setBackgroundResource(R.drawable.pop);
                b4.setBackgroundResource(R.drawable.trot2);

                if (dbHelper == null) {
                    dbHelper = new DBHelper(HomeActivity.this, "TEST", null, 1);
                }
                List people = dbHelper.getTrotMusicData();
                lvPeople.setAdapter(new PersonListAdapter(people, HomeActivity.this));

            }
        });

    }

    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
