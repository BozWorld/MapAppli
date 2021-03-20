package fr.epsi.epsiproject.Student;

import android.content.Intent;

import fr.epsi.epsiproject.EpsiProjectActivity;

public class CategorieActivity  extends EpsiProjectActivity {

    public static void displayActivity(EpsiProjectActivity activity, String url, String title){
        Intent intent = new Intent(activity,CategorieActivity.class);
        intent.putExtra("url",url);
        intent.putExtra("title",title);
        activity.startActivity(intent);
    }

    public static void displayActivity(String urlNature) {
    }
}
