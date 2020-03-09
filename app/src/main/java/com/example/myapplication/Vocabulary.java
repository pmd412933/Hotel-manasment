package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Vocabulary extends AppCompatActivity {
    private TextView mTextMessage;
    ImageView imageView4;
    Button button11,button12,button13,button14,button15,button16;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment= new  HomeEarment();
                    break;
                case R.id.navigation_profile:
                    fragment= new ProfileFarment();
                    break;
                case R.id.navigation_progrees:
                    fragment= new ProgressFarment();
                    break;
                case R.id.navigation_setting:
                    fragment= new SettingFarment();
                    break;
            }
            return loadFragment(fragment);
        }
        private boolean loadFragment(Fragment fragment) {
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);


        Window g = getWindow();
        g.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.TYPE_STATUS_BAR);

        imageView4=findViewById(R.id.imageView4);

        mTextMessage=findViewById(R.id.textTolber);


        button11=findViewById(R.id.button);
        button12=findViewById(R.id.button6);
        button13=findViewById(R.id.button7);
        button14=findViewById(R.id.button8);
        button15=findViewById(R.id.button9);
        button16=findViewById(R.id.button10);

        mTextMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Vocabulary.this,Startlesson.class);
                startActivity(intent);



            }
        });

        BottomNavigationView navView = findViewById(R.id.navigation3);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
