package fr.epsi.epsiproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.epsi.epsiproject.Categorie.CategorieWithWSActivity;
import fr.epsi.epsiproject.Product.ProductListWithWSActivity;

public class HomeActivity extends EpsiProjectActivity {

    static public void displayActivity(SplashActivity activity){
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button buttonViewNature = findViewById(R.id.ButtonNature);

        Button buttonViewEspace = findViewById(R.id.ButtonEspace);

        Button buttonViewCategorie = findViewById(R.id.ButtonCategorie);

        buttonViewNature.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ImagesActivity.displayActivity(HomeActivity.this, "https://www.slate.fr/sites/default/files/styles/1060x523/public/lukasz-szmigiel-jfcviyfycus-unsplash.jpg", "Image1");
                finish();
            }
        });

        buttonViewEspace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ImagesActivity.displayActivity(HomeActivity.this, "https://pic.clubic.com/v1/images/1693605/raw", "Image2");
                finish();
            }
        });

        buttonViewCategorie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                CategorieWithWSActivity.displayActivity(HomeActivity.this);
                finish();
            }
        });

    }
}
