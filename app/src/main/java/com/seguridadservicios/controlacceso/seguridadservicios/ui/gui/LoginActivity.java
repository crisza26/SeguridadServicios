package com.seguridadservicios.controlacceso.seguridadservicios.ui.gui;


import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.seguridadservicios.controlacceso.seguridadservicios.R;
import com.seguridadservicios.controlacceso.seguridadservicios.service.LoginService;


import butterknife.ButterKnife;
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


    @InjectView(R.id.EditTextLoginUsername)
    EditText ivEtUsuario;
    @InjectView(R.id.EditTextLoginPassword)
    EditText ivEtContrasena;
    @InjectView(R.id.id_btn_ingresar)
    Button ivBtIngresar;
    @InjectView(R.id.id_solicitudregistro)
    ImageButton ivIbSolicitud;
    Animation scalar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        scalar = AnimationUtils.loadAnimation(this, R.anim.scale_buttom);

    }

    @OnClick(R.id.id_solicitudregistro)
    public void solicitudRegistro(View view) {
        Intent intSolRegistro = new Intent(LoginActivity.this, RequestRegistrationActivity.class);
        this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_down);
        startActivity(intSolRegistro);
    }

    //@OnClick(R.id.id_btn_ingresar)
    public void ingresar(View view) {
        view.startAnimation(scalar);
        EditText username=(EditText) findViewById(R.id.EditTextLoginUsername);
        EditText password=(EditText) findViewById(R.id.EditTextLoginPassword);
        LoginService ls=new LoginService();
        ls.setUser(username.getText().toString());
        ls.setPasword(password.getText().toString());
        ls.accessWebService();

        Toast.makeText(getApplicationContext(),
               ls.getJsonResult(), Toast.LENGTH_SHORT);

        if(ls.getJsonResult().equals("1")){

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);

        }else{

            Toast.makeText(getApplicationContext(),
                    "error en usuario o contraseña!", Toast.LENGTH_SHORT).show();

        }
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



