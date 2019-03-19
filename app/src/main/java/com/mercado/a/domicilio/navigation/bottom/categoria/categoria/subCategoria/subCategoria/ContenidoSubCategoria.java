package com.mercado.a.domicilio.navigation.bottom.categoria.categoria.subCategoria.subCategoria;

import com.mercado.a.domicilio.conexion.Conexion;

import java.util.List;

import pedidos_a_domicilio.BeanSubCategoria;

public class ContenidoSubCategoria {

    public static final List<BeanSubCategoria> bLstSubCategoria = Conexion.obtenerSubCategorias();
}
