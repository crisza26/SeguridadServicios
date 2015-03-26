package com.seguridadservicios.controlacceso.seguridadservicios.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.seguridadservicios.controlacceso.seguridadservicios.R;

import butterknife.ButterKnife;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);

        getActionBar().setTitle(" ");

        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM, ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowCustomEnabled(true);
        getActionBar().setDisplayShowTitleEnabled(true);
        TextView title = new TextView(getApplicationContext());
        title.setText("SEGURIDAD & SERVICIOS");
        title.setId(android.R.id.text1);
        title.setTextColor(getResources().getColor(R.color.witheLetter));
        title.setGravity(Gravity.CENTER);
       // getActionBar().setCustomView(title);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
