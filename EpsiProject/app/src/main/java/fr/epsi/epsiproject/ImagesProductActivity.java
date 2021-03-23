package fr.epsi.epsiproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.epsi.epsiproject.Product.ProductListWithWSActivity;

public class ImagesProductActivity extends EpsiProjectActivity {

    static public void displayActivity(EpsiProjectActivity activity, String url, String description, String urlCategorie){
        Intent intent = new Intent(activity, ImagesProductActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("description", description);
        intent.putExtra("urlCategorie", urlCategorie);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagesproduct);

        ImageView imageView = findViewById(R.id.ProductImage);

        TextView textView = findViewById(R.id.textViewTitleImage);

        String url = getIntent().getExtras().getString("url", "");

        String title = getIntent().getExtras().getString("description", "");

        String urlCategorie = getIntent().getExtras().getString("urlCategorie", "");

        textView.setText(title);

        Picasso.get().load(url).into(imageView);

        ImageView buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductListWithWSActivity.displayActivity(ImagesProductActivity.this, urlCategorie);
                finish();
            }
        });

    }
}
