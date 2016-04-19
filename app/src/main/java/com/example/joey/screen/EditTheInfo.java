package com.example.joey.screen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditTheInfo extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedpreferences;

    EditText mon;
    EditText tues;
    EditText wed;
    EditText thur;
    EditText fri;
    EditText oldPass;
    EditText newPass;

    EditText c1, c2, c3, c4, c5, c6;
    EditText h1, h2, h3, h4, h5, h6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        setContentView(R.layout.activity_edit_the_info);

        mon = (EditText) findViewById(R.id.monedit);
        tues = (EditText) findViewById(R.id.tuesedit);
        wed = (EditText) findViewById(R.id.wededit);
        thur = (EditText) findViewById(R.id.thuredit);
        fri = (EditText) findViewById(R.id.fridedit);
        oldPass = (EditText) findViewById(R.id.oldPassword);
        newPass = (EditText) findViewById(R.id.newPassword);

        c1 = (EditText) findViewById(R.id.ce1);
        c2 = (EditText) findViewById(R.id.ce2);
        c3 = (EditText) findViewById(R.id.ce3);
        c4 = (EditText) findViewById(R.id.ce4);
        c5 = (EditText) findViewById(R.id.ce5);
        c6 = (EditText) findViewById(R.id.ce6);

        h1 = (EditText) findViewById(R.id.he1);
        h2 = (EditText) findViewById(R.id.he2);
        h3 = (EditText) findViewById(R.id.he3);
        h4 = (EditText) findViewById(R.id.he4);
        h5 = (EditText) findViewById(R.id.he5);
        h6 = (EditText) findViewById(R.id.he6);

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


        mon.setText(sharedpreferences.getString("monTxt", "DEFAULT"));
        tues.setText(sharedpreferences.getString("tuesTxt", "DEFAULT"));
        wed.setText(sharedpreferences.getString("wedTxt", "DEFAULT"));
        thur.setText(sharedpreferences.getString("thurTxt", "DEFAULT"));
        fri.setText(sharedpreferences.getString("friTxt", "DEFAULT"));

    }

    public void GoHome(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void OfficeHoursUpdate(View view){

        SharedPreferences.Editor edit = sharedpreferences.edit();
        edit.putString("monTxt", mon.getText().toString());
        edit.putString("tuesTxt", tues.getText().toString());
        edit.putString("wedTxt", wed.getText().toString());
        edit.putString("thurTxt", thur.getText().toString());
        edit.putString("friTxt", fri.getText().toString());


        edit.commit();

        Toast toast = Toast.makeText(getApplicationContext(),"Office Hours Updated",Toast.LENGTH_SHORT);
        toast.show();

    }

    public void PasswordUpdate(View view){

        if(oldPass.getText().toString().equals(sharedpreferences.getString("adminlogin", "DEFAULT"))){
            SharedPreferences.Editor edit = sharedpreferences.edit();
            edit.putString("adminlogin", newPass.getText().toString());
            edit.commit();

            Toast toast = Toast.makeText(getApplicationContext(), "Password Updated", Toast.LENGTH_SHORT);
            toast.show();

            oldPass.setText("");
            newPass.setText("");
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),"Wrong Current Password",Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void ClassesUpdate(View view){
        SharedPreferences.Editor edit = sharedpreferences.edit();

        edit.putString("class1Txt", c1.getText().toString());
        edit.putString("class2Txt", c2.getText().toString());
        edit.putString("class3Txt", c3.getText().toString());
        edit.putString("class4Txt", c4.getText().toString());
        edit.putString("class5Txt", c5.getText().toString());
        edit.putString("class6Txt", c6.getText().toString());

        edit.putString("homework1Txt", h1.getText().toString());
        edit.putString("homework2Txt", h2.getText().toString());
        edit.putString("homework3Txt", h3.getText().toString());
        edit.putString("homework4Txt", h4.getText().toString());
        edit.putString("homework5Txt", h5.getText().toString());
        edit.putString("homework6Txt", h6.getText().toString());

        edit.commit();

        Toast toast = Toast.makeText(getApplicationContext(),"Classes and Homework Set",Toast.LENGTH_SHORT);
        toast.show();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
