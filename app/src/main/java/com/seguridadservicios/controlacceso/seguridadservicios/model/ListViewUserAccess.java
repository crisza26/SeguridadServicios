package com.seguridadservicios.controlacceso.seguridadservicios.model;

/**
 * Created by Dianita on 26/03/2015.
 */
public abstract class ListViewUserAccess {
    public String id;
    public String nombre;
    public String apellido;
    public String celular;
    public String email;

    public ListViewUserAccess(String id, String nombre, String apellido, String celular, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
    }

}
