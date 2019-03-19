package com.mercado.a.domicilio.navigation.bottom.categoria;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercado.a.domicilio.R;
import com.mercado.a.domicilio.conexion.rsc_rest.Recursos;
import com.mercado.a.domicilio.navigation.bottom.categoria.CategoriaFragment.OnListFrgInteractionListenerCategoria;
import com.mercado.a.domicilio.navigation.bottom.categoria.categoria.subCategoria.SubCategoriaFragment.OnListFrgInteractionListenerSubCategoria;
import com.mercado.a.domicilio.navigation.bottom.categoria.categoria.subCategoria.SubcategoriaActivity;
import com.mercado.a.domicilio.navigation.bottom.categoria.categoria.subCategoria.subCategoria.ContenidoSubCategoria;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import pedidos_a_domicilio.BeanCategoria;

/**
 * BeanCategoria
 */
public class CategoriaRecyclerViewAdapter extends RecyclerView.Adapter<CategoriaRecyclerViewAdapter.ViewHolder>
implements OnListFrgInteractionListenerSubCategoria {

    private final List<BeanCategoria> mValues;
    private final OnListFrgInteractionListenerCategoria mListener;
    private final Context mContext;

    public CategoriaRecyclerViewAdapter(List<BeanCategoria> items, OnListFrgInteractionListenerCategoria listener, Context context) {
        mValues = items;
        mListener = listener;
        mContext = context;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_categoria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mCategoriaView.setText(mValues.get(position).getNombre());
        //mContext = holder.mCategoriaImageView.getContext(); tambien funciona!

        Picasso.with(mContext)
                .load(Recursos.ipHost_img.concat(mValues.get(position).getFoto()))
                .into(holder.mCategoriaImageView);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFrgInteractionCategoria(holder.mItem);
                    Log.i("mensaje ", "mensaje click");

                    lanzarSubCategoriaFragment();
                }
            }
        });
    }

    public void lanzarSubCategoriaFragment() {
        mContext.startActivity(new Intent(mContext, SubcategoriaActivity.class));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public void onListFrgInteractionSubCategoria(ContenidoSubCategoria.DummyItem item) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mCategoriaView;
        public final ImageView mCategoriaImageView;
        public BeanCategoria mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCategoriaView = view.findViewById(R.id.txtCategoria);
            mCategoriaImageView = view.findViewById(R.id.imgCategoria);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mCategoriaView.getText() + "'";
        }
    }
}
