package com.steppschuh.estirator;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;


public class MainActivity extends ActionBarActivity {

    MobileApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app = (MobileApp) getApplication();
        if (!app.isInitialized) {
            app.initialize(this);
        } else {
            app.setContextActivity(this);
        }

        if (savedInstanceState == null) {
            showEstimator();
        }
    }

    public void showEstimator() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new FragmentEstimator())
                .commit();
    }

    public void showEstimationResults() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new FragmentEstimationResults())
                .commit();
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
