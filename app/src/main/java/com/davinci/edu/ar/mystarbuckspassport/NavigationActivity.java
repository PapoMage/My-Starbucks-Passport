package com.davinci.edu.ar.mystarbuckspassport;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.davinci.edu.ar.mystarbuckspassport.fragmentsList.CoffeeFragment;
import com.davinci.edu.ar.mystarbuckspassport.fragmentsList.TeaFragment;

import static android.widget.Toast.LENGTH_SHORT;

public class NavigationActivity extends AppCompatActivity{

    private TextView mTextMessage;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.coffee_title_list);
                    CoffeeFragment coffeeFragment = new CoffeeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,coffeeFragment).commit();
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.tea_title_list);
                    TeaFragment teaFragment = new TeaFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,teaFragment).commit();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.profile_title_list);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
    }

    public void coffeeButton(View v){
        Toast.makeText(this,"Toque el boton",Toast.LENGTH_SHORT).show();
    }

    public void teaButton (View v){
        Snackbar.make(v, "Toque el boton de Té", Snackbar.LENGTH_LONG).show();
    }
}
