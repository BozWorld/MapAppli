package fr.epsi.epsiproject.Categorie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fr.epsi.epsiproject.EpsiProjectActivity;
import fr.epsi.epsiproject.Product.ProductListWithWSActivity;
import fr.epsi.epsiproject.R;

public class CategorieAdapter extends RecyclerView.Adapter<CategorieAdapter.ViewHolder>{

    private ArrayList<Categorie> categories;
    private EpsiProjectActivity activity;

    public CategorieAdapter(EpsiProjectActivity activity, ArrayList<Categorie> categories){
        this.activity=activity;
        this.categories=categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_categorie, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Categorie categorie=categories.get(position);
        holder.getTextViewTitle().setText(categorie.getTitle());
        Picasso.get().load(categorie.getUrl()).into(holder.getImageViewCategorie());
        holder.getLayoutCell().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductListWithWSActivity.displayActivity(activity,categorie.getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTitle;
        private final ImageView imageViewCategorie;
        private final View layoutCell;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textViewTitle = view.findViewById(R.id.textViewTitleC);
            imageViewCategorie =  view.findViewById(R.id.imageViewCategorie);
            layoutCell = view.findViewById(R.id.layoutCell);
        }

        public View getLayoutCell() {
            return layoutCell;
        }
        public TextView getTextViewTitle() {
            return textViewTitle;
        }
        public ImageView getImageViewCategorie() {
            return imageViewCategorie;
        }
    }

}
