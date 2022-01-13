package com.example.rv_with_ocl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.rv_with_ocl.adapter.CustomAdapter;
import com.example.rv_with_ocl.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List<Member> members = prepareMembers();
        refreshAdapter(members);
    }

    private List<Member> prepareMembers() {

        List<Member> members = new ArrayList<>();

        for(int i = 0; i<30; i++){
            members.add(new Member("Ali " + i , "Ali "+ i));
        }
        return members;
    }


    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members) {

        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
}