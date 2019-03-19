package com.mercado.a.domicilio.navigation.bottom.categoria;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mercado.a.domicilio.R;
import com.mercado.a.domicilio.navigation.bottom.categoria.categoria.ContenidoCategoria;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import pedidos_a_domicilio.BeanCategoria;

public class CategoriaFragment extends Fragment {

    private static final String ARG_NUMERO_DE_COLUMNAS = "numero-de-columnas";

    private int mNumeroDeColumnas = 2;
    private OnListFrgInteractionListenerCategoria mListener;

    public CategoriaFragment() {
    }

    public static CategoriaFragment newInstance(int columnCount) {
        CategoriaFragment fragment = new CategoriaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NUMERO_DE_COLUMNAS, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mNumeroDeColumnas = getArguments().getInt(ARG_NUMERO_DE_COLUMNAS);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categoria_list, container, false);

        if (ContenidoCategoria.bLstCategoria == null) {
            Log.e("error de conexion", "ContenidoCategoria.bLstCategoria==null");
        } else {
            Log.i("bLstCategoria", ContenidoCategoria.bLstCategoria.toString());
            // Set the adapter
            if (view instanceof RecyclerView) {
                Context context = view.getContext();
                RecyclerView recyclerView = (RecyclerView) view;
                if (mNumeroDeColumnas <= 1) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                } else {
                    recyclerView.setLayoutManager(new GridLayoutManager(context, mNumeroDeColumnas));
                }
                recyclerView.setAdapter(new CategoriaRecyclerViewAdapter(ContenidoCategoria.bLstCategoria, mListener,context));
            }
        }
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnListFrgInteractionListenerCategoria) {
            mListener = (OnListFrgInteractionListenerCategoria) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFrgInteractionListenerCategoria");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFrgInteractionListenerCategoria {
        void onListFrgInteractionCategoria(BeanCategoria beanCategoria);
    }

}
