package com.example.angeloaustria.uidesignlendr.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.angeloaustria.uidesignlendr.R;
import com.example.angeloaustria.uidesignlendr.entities.User;

import java.util.List;


public class LenderAdapter extends RecyclerView.Adapter<LenderAdapter.MyViewHolder> {

    private List<User> usersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, goodKarma, badKarma, borrowedAmount;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            goodKarma = (TextView) view.findViewById(R.id.goodKarma);
            badKarma = (TextView) view.findViewById(R.id.badKarma);
            borrowedAmount = (TextView) view.findViewById(R.id.borrowedAmount);

        }
    }

    public LenderAdapter(List<User> usersList) {
        this.usersList = usersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lender_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User user = usersList.get(position);
        holder.name.setText(user.getName());
        holder.goodKarma.setText(user.getGoodKarma());
        holder.badKarma.setText(user.getBadKarma());
        holder.borrowedAmount.setText(user.getName() + " borrowed " + user.getBorrowedAmount() + " from you");
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

}
