package com.example.angeloaustria.uidesignlendr.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.angeloaustria.uidesignlendr.R;
import com.example.angeloaustria.uidesignlendr.entities.User;

import java.util.List;


public class BorrowerAdapter extends RecyclerView.Adapter<BorrowerAdapter.MyViewHolder> {

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

    public BorrowerAdapter(List<User> usersList) {
        this.usersList = usersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User user = usersList.get(position);
        holder.name.setText(user.getName());
        holder.goodKarma.setText("Good Karma: " + user.getGoodKarma());
        holder.badKarma.setText("Bad Karma: " + user.getBadKarma());
        holder.borrowedAmount.setText("You borrowed " + user.getBorrowedAmount() + " from " + user.getName());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

}
