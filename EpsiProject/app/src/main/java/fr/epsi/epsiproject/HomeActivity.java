package fr.epsi.epsiproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.epsi.epsiproject.Categorie.CategorieWithWSActivity;
import fr.epsi.epsiproject.Student.GroupActivity;

public class HomeActivity extends EpsiProjectActivity implements View.OnClickListener {

    static public void displayActivity(SplashActivity activity){
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button buttonViewCategorie = findViewById(R.id.ButtonCategorie);

        buttonViewCategorie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                CategorieWithWSActivity.displayActivity(HomeActivity.this);
                finish();
            }
        });

        findViewById(R.id.buttonGroupe).setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.buttonGroupe:
                GroupActivity.displayActivity(this);
                finish();
                break;
        }
    }

}
