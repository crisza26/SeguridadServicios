package com.seguridadservicios.controlacceso.seguridadservicios.ui;


import android.app.Activity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.seguridadservicios.controlacceso.seguridadservicios.R;


import butterknife.InjectView;
import butterknife.OnClick;


/**
 * A login screen that offers login via email/password and via Google+ sign in.
 * <p/>
 * ************ IMPORTANT SETUP NOTES: ************
 * In order for Google+ sign in to work with your app, you must first go to:
 * https://developers.google.com/+/mobile/android/getting-started#step_1_enable_the_google_api
 * and follow the steps in "Step 1" to create an OAuth 2.0 client for your package.
 */
public class LoginActivity extends Activity {


    @InjectView(R.id.id_usuario)
    EditText ivEtUsuario;
    @InjectView(R.id.id_contrasena)
    EditText ivEtContrasena;
    @InjectView(R.id.id_btn_ingresar)
    Button ivBtIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @OnClick(R.id.id_btn_ingresar)
    public void ingresar(View view) {

    }


    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


}



