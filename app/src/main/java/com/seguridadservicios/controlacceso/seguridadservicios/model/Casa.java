package com.seguridadservicios.controlacceso.seguridadservicios.model;

/**
 * Created by fuinkio on 4/24/2015.
 */
public class Casa {
    String nombre;
    String id;
    String usuario;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    String password;
}
