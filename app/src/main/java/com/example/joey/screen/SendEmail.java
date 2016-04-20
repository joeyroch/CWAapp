package com.example.joey.screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SendEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.emailpage);

    }

    public void goHome(View view){
        finish();

    }

    public void sendTheEmail(View view){
        EditText userEmail = (EditText) (findViewById(R.id.userEmail));
        String email = userEmail.getText().toString();



        EditText userSubject = (EditText)(findViewById(R.id.userSubject));
        String subject = userSubject.getText().toString();

        EditText userBody = (EditText)(findViewById(R.id.userBody));
        String body = userBody.getText().toString();

        EditText name = (EditText)(findViewById(R.id.userName));
        String userName = name.getText().toString();

        if(userName.length() == 0){
            userName = "(No Name)";
        }
        if(email.length() == 0){
            email = "(No Email)";
        }
        if(body.length() == 0){
            Toast toast = Toast.makeText(getApplicationContext(),"Body Required",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if(subject.length() == 0){
            subject = "(No Subject)";
        }


        Log.i("Send email", "");
        String[] TO = {"joey.rochford97@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"joey.rochford97@gmail.com"}); //to email
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "From DoorTablet: " + subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Name:  "+ userName + "   Email:  " + email +   "     Body:   " + body );

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            Toast toast = Toast.makeText(getApplicationContext(),"Hit Send (Top Right) or Review Your Message",Toast.LENGTH_LONG);
            toast.show();

            Log.i("Finished sending email.", "");

        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(SendEmail.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }
}
