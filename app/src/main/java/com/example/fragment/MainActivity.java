package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = findViewById(R.id.main_tab);
        Button button2 = findViewById(R.id.call_tab);
        Button button3 = findViewById(R.id.message_tab);
        Button button4 = findViewById(R.id.person_tab);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        replaceFragment(new Fragment1());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_tab:
                replaceFragment(new Fragment1());
                break;
            case R.id.call_tab:
                replaceFragment(new Fragment2());
                break;
            case R.id.message_tab:
                replaceFragment(new Fragment3());
                break;
            case R.id.person_tab:
                replaceFragment(new Fragment4());
                break;
            default:
                break;

        }

    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
