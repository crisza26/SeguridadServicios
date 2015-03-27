package com.seguridadservicios.controlacceso.seguridadservicios.ui.gui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.seguridadservicios.controlacceso.seguridadservicios.R;
import com.seguridadservicios.controlacceso.seguridadservicios.model.DoorModel;
import com.seguridadservicios.controlacceso.seguridadservicios.model.UserAccessModel;
import com.seguridadservicios.controlacceso.seguridadservicios.ui.listas.ListViewSelectSimple;
import com.seguridadservicios.controlacceso.seguridadservicios.util.Utilities;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class FrontDoorActivity extends ActionBarActivity {
    DoorModel doorModel = new DoorModel();
    boolean abierta = false;
    Animation scalar;
    @InjectView(R.id.id_switch_status)
    ImageView ivIvSwitchStatus;
    @InjectView(R.id.id_getusers)
    Button ivBtGetUsers;
    @InjectView(R.id.id_history)
    Button ivBtHistory;

    public List<UserAccessModel> listUsers = new ArrayList<UserAccessModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_door);
        ButterKnife.inject(this);
        scalar = AnimationUtils.loadAnimation(this, R.anim.scale_buttom);
        loadListUsers();
    }

    public void loadListUsers() {
        //Aquí se debe llenar el ListUSer desde el API
        //TODO: Se llena con datos de prueba
        int con = 10;
        for (int i = 0, sizeLst = listUsers.size(); i < con; ++i) {
            listUsers.add(new UserAccessModel("" + i, "nombre" + i, "apellido" + i, "51564654564", "email"));
        }
    }

    @OnClick(R.id.id_history)
    public void historyAccess(View view){
        view.startAnimation(scalar);
        Intent intHistory = new Intent(FrontDoorActivity.this, HistoryDoorAccessActivity.class);
        startActivity(intHistory);
    }

    @OnClick(R.id.id_getusers)
    public void getUsersAcces(View view) {
        view.startAnimation(scalar);
        ListViewSelectSimple.show(this, listUsers, R.string.LBL_BT_USERSACCESS, Utilities.OPEN_LIST_USERSACCES);
    }

    @OnClick(R.id.id_switch_status)
    public void switchStatus(View view) {
        if (abierta) {//se debe cerrar la puerta
            Picasso.with(FrontDoorActivity.this)
                    .load(R.drawable.off)
                    .into(ivIvSwitchStatus);
            doorModel.estado = false;
        } else {//se debe abrir
            Picasso.with(FrontDoorActivity.this)
                    .load(R.drawable.on)
                    .into(ivIvSwitchStatus);
            doorModel.estado = true;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_front_door, menu);
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
