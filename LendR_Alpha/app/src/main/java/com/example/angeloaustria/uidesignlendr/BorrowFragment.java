package com.example.angeloaustria.uidesignlendr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.angeloaustria.uidesignlendr.adapter.DividerItemDecoration;
import com.example.angeloaustria.uidesignlendr.adapter.BorrowerAdapter;
import com.example.angeloaustria.uidesignlendr.entities.User;

import java.util.ArrayList;
import java.util.List;


public class BorrowFragment extends Fragment{

    private List<User> usersList = new ArrayList<>();

    public BorrowFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        // this is data fro recycler view
        prepareUserData();

        BorrowerAdapter mAdapter = new BorrowerAdapter(usersList);

        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // Inflate the layout for this fragment
        return view;
    }

    private void prepareUserData() {
        usersList.add(new User("Angelo", "100", "1", "$100.00"));
        usersList.add(new User("Nikita", "120", "2", "$200.00"));
        usersList.add(new User("Dmitry", "200", "3", "$300.00"));
        usersList.add(new User("Sam", "250", "4", "$400.00"));
        usersList.add(new User("Angelo", "100", "1", "$100.00"));
        usersList.add(new User("Nikita", "120", "2", "$200.00"));
        usersList.add(new User("Dmitry", "200", "3", "$300.00"));
        usersList.add(new User("Sam", "250", "4", "$400.00"));
        usersList.add(new User("Angelo", "100", "1", "$100.00"));
        usersList.add(new User("Nikita", "120", "2", "$200.00"));
        usersList.add(new User("Dmitry", "200", "3", "$300.00"));
        usersList.add(new User("Sam", "250", "4", "$400.00"));
        usersList.add(new User("Angelo", "100", "1", "$100.00"));
        usersList.add(new User("Nikita", "120", "2", "$200.00"));
        usersList.add(new User("Dmitry", "200", "3", "$300.00"));
        usersList.add(new User("Sam", "250", "4", "$400.00"));
        usersList.add(new User("Angelo", "100", "1", "$100.00"));
        usersList.add(new User("Nikita", "120", "2", "$200.00"));
        usersList.add(new User("Dmitry", "200", "3", "$300.00"));
        usersList.add(new User("Sam", "250", "4", "$400.00"));
    }

}