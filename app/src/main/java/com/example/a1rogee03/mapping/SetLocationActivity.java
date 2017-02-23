package com.example.a1rogee03.mapping;

import android.app.Activity;
import org.osmdroid.config.Configuration;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;


public class SetLocationActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_set_location);
        Button submitButton =(Button) findViewById(R.id.SubmitButton2);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText LatitudeEditText = (EditText) findViewById(R.id.editText3);
        double latitude = Double.parseDouble(LatitudeEditText.getText().toString());

        EditText LongititudeEditText = (EditText) findViewById(R.id.editText4);
        double longitude = Double.parseDouble(LongititudeEditText.getText().toString());

        Bundle bundle=new Bundle();
        bundle.putDouble("com.example.1rogee03.latitude",latitude);
        bundle.putDouble("com.example.1rogee03.longitude",longitude);

        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();

    }
}
