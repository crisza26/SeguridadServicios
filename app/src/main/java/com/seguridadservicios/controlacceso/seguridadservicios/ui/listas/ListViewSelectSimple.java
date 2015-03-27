package com.seguridadservicios.controlacceso.seguridadservicios.ui.listas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.seguridadservicios.controlacceso.seguridadservicios.R;
import com.seguridadservicios.controlacceso.seguridadservicios.model.ListViewUserAccess;
import com.seguridadservicios.controlacceso.seguridadservicios.model.UserAccessModel;
import com.seguridadservicios.controlacceso.seguridadservicios.ui.adapter.UserAccessAdapter;

import org.w3c.dom.UserDataHandler;

import java.util.List;

/**
 * Created by Dianita on 26/03/2015.
 */
public class ListViewSelectSimple extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    public static final int LIST_VIEW_SELECT_OK = -1;
    public static final int LIST_VIEW_SELECT_CANCEL = 0;

    private static Activity instance;
    private UserAccessAdapter listViewItemAdapter;
    private static List<UserAccessModel> lstItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_simple);

        //si se envio el titulo
        if(getIntent().hasExtra("title")) {
            //se obtiene como una objeto ya que puede ser un String o un Integer
            Object title = getIntent().getExtras().get("title");

            //se obtiene el TextView donde se mostrara el titulo
            TextView lblTitle = (TextView) findViewById(R.id.lblTitle);

            if(title instanceof String) {
                lblTitle.setText((String) title);
            } else if(title instanceof Integer) {
                lblTitle.setText((Integer) title);
            }
        }

        //se define el evento para el boton back
        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        //se construye el el ListView para mostrar los items
        ListView listView = (ListView) findViewById(R.id.id_list_view);
        listViewItemAdapter = new UserAccessAdapter(this, R.layout.activity_list_view_simple, lstItems, getResources());
        listView.setAdapter(listViewItemAdapter);
        listView.setOnItemClickListener(this);

        instance = this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                setResult(LIST_VIEW_SELECT_CANCEL);
                finish();
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
                break;
        }
    }

    @Override
    public void onBackPressed() {
        //se comenta el llamado para evitar que salga de la lista presionando el boton back
        //super.onBackPressed();
    }

    /**
     * Metodo encargado de desplegar la lista de seleccion
     * @param activity Actividad padre utilizada para desplegar el activity ListViewSelect
     * @param lstItems Lista de items a mostrar en la lista
     * @param title Cadena de texto para usarla como titulo de la lista
     * @param requestCode Codigo de la peticion para invocar el Activity ListViewSelect con startActivityForResult
     * */
    public static void show(Activity activity, List<UserAccessModel> lstItems, String title, int requestCode) {
        ListViewSelectSimple.lstItems = lstItems;
        Intent intentListViewSelect = new Intent(activity, ListViewSelectSimple.class);
        intentListViewSelect.putExtra("title", title);
        activity.startActivityForResult(intentListViewSelect, requestCode);
        activity.overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
    }

    /**
     * Metodo encargado de desplegar la lista de seleccion
     * @param activity Actividad padre utilizada para desplegar el activity ListViewSelect
     * @param lstItems Lista de items a mostrar en la lista
     * @param title Identificador del recurso @strings para usarlo como titulo de la lista
     * @param requestCode Codigo de la peticion para invocar el Activity ListViewSelect con startActivityForResult
     * */
    public static void show(Activity activity, List<UserAccessModel> lstItems, int title, int requestCode) {
        ListViewSelectSimple.lstItems = lstItems;
        Intent intentListViewSelect = new Intent(activity, ListViewSelectSimple.class);
        intentListViewSelect.putExtra("title", title);
        activity.startActivityForResult(intentListViewSelect, requestCode);
        activity.overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
    }

    public static void hide() {
        instance.finish();
        instance.overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //se construye un intent para delvolver el indice del elemento seleccionado
        Intent data = new Intent();
        data.putExtra("index", position);
        setResult(LIST_VIEW_SELECT_OK, data);
        finish();
    }
}
