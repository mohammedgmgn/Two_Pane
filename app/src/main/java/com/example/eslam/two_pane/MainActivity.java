package com.example.eslam.two_pane;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements NameListener {
    boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout flPanel2 = (FrameLayout) findViewById(R.id.flPanel_Two);
        if (null == flPanel2) {
            mTwoPane = false;
        } else {
            mTwoPane = true;
        }

        if (null == savedInstanceState) {
            ListFragment listFragment = new ListFragment();
            listFragment.setNameListener(this);
            getFragmentManager().beginTransaction().add(R.id.flPanel_One, listFragment).commit();
        }
    }


    @Override
    public void setSelectedName(String name) {
        //Case Two Pane UI
        if (mTwoPane) {
            DetailsFragment detailsFragment= new DetailsFragment();
            Bundle extras= new Bundle();
            extras.putString("name", name);
            detailsFragment.setArguments(extras);
            getFragmentManager().beginTransaction().replace(R.id.flPanel_Two,detailsFragment).commit();
        } else {
            //Case Single Pane UI
            Intent i = new Intent(this, DetailsActivity.class);
            i.putExtra("name", name);
            startActivity(i);
        }

    }
}
