package com.example.unit3eval1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class ItemListActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        fragmentManager=getSupportFragmentManager();
        launchlistfragment();

    }
    private void launchlistfragment(){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        ItemListFragment itemListFragment=new ItemListFragment();
        fragmentTransaction.add(R.id.frame,itemListFragment,"ItemList").commit();
    }
}