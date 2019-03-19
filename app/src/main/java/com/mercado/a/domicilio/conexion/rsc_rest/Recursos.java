package com.mercado.a.domicilio.conexion.rsc_rest;

public final class  Recursos {

    public static final String ipHost = "http://10.0.2.2:8090/mercadoAdomicilio/";

    public static final String ipHost_img = ipHost.concat("image?img=");

    /* Path del servidor */
    public static final String url_srv = ipHost.concat("core/servicio/");

    // a continuacion van los recursos concatenados el url_srv

    public static final String inicioSesionCliente = url_srv.concat("inicioSesionCliente/");

    public static final String obtenerCategorias = url_srv.concat("obtenerCategorias/");

    public static final String obtenerSubCategorias = url_srv.concat("obtenerSubCategorias/");

    public static final String obtenerDatosDeUsuario = url_srv.concat("obtenerDatosDeUsuario/");

    public static final String enrolamientoCliente = url_srv.concat("enrolamientoCliente/");

    public static final String recuperarCuenta = url_srv.concat("recuperarCuenta/");

    public static final String obtenerTodasLasCompras = url_srv.concat("obtenerTodasLasCompras/");

    public static final String rsc_obtenerFotosDelProducto = url_srv.concat("obtenerFotosDelProducto/");

    public static final String rsc_comprar = url_srv.concat("comprar/");

    public static final String rsc_obtenerItemsDelProducto = url_srv.concat("obtenerItemsDelProducto/");

    public static final String rsc_completaRegistroFaltante = url_srv.concat("completaRegistroFaltante/");

}
