package com.example.angeloaustria.uidesignlendr.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.angeloaustria.uidesignlendr.R;
import com.example.angeloaustria.uidesignlendr.entities.User;

import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

public class HeaderRecyclerViewSection extends StatelessSection {
    private static final String TAG = HeaderRecyclerViewSection.class.getSimpleName();
    private String title;
    private List<User> list;

    public HeaderRecyclerViewSection(String title, List<User> list) {
        super(R.layout.header_layout, R.layout.item_layout);
        this.title = title;
        this.list = list;
    }

    @Override
    public int getContentItemsTotal() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder iHolder = (ItemViewHolder) holder;
        iHolder.name.setText(list.get(position).getName());
        iHolder.borrowedAmount.setText(list.get(position).getBorrowedAmount());
        iHolder.goodKarma.setText(list.get(position).getGoodKarma());
        iHolder.badKarma.setText(list.get(position).getBadKarma());
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        HeaderViewHolder hHolder = (HeaderViewHolder) holder;
        hHolder.headerTitle.setText(title);
    }
}
