package fr.epsi.epsiproject.Student;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.epsi.epsiproject.EpsiProjectActivity;
import fr.epsi.epsiproject.HomeActivity;
import fr.epsi.epsiproject.R;

public class StudentActivity extends EpsiProjectActivity{

    public static void displayActivity(EpsiProjectActivity activity, String AvatarURL, String Nom, String Prenom, String Email, String Group){
        Intent intent = new Intent(activity,StudentActivity.class);
        intent.putExtra("Avatar", AvatarURL);
        intent.putExtra("Nom", Nom);
        intent.putExtra("Prenom", Prenom);
        intent.putExtra("Email", Email);
        intent.putExtra("Group", Group);

        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentinfo);
        setTitle("Student");

        ImageView imageView = findViewById(R.id.AvatarStudent);

        TextView textViewNom = findViewById(R.id.textViewNom);

        TextView textViewPrenom = findViewById(R.id.textViewPrenom);

        TextView textViewEmail = findViewById(R.id.textViewEmail);

        TextView textViewGroupe = findViewById(R.id.textViewGroupe);

        String Avatarurl = getIntent().getExtras().getString("Avatar", "");

        String Nom = getIntent().getExtras().getString("Nom", "");

        String Prenom = getIntent().getExtras().getString("Prenom", "");

        String Email = getIntent().getExtras().getString("Email", "");

        String Group = getIntent().getExtras().getString("Group", "");

        Picasso.get().load(Avatarurl).into(imageView);

        textViewNom.setText(Nom);

        textViewPrenom.setText(Prenom);

        textViewEmail.setText(Email);

        textViewGroupe.setText(Group);

        ImageView buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentForMainActivity = new Intent(StudentActivity.this, GroupActivity.class);
                startActivity(intentForMainActivity);
                finish();
            }
        });
    }
}
