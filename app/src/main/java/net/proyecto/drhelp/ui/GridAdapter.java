package net.proyecto.drhelp.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.proyecto.drhelp.MainActivity;
import net.proyecto.drhelp.R;
import net.proyecto.drhelp.androidchat.Prueba;
import net.proyecto.drhelp.interfaces.ItemClickListener;

import java.util.ArrayList;

/**
 * Created by choqu_000 on 24/05/2016.
 */
public class GridAdapter extends  RecyclerView.Adapter<GridAdapter.ViewHolder> {

    ArrayList<String> alName;
    ArrayList<Integer> alImage;
    Context context;
    MainActivity.PlaceholderFragment placeholderFragment;

    //Poliformismo
    public GridAdapter(Context context, ArrayList<String> alName, ArrayList<Integer> alImage) {
        super();
        this.context = context;
        this.alName = alName;
        this.alImage = alImage;
    }

    public GridAdapter(MainActivity.PlaceholderFragment placeholderFragment, ArrayList<String> alName, ArrayList<Integer> alImage) {
        super();
        this.placeholderFragment=placeholderFragment;
        this.alName = alName;
        this.alImage=alImage;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvSpecies.setText(alName.get(i));
        viewHolder.imgThumbnail.setImageResource(alImage.get(i));

        viewHolder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    Toast.makeText(context, "#" + position + " - " + alName.get(position) + " (Long click)", Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context, MainActivity.class));
                } else {
                    //Toast.makeText(context, "#" + position + " - " + alName.get(position), Toast.LENGTH_SHORT).show();
                    if (position == 0) {

                        context.startActivity(new Intent(context, Prueba.class));
                    }else if (position == 1){
                        //context.startActivity(new Intent(context, EntradaFoto.class));
                    } else {
                        //Aca esta el tab layout
                        //context.startActivity(new Intent(context, TabLayoutService.class));

                    }/*else if (position == 3) {
                        //Mapa
                        context.startActivity(new Intent(context, MapaRuta.class));
                    }else{
                        context.startActivity(new Intent(context, FormMainActivity.class));
                    }
                    */


                    /*
                     if (position == 0) {

                        context.startActivity(new Intent(context, VistaFormularioEjecuciones.class));
                    }else if (position == 1){
                        context.startActivity(new Intent(context, EntradaFoto.class));
                    }else if (position == 2){
                        //Aca esta el tab layout
                        context.startActivity(new Intent(context, TabLayoutService.class));
                        //Toast.makeText(context, "#" + position + " - " + alName.get(position), Toast.LENGTH_SHORT).show();
                    }else if (position == 3) {
                        //Intent intent = new Intent(context, MapaRuta.class);
                        context.startActivity(new Intent(context, MapaRuta.class));
                    }else{
                        context.startActivity(new Intent(context, FormMainActivity.class));
                    }
                     */


                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return alName.size();
    }


    //Clase
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public ImageView imgThumbnail;
        public TextView tvSpecies;
        private ItemClickListener clickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            tvSpecies = (TextView) itemView.findViewById(R.id.tv_species);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition(), true);
            return true;
        }
    }
}
