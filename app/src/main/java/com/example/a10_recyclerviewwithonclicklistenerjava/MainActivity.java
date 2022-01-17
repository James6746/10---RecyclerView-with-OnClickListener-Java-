package com.example.a10_recyclerviewwithonclicklistenerjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> userArrayList;
    private UserAdapter userAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        userArrayList = new ArrayList<>();
        userAdapter = new UserAdapter(this, userArrayList);


        for (int i = 0; i < 50; i++) {
            userArrayList.add(new User("James"));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(userAdapter);
    }

    public void showToast(Context context,  int position){
        Toast.makeText(context, position + "th item clicked!", Toast.LENGTH_SHORT).show();
    }
}