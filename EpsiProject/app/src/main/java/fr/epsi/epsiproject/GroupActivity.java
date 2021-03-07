package fr.epsi.epsiproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GroupActivity extends EpsiActivity{

    public static void displayActivity(EpsiActivity activity){
        Intent intent = new Intent(activity,GroupActivity.class);
        activity.startActivity(intent);
    }
    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_activity);
        setTitle("Infos");
        showBack();
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
    }


}
