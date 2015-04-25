package com.seguridadservicios.controlacceso.seguridadservicios.ui.gui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.seguridadservicios.controlacceso.seguridadservicios.R;
import com.seguridadservicios.controlacceso.seguridadservicios.service.CatchKeyService;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class HomeActivity extends Activity {
    Animation scalar;
    @InjectView(R.id.id_puertas)
    Button ivBtPuertas;
    @InjectView(R.id.id_permisos)
    Button ivBtPermisos;
    @InjectView(R.id.id_bpanico)
    Button ivBtPanico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);
        scalar = AnimationUtils.loadAnimation(this, R.anim.scale_buttom);
        getActionBar().setTitle(" ");

        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM, ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowCustomEnabled(true);
        getActionBar().setDisplayShowTitleEnabled(true);
        TextView title = new TextView(getApplicationContext());
        title.setText(R.string.TITULO_HOME);
        title.setId(android.R.id.text1);
        title.setTextColor(getResources().getColor(R.color.witheLetter));
        title.setGravity(Gravity.CENTER);
        // getActionBar().setCustomView(title);
    }

    @OnClick(R.id.id_puertas)
    public void puertas(View view) {
        view.startAnimation(scalar);
        Intent inetPuertas = new Intent(HomeActivity.this, DoorActivity.class);
        startActivity(inetPuertas);
    }

    @OnClick(R.id.id_permisos)
    public void permisos(View view) {
        view.startAnimation(scalar);
        Intent inetPermisos = new Intent(HomeActivity.this, PermissionsActivity.class);
        startActivity(inetPermisos);
    }

    @OnClick(R.id.id_bpanico)
    public void panico(View view) {
        view.startAnimation(scalar);
    }

    @OnClick(R.id.id_bgenerarclave)
    public void generarclave(View view) {
        view.startAnimation(scalar);
        CatchKeyService cks = new CatchKeyService();
        cks.accessWebService();


        Toast.makeText(getApplicationContext(),
               SinPublicidad(cks.getJsonResult()), Toast.LENGTH_SHORT).show();
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
    public String SinPublicidad(String str){
        String temp="";
        for(int i =0;i< str.length();i++){
            if(str.charAt(i)!='<') {
                temp = temp + str.charAt(i);
            }else{
                break;
            }
        }
        return temp;
    }
}
