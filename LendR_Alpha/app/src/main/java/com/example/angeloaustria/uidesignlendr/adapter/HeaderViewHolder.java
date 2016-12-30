package com.example.angeloaustria.uidesignlendr.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.angeloaustria.uidesignlendr.R;

public class HeaderViewHolder extends RecyclerView.ViewHolder{
    public TextView headerTitle;
    public HeaderViewHolder(View itemView) {
        super(itemView);
        headerTitle = (TextView)itemView.findViewById(R.id.header_id);
    }
}