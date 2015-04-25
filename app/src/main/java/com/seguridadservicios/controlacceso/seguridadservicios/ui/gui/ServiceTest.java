package com.seguridadservicios.controlacceso.seguridadservicios.ui.gui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.seguridadservicios.controlacceso.seguridadservicios.R;
import com.seguridadservicios.controlacceso.seguridadservicios.service.GetAddService;

public class ServiceTest extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_service_test, menu);
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

    public void actualizar(View v){
        TextView usuario = (TextView) findViewById(R.id.textViewIdUsuario);
        TextView id = (TextView) findViewById(R.id.textViewId);
        TextView nombre = (TextView) findViewById(R.id.textViewNombre);
        TextView pass = (TextView) findViewById(R.id.textViewPassword);
        GetAddService gas;
        gas=new GetAddService();
        EditText num1= (EditText) findViewById(R.id.editTextNum1);

        EditText num2= (EditText) findViewById(R.id.editTextNum2);
        gas.setNum1(Integer.parseInt(num1.getText().toString()));
        gas.setNum2(Integer.parseInt(num2.getText().toString()));
        gas.accessWebService();

        for(int i=0;i < gas.getCasas().size();i++){
            nombre.setText(gas.getCasas().get(i).getNombre());
            id.setText(gas.getCasas().get(i).getId());
            usuario.setText(gas.getCasas().get(i).getUsuario());
            pass.setText(gas.getCasas().get(i).getPassword());

        }

        //Toast.makeText(getApplicationContext(), gas.getJsonResult(),
        //      Toast.LENGTH_LONG).show();


    }
}
