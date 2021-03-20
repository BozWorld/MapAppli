package fr.epsi.epsiproject.Student;

import android.content.Intent;
import android.os.Bundle;

import fr.epsi.epsiproject.EpsiProjectActivity;
import fr.epsi.epsiproject.R;

public class StudentActivity extends EpsiProjectActivity{

    public static void displayActivity(EpsiProjectActivity activity){
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
