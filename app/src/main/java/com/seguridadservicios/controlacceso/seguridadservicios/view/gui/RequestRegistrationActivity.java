package com.seguridadservicios.controlacceso.seguridadservicios.view.gui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.seguridadservicios.controlacceso.seguridadservicios.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class RequestRegistrationActivity extends Activity {
    @InjectView(R.id.id_req_send)
    Button ivBtSend;
    @InjectView(R.id.id_req_cancel)
    Button ivBtCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_registration);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.id_req_send)
    public void send(View view) {
        Toast.makeText(getBaseContext(), "La petición se ha enviado satisfactoriamente", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.id_req_cancel)
    public void cancel(View view) {
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_request_registration, menu);
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
