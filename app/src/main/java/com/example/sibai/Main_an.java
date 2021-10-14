package com.example.sibai;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Main_an extends AppCompatActivity {

    List<Data> list =new ArrayList<>();
    ListView listView;


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ce_hua);
        listView = findViewById(R.id.message_center_lv);
        init();
    }

    public  void init(){
        for (int i = 0; i < 10; i++) {
            list.add(new Data("好家伙",R.drawable.xiaochengxu));
        }
        listView.setAdapter(new ListViewAdapter(Main_an.this,list));
    }
}
