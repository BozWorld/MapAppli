package fr.epsi.epsiproject;

import android.content.Intent;

public class CategorieActivity  extends EpsiActivity {

    public static void displayActivity(EpsiActivity activity,String url,String title){
        Intent intent = new Intent(activity,CategorieActivity.class);
        intent.putExtra("url",url);
        intent.putExtra("title",title);
        activity.startActivity(intent);
    }

    public static void displayActivity(String urlNature) {
    }
}
