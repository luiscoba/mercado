package com.mercado.a.domicilio.navigation.bottom.categoria.categoria.subCategoria;

import android.os.Bundle;

import com.mercado.a.domicilio.R;
import com.mercado.a.domicilio.navigation.bottom.categoria.categoria.subCategoria.subCategoria.ContenidoSubCategoria;
import com.mercado.a.domicilio.navigation.bottom.categoria.categoria.subCategoria.SubCategoriaFragment.OnListFrgInteractionListenerSubCategoria;

import androidx.fragment.app.FragmentActivity;

public class SubcategoriaActivity extends FragmentActivity implements OnListFrgInteractionListenerSubCategoria {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategoria);
    }

    @Override
    public void onListFrgInteractionSubCategoria(ContenidoSubCategoria.DummyItem item) {

    }
}
