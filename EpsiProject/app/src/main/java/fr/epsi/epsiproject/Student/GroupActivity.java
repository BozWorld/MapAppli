package fr.epsi.epsiproject.Student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.epsi.epsiproject.Categorie.CategorieWithWSActivity;
import fr.epsi.epsiproject.Data;
import fr.epsi.epsiproject.EpsiProjectActivity;
import fr.epsi.epsiproject.HomeActivity;
import fr.epsi.epsiproject.Product.ProductListWithWSActivity;
import fr.epsi.epsiproject.R;

public class GroupActivity extends EpsiProjectActivity{

    public static void displayActivity(EpsiProjectActivity activity){
        Intent intent = new Intent(activity,GroupActivity.class);
        activity.startActivity(intent);
    }
    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_activity);
        setTitle("Infos");
        //showBack();
        students = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerViewStudents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GroupAdapter groupAdapter = new GroupAdapter(this,students);
        recyclerView.setAdapter(groupAdapter);
        try {

            JSONObject jsonObject= new JSONObject(Data.allData);
            JSONArray jsonArray = jsonObject.getJSONArray("items");
            for(int i=0;i<jsonArray.length();i++){
                Student student=new Student(jsonArray.getJSONObject(i));
                students.add(student);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ImageView buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentForMainActivity = new Intent(GroupActivity.this, HomeActivity.class);
                startActivity(intentForMainActivity);
                finish();
            }
        });
    }


}
