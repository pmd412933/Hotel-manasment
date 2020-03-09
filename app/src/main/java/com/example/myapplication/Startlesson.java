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
import android.widget.Toast;

import java.util.Date;

import static com.example.myapplication.R.layout.activity_startlesson;

public class Startlesson extends AppCompatActivity {
    private TextView mTextMessage;
    ImageView imageView1,imageView2;
    Button button5,button6,button7,button8,button9,button10;



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

    };

    private boolean loadFragment(Fragment fragment) {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window g = getWindow();
        g.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.TYPE_STATUS_BAR);

        setContentView(activity_startlesson);


        imageView1=findViewById(R.id.imageView3);
        imageView2=findViewById(R.id.imageView4);

        button5=findViewById(R.id.buttonView5);
        button6=findViewById(R.id.button1);
        button7=findViewById(R.id.button2);
        button8=findViewById(R.id.button3);
        button9=findViewById(R.id.button4);
        button10=findViewById(R.id.button5);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Startlesson.this,MainActivity.class);
                startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Startlesson.this,Vocabulary.class);
                startActivity(intent);
            }
        });

        BottomNavigationView navView = findViewById(R.id.navigation2);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Date d = new Date();
        CharSequence s = android.text.format.DateFormat.format("dd-MMMM",d.getTime());
        Toast.makeText(this,s.toString(),Toast.LENGTH_SHORT).show();

        TextView textView = findViewById(R.id.text_view_data2);
        textView.setText(s);
    }

}
