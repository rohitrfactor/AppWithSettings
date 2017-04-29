package com.nagpal.garorasu.appwithsettings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PreferenceManager.setDefaultValues(this,	R.xml.pref_general,	false);
        PreferenceManager.setDefaultValues(this,	R.xml.pref_notification,	false);
        PreferenceManager.setDefaultValues(this,	R.xml.pref_account,	false);

        SharedPreferences	sharedPref	=
                PreferenceManager.getDefaultSharedPreferences(this);
        String	marketPref	=	sharedPref.getString("sync_frequency",	"-1");
        Toast.makeText(this,	marketPref,	Toast.LENGTH_SHORT).show();
/*
        SharedPreferences sharedPref	=
                PreferenceManager.getDefaultSharedPreferences(this);

        Boolean	switchPref	=	sharedPref.getBoolean
                (SettingsActivity.KEY_PREF_EXAMPLE_SWITCH,	false);

        Toast.makeText(this,switchPref.toString(),	Toast.LENGTH_SHORT).show();
*/
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
            Intent	intent	=	new Intent(this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
