package com.example.joey.screen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import android.widget.TextView;


import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedpreferences;

    //Test Commit2
    TextView mond;
    TextView tuesd;
    TextView wed;
    TextView thrud;
    TextView frid;

    TextView c1, c2, c3, c4, c5, c6;
    TextView h1, h2, h3, h4, h5, h6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if(!sharedpreferences.contains("runFirst")){
            resetPrefs();
        }

        setContentView(R.layout.frontscreen);



        mond = (TextView)findViewById(R.id.mondayOfficeHours);
        mond.setText(sharedpreferences.getString("monTxt", "DEFAULT"));
        tuesd = (TextView)findViewById(R.id.tuesDayOfficeHours);
        tuesd.setText(sharedpreferences.getString("tuesTxt", "DEFAULT"));
        wed = (TextView)findViewById(R.id.wednesdayOfficeHours);
        wed.setText(sharedpreferences.getString("wedTxt", "DEFAULT"));
        thrud = (TextView)findViewById(R.id.thursdayOfficeHours);
        thrud.setText(sharedpreferences.getString("thurTxt", "DEFAULT"));
        frid = (TextView)findViewById(R.id.fridayOfficeHours);
        frid.setText(sharedpreferences.getString("friTxt", "DEFAULT"));

        c1 = (TextView)findViewById(R.id.class1);
        c2 = (TextView)findViewById(R.id.class2);
        c3 = (TextView)findViewById(R.id.class3);
        c4 = (TextView)findViewById(R.id.class4);
        c5 = (TextView)findViewById(R.id.class5);
        c6 = (TextView)findViewById(R.id.class6);

        h1 = (TextView)findViewById(R.id.homework1);
        h2 = (TextView)findViewById(R.id.homework2);
        h3 = (TextView)findViewById(R.id.homework3);
        h4 = (TextView)findViewById(R.id.homework4);
        h5 = (TextView)findViewById(R.id.homework5);
        h6 = (TextView)findViewById(R.id.homework6);

        c1.setText(sharedpreferences.getString("class1Txt", "DEFAULT"));
        c2.setText(sharedpreferences.getString("class2Txt", "DEFAULT"));
        c3.setText(sharedpreferences.getString("class3Txt", "DEFAULT"));
        c4.setText(sharedpreferences.getString("class4Txt", "DEFAULT"));
        c5.setText(sharedpreferences.getString("class5Txt", "DEFAULT"));
        c6.setText(sharedpreferences.getString("class6Txt", "DEFAULT"));

        h1.setText(sharedpreferences.getString("homework1Txt", "DEFAULT"));
        h2.setText(sharedpreferences.getString("homework2Txt", "DEFAULT"));
        h3.setText(sharedpreferences.getString("homework3Txt", "DEFAULT"));
        h4.setText(sharedpreferences.getString("homework4Txt", "DEFAULT"));
        h5.setText(sharedpreferences.getString("homework5Txt", "DEFAULT"));
        h6.setText(sharedpreferences.getString("homework6Txt", "DEFAULT"));



    }





    public void resetPrefs(){
        SharedPreferences.Editor edit = sharedpreferences.edit();
        edit.putString("monTxt", "MON");
        edit.putString("tuesTxt", "TUES");
        edit.putString("wedTxt", "WED");
        edit.putString("thurTxt", "THUR");
        edit.putString("friTxt", "FRI");

        edit.putString("class1Txt", "Class 1");
        edit.putString("class2Txt", "Class 2");
        edit.putString("class3Txt", "Class 3");
        edit.putString("class4Txt", "Class 4");
        edit.putString("class5Txt", "Class 5");
        edit.putString("class6Txt", "Class 6");

        edit.putString("homework1Txt", "Homework 1");
        edit.putString("homework2Txt", "Homework 2");
        edit.putString("homework3Txt", "Homework 3");
        edit.putString("homework4Txt", "Homework 4");
        edit.putString("homework5Txt", "Homework 5");
        edit.putString("homework6Txt", "Homework 6");
        edit.putString("adminlogin", "default");


        edit.putBoolean("runFirst", true);

        edit.commit();
    }



    public void SendMsg(View view){
        Intent intent = new Intent(this, SendEmail.class);
        startActivity(intent);
    }

    public void DanielsEdit(View view){
        Intent intent = new Intent(this, EditInformation.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
