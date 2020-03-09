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

public class MainActivity extends AppCompatActivity  implements  BottomNavigationView.OnNavigationItemReselectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;
    ImageView imageView1,imageView2;
    Button button1,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window g = getWindow();
        g.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.TYPE_STATUS_BAR);
        setContentView(R.layout.activity_main);

        mTextMessage=findViewById(R.id.text_view_data);

        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);

        button1=findViewById(R.id.buttonView1);
        button2=findViewById(R.id.buttonView2);
        button3=findViewById(R.id.buttonView3);
        button4=findViewById(R.id.buttonView4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Startlesson.class);
                startActivity(intent);



            }
        });

        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeEarment());

        Date d = new Date();
        CharSequence s = android.text.format.DateFormat.format("dd-MMMM",d.getTime());
        Toast.makeText(this,s.toString(),Toast.LENGTH_SHORT).show();

        TextView textView = findViewById(R.id.text_view_data);
        textView.setText(s);
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {


    }
    private boolean loadFragment(Fragment fragment){
        if (fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;

        }
        return  false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment=null;
        switch (item.getItemId()){
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


}
