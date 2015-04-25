package com.seguridadservicios.controlacceso.seguridadservicios.object;

/**
 * Created by fuinkio on 4/24/2015.
 */
public class Usuario {
    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsurio() {
        return Usurio;
    }

    public void setUsurio(String usurio) {
        Usurio = usurio;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getTipo_de_usuario() {
        return Tipo_de_usuario;
    }

    public void setTipo_de_usuario(String tipo_de_usuario) {
        Tipo_de_usuario = tipo_de_usuario;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    private  String id_usuario, Usurio, Contraseña, Cedula, Correo, Nombre, Apellido, Direccion, Telefono, Tipo_de_usuario,Descripcion;
}
