package com.seguridadservicios.controlacceso.seguridadservicios.ui.gui;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.seguridadservicios.controlacceso.seguridadservicios.R;

import java.util.ArrayList;

public class RegisteredActivity extends ActionBarActivity {
    public void pintartablita(){

        ScrollView tps=(ScrollView)findViewById(R.id.scrollView_activityRegistered);
        tps.removeAllViews();

        TableLayout sv = new TableLayout(this);



        // ENCABEZADO
        for(int i=0;i < 1;i++) {

            TableRow tr=new TableRow(this);
            TableLayout.LayoutParams tableRowParams=
                    new TableLayout.LayoutParams
                            (TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);
            tr.setLayoutParams(tableRowParams);

            ShapeDrawable border = new ShapeDrawable(new RectShape());
            border.getPaint().setStyle(Paint.Style.STROKE);
            border.getPaint().setColor(Color.BLACK);


            TextView nombrePasajero = new TextView(this);
            nombrePasajero.setPadding(5,5,5,5);
            nombrePasajero.setBackground(border);
            TextView correoPasajero = new TextView(this);
            correoPasajero.setPadding(5, 5, 5, 5);
            correoPasajero.setBackground(border);

            nombrePasajero.setText("NAME");
            correoPasajero.setText("");
            tr.addView(nombrePasajero);
            tr.addView(correoPasajero);
            sv.addView(tr);
        }

        for(int i=0;i < 1;i++) {

            TableRow tr=new TableRow(this);
            TableLayout.LayoutParams tableRowParams=
                    new TableLayout.LayoutParams
                            (TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);
            tr.setLayoutParams(tableRowParams);

            ShapeDrawable border = new ShapeDrawable(new RectShape());
            border.getPaint().setStyle(Paint.Style.STROKE);
            border.getPaint().setColor(Color.BLACK);


            TextView nombrePasajero = new TextView(this);
            nombrePasajero.setPadding(5,5,5,5);
            nombrePasajero.setBackground(border);
            TextView correoPasajero = new TextView(this);
            correoPasajero.setPadding(5, 5, 5, 5);
            correoPasajero.setBackground(border);

            nombrePasajero.setText("Jeronimo");
            correoPasajero.setText("Admin.");
            tr.addView(nombrePasajero);
            tr.addView(correoPasajero);
            sv.addView(tr);
        }
        ArrayList<String> personasRegistradas= new ArrayList<String >();
        personasRegistradas.add("Filomena");
        personasRegistradas.add("D'artagnan");
        personasRegistradas.add("portos");
        for(int i=0;i < personasRegistradas.size();i++) {

            TableRow tr=new TableRow(this);
            TableLayout.LayoutParams tableRowParams=
                    new TableLayout.LayoutParams
                            (TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);
            tr.setLayoutParams(tableRowParams);

            ShapeDrawable border = new ShapeDrawable(new RectShape());
            border.getPaint().setStyle(Paint.Style.STROKE);
            border.getPaint().setColor(Color.BLACK);

            CheckBox cb=new CheckBox(this);


            TextView nombrePasajero = new TextView(this);
            nombrePasajero.setPadding(5, 5, 5, 5);
nombrePasajero.setBackground(border);

            cb.setPadding(5, 5, 5, 5);
            cb.setBackground(border);

            nombrePasajero.setText(personasRegistradas.get(i));
            ImageButton ib=new ImageButton(this);
            ib.setImageResource(R.drawable.botoncitos);
            ib.setPadding(5, 5, 5, 5);
            ib.setBackground(border);
tr.addView(nombrePasajero);

            tr.addView(ib);
            sv.addView(tr);
        }
        ShapeDrawable border = new ShapeDrawable(new RectShape());
        border.getPaint().setStyle(Paint.Style.STROKE);
        border.getPaint().setColor(Color.BLACK);
sv.setBackground(border);
        tps.addView(sv);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
       // pintartablita();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registered, menu);
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
