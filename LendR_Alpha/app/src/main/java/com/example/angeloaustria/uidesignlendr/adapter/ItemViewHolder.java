package com.example.angeloaustria.uidesignlendr.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.angeloaustria.uidesignlendr.R;

public class ItemViewHolder extends RecyclerView.ViewHolder{
    public TextView borrowedAmount, dueDate, goodKarma, badKarma, name;
    public ItemViewHolder(View itemView) {
        super(itemView);
        borrowedAmount = (TextView)itemView.findViewById(R.id.borrowedAmount);
        name = (TextView)itemView.findViewById(R.id.name);
        dueDate = (TextView)itemView.findViewById(R.id.dueDate);
        goodKarma = (TextView)itemView.findViewById(R.id.goodKarma);
        badKarma = (TextView)itemView.findViewById(R.id.badKarma);
    }
}