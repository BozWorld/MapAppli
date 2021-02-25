package fr.epsi.epsiproject.Product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fr.epsi.epsiproject.Categorie.Categorie;
import fr.epsi.epsiproject.EpsiProjectActivity;
import fr.epsi.epsiproject.ImagesActivity;
import fr.epsi.epsiproject.ImagesProductActivity;
import fr.epsi.epsiproject.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private ArrayList<ProductList> products;
    private String categorie;
    private EpsiProjectActivity activity;

    public ProductAdapter(EpsiProjectActivity activity, ArrayList<ProductList> products, String categorie){
        this.activity=activity;
        this.products=products;
        this.categorie=categorie;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_product, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductList product=products.get(position);
        holder.getTextViewTitleP().setText(product.getName());
        holder.getTextViewDescription().setText(product.getDescription());
        Picasso.get().load(product.getPicture()).into(holder.getImageViewProduct());
        holder.getLayoutCell().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagesProductActivity.displayActivity(activity,product.getPicture(),product.getDescription(), categorie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewDescription;
        private final TextView textViewTitleP;
        private final ImageView imageViewProduct;
        private final View layoutCellP;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textViewDescription = view.findViewById(R.id.textViewDescription);
            textViewTitleP = view.findViewById(R.id.textViewTitleP);
            imageViewProduct =  view.findViewById(R.id.imageViewProduct);
            layoutCellP = view.findViewById(R.id.layoutCellP);
        }

        public View getLayoutCell() {
            return layoutCellP;
        }
        public TextView getTextViewDescription() {
            return textViewDescription;
        }
        public TextView getTextViewTitleP() {
            return textViewTitleP;
        }
        public ImageView getImageViewProduct() {
            return imageViewProduct;
        }
    }

}
