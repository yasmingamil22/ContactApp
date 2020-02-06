package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
FloatingActionButton ft;
MyDatabase myDatabase1;
RecyclerView recycler_view;
AdapterForRecycle adapterForRecycle;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase1 =new MyDatabase(this);
        recycler_view=findViewById(R.id.recycler_view);
        adapterForRecycle=new AdapterForRecycle(myDatabase1.getAllData());
        recycler_view.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adapterForRecycle);

        ft=findViewById(R.id.ft_button);
        ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                 startActivity(i);
            }
        });
    }
}
