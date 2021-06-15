package com.example.tarea_recyclerview_con_cardviewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

   private List<ListElement> listaelementos;
   private Context context;

    public ListAdapter(List<ListElement> listaelementos, Context context) {
        this.listaelementos = listaelementos;
        this.context = context;
    }

    // pasar el layaout para que se infle y se muestre en nuestro recicleview
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
      holder.txtNombrerevista.setText(listaelementos.get(position).getTitle());
      holder.txtfecha.setText(listaelementos.get(position).getDate_published());
      holder.txtVol.setText(listaelementos.get(position).getDoi());
        Glide.with(context)
                         .load(listaelementos.get(position).getCover())
                          .centerCrop()
                          .into(holder.imgfoto);
    }

    @Override
    public int getItemCount() {
        return listaelementos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

       private ImageView imgfoto;
       private TextView txtNombrerevista;
       private TextView txtfecha;
       private TextView txtVol;



       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           imgfoto = itemView.findViewById(R.id.imgfoto);
           txtNombrerevista = itemView.findViewById(R.id.txtNombrerevista);
           txtfecha = itemView.findViewById(R.id.txtfecha);
           txtVol=itemView.findViewById(R.id.txtDoi);

       }
   }



}


