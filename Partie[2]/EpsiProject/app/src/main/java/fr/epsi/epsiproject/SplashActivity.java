package fr.epsi.epsiproject;

import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends EpsiProjectActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HomeActivity.displayActivity(SplashActivity.this);
                finish();
            }
        }, 4000);

        }
    @Override
    public void onBackPressed(){

    }
}
