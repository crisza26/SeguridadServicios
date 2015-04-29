package com.seguridadservicios.controlacceso.seguridadservicios.view.gui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.seguridadservicios.controlacceso.seguridadservicios.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class PesonalDataActivity extends ActionBarActivity {
    Animation scalar;
    @InjectView(R.id.id_savepersonal)
    Button ivBtSavePersonal;
    @InjectView(R.id.first_name)
    EditText ivEtName;
    @InjectView(R.id.last_name)
    EditText ivEtLastname;
    @InjectView(R.id.id_personal)
    EditText ivEtId;
    @InjectView(R.id.id_relation)
    EditText ivEtRelation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesonal_data);
        ButterKnife.inject(this);
        scalar = AnimationUtils.loadAnimation(this, R.anim.scale_buttom);
    }

    @OnClick(R.id.id_savepersonal)
    public void guardarInformacion(View view) {
        Toast.makeText(getBaseContext(), "El usuario ha sido registrado satisfactoriamente", Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pesonal_data, menu);
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
