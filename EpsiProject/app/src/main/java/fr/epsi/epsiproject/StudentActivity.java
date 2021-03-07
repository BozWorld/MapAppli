package fr.epsi.epsiproject;

import android.content.Intent;
import android.os.Bundle;

public class StudentActivity extends EpsiActivity{

    public static void displayActivity(EpsiActivity activity){
        Intent intent = new Intent(activity,StudentActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentinfo);
        setTitle("Student");
    }
}
