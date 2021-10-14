package com.example.sibai;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.sibai.ui.MyDrwerlayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    List<Data> list = new ArrayList<>();
    Context context;

    MyDrwerlayout dl;
    LinearLayout item;

    public ListViewAdapter(Context context,List<Data> list) {
        this.context = context;
        this.list  =  list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.ce_hua2,null);
        ImageView imageView = convertView.findViewById(R.id.ca_hua_img);
        TextView textView = convertView.findViewById(R.id.ce_hua_text);
        TextView del = convertView.findViewById(R.id.del);
        TextView end = convertView.findViewById(R.id.endd);
        item =convertView.findViewById(R.id.item);


//        del.setOnClickListener(v->{
//            notifyDataSetChanged();
//            list.remove(position);
//            Log.d("显示", "onBindViewHolder: index:"+position);
//            Log.d("显示", "onBindViewHolder: "+list.size());
//
//        });

        Data data  = list.get(position);
        imageView.setImageResource(data.getImg());
        textView.setText(data.getName());
        del.setText("删除");
        end.setText("不显示");
        dl = convertView.findViewById(R.id.dl);
        dl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull @NotNull View drawerView, float slideOffset) {
                item.setTranslationX((drawerView.getWidth()*slideOffset));
            }

            @Override
            public void onDrawerOpened(@NonNull @NotNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull @NotNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        return convertView;
    }
}
