package fr.epsi.epsiproject;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EpsiProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Activity", "####### onCreate ###### : "+getClass().getSimpleName());

    }

    @Override
    public void finish() {
        super.finish();
        Log.d("Activity", "###### Finish ###### : "+getClass().getSimpleName());
    }
}
