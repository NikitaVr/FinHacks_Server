package com.example.angeloaustria.uidesignlendr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.angeloaustria.uidesignlendr.adapter.HeaderRecyclerViewSection;
import com.example.angeloaustria.uidesignlendr.entities.User;

import java.util.ArrayList;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;


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
        View view = inflater.inflate(R.layout.fragment_five, container, false);

        RecyclerView sectionHeader = (RecyclerView)view.findViewById(R.id.add_header);
        //sectionHeader.setNestedScrollingEnabled(false);
        sectionHeader.setLayoutManager(new LinearLayoutManager(getActivity()));

        HeaderRecyclerViewSection firstSection = new HeaderRecyclerViewSection("Borrow History",
                getDataSource());
        //HeaderRecyclerViewSection secondSection = new HeaderRecyclerViewSection("Paydays",
        //        getDataSource());
        //HeaderRecyclerViewSection thirdSection = new HeaderRecyclerViewSection("Third Section",
        //        getDataSource());

        SectionedRecyclerViewAdapter sectionAdapter = new SectionedRecyclerViewAdapter();
        sectionAdapter.addSection(firstSection);
        //sectionAdapter.addSection(secondSection);
        //sectionAdapter.addSection(thirdSection);

        sectionHeader.setAdapter(sectionAdapter);

        return view;
    }

    private List<User> getDataSource(){
        List<User> data = new ArrayList<>();
        data.add(new User("Angelo", "100", "1", "$100.00"));
        data.add(new User("Nikita", "120", "2", "$200.00"));
        data.add(new User("Dmitry", "200", "3", "$300.00"));
        data.add(new User("Sam", "250", "4", "$400.00"));
        data.add(new User("Angelo", "100", "1", "$100.00"));
        data.add(new User("Nikita", "120", "2", "$200.00"));
        data.add(new User("Dmitry", "200", "3", "$300.00"));
        data.add(new User("Sam", "250", "4", "$400.00"));
        data.add(new User("Angelo", "100", "1", "$100.00"));
        data.add(new User("Nikita", "120", "2", "$200.00"));
        data.add(new User("Dmitry", "200", "3", "$300.00"));
        data.add(new User("Sam", "250", "4", "$400.00"));
        data.add(new User("Angelo", "100", "1", "$100.00"));
        data.add(new User("Nikita", "120", "2", "$200.00"));
        data.add(new User("Dmitry", "200", "3", "$300.00"));
        data.add(new User("Sam", "250", "4", "$400.00"));
        data.add(new User("Angelo", "100", "1", "$100.00"));
        data.add(new User("Nikita", "120", "2", "$200.00"));
        data.add(new User("Dmitry", "200", "3", "$300.00"));
        data.add(new User("Sam", "250", "4", "$400.00"));

        return data;
    }

}