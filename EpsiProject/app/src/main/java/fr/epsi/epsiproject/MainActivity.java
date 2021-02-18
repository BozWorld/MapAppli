package fr.epsi.epsiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String urlNature= "https://www.slate.fr/sites/default/files/styles/1060x523/public/lukasz-szmigiel-jfcviyfycus-unsplash.jpg";
    String urlEspace= "https://www.entreprendre.fr/wp-content/uploads/AdobeStock_2015532431.jpg";

    public static void displayActivity(EpsiActivity activity){
        Intent intent = new Intent(activity,MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
        findViewById(R.id.buttonCategorie).setOnClickListener(this);
        findViewById(R.id.buttonGroupe).setOnClickListener(this);
    }



    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonCategorie:
                CategorieActivity.displayActivity(this.urlNature);
                break;
            case R.id.buttonGroupe:
                GroupActivity.displayActivity(this);
                break;
                




        }
    }
}