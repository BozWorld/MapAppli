package fr.epsi.epsiproject.Product;

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

import fr.epsi.epsiproject.Categorie.CategorieWithWSActivity;
import fr.epsi.epsiproject.EpsiProjectActivity;
import fr.epsi.epsiproject.ImagesProductActivity;
import fr.epsi.epsiproject.R;
import fr.epsi.epsiproject.WSCall;

public class ProductListWithWSActivity extends EpsiProjectActivity {

    ArrayList<ProductList> products;
    ProductAdapter productAdapter;
    RecyclerView recyclerView;
    public static void displayActivity(EpsiProjectActivity activity, String Url){
        Intent intent = new Intent(activity, ProductListWithWSActivity.class);
        intent.putExtra("wsUrlP", Url);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        String wsUrl = getIntent().getExtras().getString("wsUrlP", "");   // getIntent().getExtras().getString("url", "");
        recyclerView=findViewById(R.id.recyclerViewP);
        products = new ArrayList<>();
        productAdapter = new ProductAdapter(this,products, wsUrl);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapter);
        WSCall wsCall= new WSCall(wsUrl, new WSCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject=new JSONObject(result);
                    JSONArray jsonItems=jsonObject.getJSONArray("items");
                    for (int i=0;i<jsonItems.length();i++){
                        ProductList product= null;
                        product = new ProductList(jsonItems.getJSONObject(i));
                        products.add(product);
                    }
                    productAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(ProductListWithWSActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        wsCall.run();

        ImageView buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentForMainActivity = new Intent(ProductListWithWSActivity.this, CategorieWithWSActivity.class);
                startActivity(intentForMainActivity);
                finish();
            }
        });
    }
}
