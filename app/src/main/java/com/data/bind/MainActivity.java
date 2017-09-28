package com.data.bind;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.data.bind.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridLayoutManager manager;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        adapter = new MainAdapter(this);
        manager = new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false);
        binding.recyclerView.setLayoutManager(manager);
        binding.recyclerView.setAdapter(adapter);

        binding.recyclerView.addItemDecoration(new GridLayoutItemDecoration(30, 4));
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            User user = new User("jack" + i, i);
            list.add(user);
        }
        adapter.setUserList(list);

    }
}
