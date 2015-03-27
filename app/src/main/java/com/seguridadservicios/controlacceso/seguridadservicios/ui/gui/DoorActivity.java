package com.seguridadservicios.controlacceso.seguridadservicios.ui.gui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.seguridadservicios.controlacceso.seguridadservicios.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class DoorActivity extends Activity {
    Animation scalar;
    @InjectView(R.id.id_pppal)
    Button ivBtPrincipal;
    @InjectView(R.id.id_phab)
    Button ivBtHabitacion;
    @InjectView(R.id.id_phabd)
    Button getIvBtHabitacion2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puertas);
        ButterKnife.inject(this);
        scalar = AnimationUtils.loadAnimation(this, R.anim.scale_buttom);
    }

    @OnClick(R.id.id_pppal)
    public void principal(View view) {
        view.startAnimation(scalar);
    }

    @OnClick(R.id.id_phab)
    public void habitacion1(View view) {
        view.startAnimation(scalar);
    }

    @OnClick(R.id.id_phabd)
    public void habitacion2(View view) {
        view.startAnimation(scalar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_puertas, menu);
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
