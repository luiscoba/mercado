package com.mercado.a.domicilio.conexion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mercado.a.domicilio.conexion.rsc_rest.ConexionHostExcepcion;
import com.mercado.a.domicilio.conexion.rsc_rest.Recursos;
import com.mercado.a.domicilio.conexion.rsc_rest.Rest;

import java.util.List;

import pedidos_a_domicilio.BeanCategoria;
import pedidos_a_domicilio.BeanComprador;
import pedidos_a_domicilio.BeanResponse;
import pedidos_a_domicilio.BeanSubCategoria;

public interface Conexion {

    Gson gson = new GsonBuilder().create();

    String requestMethod = "POST";
    String contentType = "application/json";
    String accept = "application/json,text/plain";
    String tramaJson = "tramaJson";

    static BeanResponse inicioSesionCliente(BeanComprador beanComprador) {
        String strRespuesta = "";
        Rest conn = new Rest(Recursos.inicioSesionCliente);

        try {
            strRespuesta = conn.invocarWS(requestMethod, contentType, accept, gson.toJson(beanComprador));
        } catch (ConexionHostExcepcion conexionHostExcepcion) {
            conexionHostExcepcion.printStackTrace();
        }

        return gson.fromJson(strRespuesta, BeanResponse.class);
    }

    static List<BeanCategoria> obtenerCategorias() {
        String strRespuesta = "";
        Rest conn = new Rest(Recursos.obtenerCategorias);

        try {
            strRespuesta = conn.invocarWS(requestMethod, contentType, accept);
        } catch (ConexionHostExcepcion conexionHostExcepcion) {
            conexionHostExcepcion.printStackTrace();
        }

        TypeToken<List<BeanCategoria>> token = new TypeToken<List<BeanCategoria>>() {
        };

        return new Gson().fromJson(strRespuesta, token.getType());
    }

    static List<BeanSubCategoria> obtenerSubCategorias() {
        String strRespuesta = "";
        Rest conn = new Rest(Recursos.obtenerSubCategorias);

        try {
            strRespuesta = conn.invocarWS(requestMethod, contentType, accept);
        } catch (ConexionHostExcepcion conexionHostExcepcion) {
            conexionHostExcepcion.printStackTrace();
        }

        TypeToken<List<BeanSubCategoria>> token = new TypeToken<List<BeanSubCategoria>>() {
        };

        return new Gson().fromJson(strRespuesta, token.getType());
    }
    static List<BeanSegmento> obtenerSegmentos() {
        String strRespuesta = "";
        Rest conn = new Rest(Recursos.obtenerSubCategorias);

        try {
            strRespuesta = conn.invocarWS(requestMethod, contentType, accept);
        } catch (ConexionHostExcepcion conexionHostExcepcion) {
            conexionHostExcepcion.printStackTrace();
        }

        TypeToken<List<BeanSubCategoria>> token = new TypeToken<List<BeanSubCategoria>>() {
        };

        return new Gson().fromJson(strRespuesta, token.getType());
    }
}
