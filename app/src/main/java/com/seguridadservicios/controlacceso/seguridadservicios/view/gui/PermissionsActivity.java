package com.seguridadservicios.controlacceso.seguridadservicios.view.gui;

import android.app.Activity;
import android.content.Intent;
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

public class PermissionsActivity extends Activity {
    Animation scalar;

    @InjectView(R.id.id_registrado)
    Button ivBtRegistrado;
    @InjectView(R.id.id_invitado)
    Button ivBtInvitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);
        ButterKnife.inject(this);
        scalar = AnimationUtils.loadAnimation(this, R.anim.scale_buttom);
    }

    @OnClick(R.id.id_registrado)
    public void registrado(View view) {
        view.startAnimation(scalar);
        Intent inetRegi = new Intent(PermissionsActivity.this, RegisteredActivity.class);
        startActivity(inetRegi);
    }

    @OnClick(R.id.id_invitado)
    public void invitado(View view) {
        view.startAnimation(scalar);
       // Intent inetRegi = new Intent(PermissionsActivity.this, RegisteredActivity.class);
       // startActivity(inetRegi);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_permissions, menu);
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
