package fr.epsi.epsiproject.Categorie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.epsi.epsiproject.EpsiProjectActivity;
import fr.epsi.epsiproject.HomeActivity;
import fr.epsi.epsiproject.Product.ProductListWithWSActivity;
import fr.epsi.epsiproject.R;
import fr.epsi.epsiproject.WSCall;

public class CategorieWithWSActivity extends EpsiProjectActivity {

    String wsUrl="https://djemam.com/epsi/categories.json";
    ArrayList<Categorie> categories; //*
    CategorieAdapter categorieAdapter;
    RecyclerView recyclerView;
    public static void displayActivity(EpsiProjectActivity activity){
        Intent intent = new Intent(activity, CategorieWithWSActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        //setTitle("Students");
        //showBack();
        recyclerView=findViewById(R.id.recyclerView);
        categories = new ArrayList<>();
        categorieAdapter= new CategorieAdapter(this,categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(categorieAdapter);
        WSCall wsCall= new WSCall(wsUrl, new WSCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject=new JSONObject(result);
                    JSONArray jsonItems=jsonObject.getJSONArray("items");
                    for (int i=0;i<jsonItems.length();i++){
                        Categorie categorie= null;
                        categorie = new Categorie(jsonItems.getJSONObject(i));
                        categories.add(categorie);
                    }
                    categorieAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(CategorieWithWSActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();

        ImageView buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentForMainActivity = new Intent(CategorieWithWSActivity.this, HomeActivity.class);
                startActivity(intentForMainActivity);
                finish();
            }
        });

    }
}
