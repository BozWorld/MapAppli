package fr.epsi.epsiproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.epsi.epsiproject.Student.Student;
import fr.epsi.epsiproject.Student.StudentActivity;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder>{
    EpsiProjectActivity activity;
    ArrayList<Student> students;

    public GroupAdapter(EpsiProjectActivity activity, ArrayList<Student> students){
        this.activity=activity;
        this.students=students;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final Button buttonNom;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            buttonNom = view.findViewById(R.id.buttonNom);
        }

        public Button getbuttonNom() {
            return buttonNom;
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_group, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Student student = students.get(position);
        holder.getbuttonNom().setText(student.getNom());
        holder.getbuttonNom().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                StudentActivity.displayActivity(activity);
            }
        });


    }


    @Override
    public int getItemCount() {
        return students.size();
    }
}
