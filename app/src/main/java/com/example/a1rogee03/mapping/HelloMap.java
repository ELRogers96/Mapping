package com.example.a1rogee03.mapping;

import android.app.Activity;
import org.osmdroid.config.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;

public class HelloMap extends Activity implements OnClickListener
{

    MapView mv;

    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button SubmitButton = (Button) findViewById(R.id.SubmitButton);
        SubmitButton.setOnClickListener(this);

        // this line tells OpenStreetMap about our app.
        // If you miss this out, you might get banned from OSM servers
        Configuration.getInstance().load
                (this, PreferenceManager.getDefaultSharedPreferences(this));

        mv = (MapView)findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(14);
        mv.getController().setCenter(new GeoPoint(40.1,22.5));
    }

    @Override
    public void onClick(View v) {
        // Retrieve Latitude
        EditText LatitudeEditText = (EditText) findViewById(R.id.LatitudeEditText);
        double latitude = Double.parseDouble(LatitudeEditText.getText().toString());

        EditText LongitudeEditText = (EditText) findViewById(R.id.LongitudeEditText);
        double longitude = Double.parseDouble(LongitudeEditText.getText().toString());
    }
}