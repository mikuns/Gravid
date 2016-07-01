package com.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.gravid.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<ItemObject1> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<ItemObject1> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.activityName.setText(itemList.get(position).getName());
        holder.activitypic.setImageResource(itemList.get(position).getPhoto());
        holder.activityDesc.setText(itemList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
