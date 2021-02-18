package fr.epsi.epsiproject;

import android.content.Intent;

import java.util.ArrayList;

public class GroupActivity extends EpsiActivity{

    public static void displayActivity(MainActivity activity){
        Intent intent = new Intent(activity,GroupActivity.class);
        activity.startActivity(intent);
    }
    private ArrayList<Student> students;

}
