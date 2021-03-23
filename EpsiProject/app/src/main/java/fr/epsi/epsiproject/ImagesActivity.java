package fr.epsi.epsiproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImagesActivity extends EpsiProjectActivity {

    static public void displayActivity(EpsiProjectActivity activity, String url, String title){
        Intent intent = new Intent(activity, ImagesActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        ImageView imageView = findViewById(R.id.AfficheNature);

        String url = getIntent().getExtras().getString("url", "");

        Picasso.get().load(url).into(imageView);


        ImageView buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentForMainActivity = new Intent(ImagesActivity.this,HomeActivity.class);
                startActivity(intentForMainActivity);
                finish();
            }
        });

    }
}
