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

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;

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


    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_hello_map, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.choosemap)
        {
            // react to the menu item being selected...
            Intent intent = new Intent(this,MapChooseActivity.class);
            startActivityForResult(intent,0);
            return true;
        }

        else if(item.getItemId() == R.id.setlocation)
        {
            Intent intent = new Intent (this,SetLocationActivity.class);
            startActivityForResult(intent,1);
            return true;
        }
        return false;

    }

    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {

        if(requestCode==0)
        {

            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                boolean cyclemap = extras.getBoolean("com.example.cyclemap");
                if(cyclemap==true)
                {
                    mv.setTileSource(TileSourceFactory.CYCLEMAP);
                }
                else
                {
                    mv.getTileProvider().setTileSource(TileSourceFactory.MAPNIK);
                }
            }
        }

        else if(requestCode==1)
        {

            if (resultCode==RESULT_OK)
            {

                Bundle extras=intent.getExtras();
                double latitude = extras.getDouble("com.example.1rogee03.latitude");
                double longitude = extras.getDouble("com.example.1rogee03.longitude");

                mv.getController().setCenter(new GeoPoint(longitude,latitude));


            }

        }
    }


}