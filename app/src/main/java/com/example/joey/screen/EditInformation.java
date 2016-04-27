package com.example.joey.screen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditInformation extends AppCompatActivity {


    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        setContentView(R.layout.adminlogin);
        //sets the default password if needed
        if(!sharedpreferences.contains("adminlogin")){
            SharedPreferences.Editor edit = sharedpreferences.edit();
            edit.putString("adminlogin","default");
            edit.commit();
        }

    }


    //Login button class
    public void AdminLogin(View view){
        EditText pass = (EditText)findViewById(R.id.passwordLogin);

        //if password is correct
        if(pass.getText().toString().equals(sharedpreferences.getString("adminlogin","DEFAULT"))){
            Intent intent = new Intent(this, EditTheInfo.class);
            startActivity(intent);
            pass.setText("");
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),"Wrong Password",Toast.LENGTH_SHORT);
            toast.show();
            pass.setText("");
        }
    }


}
