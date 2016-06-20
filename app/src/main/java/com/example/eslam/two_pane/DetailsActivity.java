package com.example.eslam.two_pane;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //Receive the selected namesent Bundle.
        Bundle extras = getIntent().getExtras();
        if (null == savedInstanceState) {
            DetailsFragment mDetailsFragment = new DetailsFragment();
            //Pass the "extras" Bundle that contains the selected "name" to the fragment
            mDetailsFragment.setArguments(extras);
            getFragmentManager().beginTransaction().add(R.id.llDetailsContainer, mDetailsFragment).commit();
        }


    }

}
