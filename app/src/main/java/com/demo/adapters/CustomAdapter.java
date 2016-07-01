package com.demo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.gravid.R;

import java.util.List;


public class CustomAdapter extends BaseAdapter {

    private LayoutInflater lInflater;
    private List<Weeks_ItemObject> listStorage;

    public CustomAdapter(Context context, List<Weeks_ItemObject> customizedListView) {
        lInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = lInflater.inflate(R.layout.weeks_listview, parent, false);

            listViewHolder.textInListView = (TextView)convertView.findViewById(R.id.WeeksList_textView);
            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.WeeksList_imageView);
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.textInListView.setText(listStorage.get(position).getName());
        listViewHolder.imageInListView.setImageResource(listStorage.get(position).getImageId());

        return convertView;
    }

    static class ViewHolder{

        TextView textInListView;
        ImageView imageInListView;
    }
}