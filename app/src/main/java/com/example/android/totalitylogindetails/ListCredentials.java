package com.example.android.totalitylogindetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListCredentials extends AppCompatActivity {

    TextView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_credentials);

        list=(TextView)findViewById(R.id.list);
        list.setText(MainActivity.dataRecieved);

    }
}
