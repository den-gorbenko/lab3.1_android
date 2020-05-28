package com.example.lab3_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends BaseAdapter {


    private List<MainActivity.Fruit> data;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<MainActivity.Fruit> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Check if we have a list item for reuse
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, parent, false);

        // 2. Get access to the object tree widgets
        TextView Name = convertView.findViewById(R.id.Name);
        ImageView image = convertView.findViewById(R.id.imageView);

        // 3. Change the contents of widgets
        Name.setText(data.get(position).getName());
        image.setImageResource(data.get(position).getAvatarId());

        // 4. We return the modified tree of objects
        return convertView;
    }
}
