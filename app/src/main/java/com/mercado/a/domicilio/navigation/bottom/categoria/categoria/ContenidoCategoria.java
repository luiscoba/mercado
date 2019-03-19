package com.mercado.a.domicilio.navigation.bottom.categoria.categoria;

import com.mercado.a.domicilio.conexion.Conexion;

import java.util.List;

import pedidos_a_domicilio.BeanCategoria;

public class ContenidoCategoria {

    public static final List<BeanCategoria> bLstCategoria = Conexion.obtenerCategorias();

}
