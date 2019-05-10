package com.example.newapplication.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newapplication.R;
import com.example.newapplication.adapter.ItemClick;
import com.example.newapplication.adapter.ReadingQuranAdapter;
import com.example.newapplication.helper.HelperMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadingFragment extends Fragment {


    @BindView(R.id.RecyclerViewReadingFragment)
    RecyclerView RecyclerViewReadingFragment;
    Unbinder unbinder;

    /* RecyclerView Adapter */
    private ReadingQuranAdapter mReadingQuranAdapter;

    /* member variable for the LinearLayoutManager */
    private LinearLayoutManager mLayoutManager;

    private List<String> list;

    public ReadingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reading, container, false);
        unbinder = ButterKnife.bind(this, view);

        list = new ArrayList<>();
        Collections.addAll(list, HelperMethod.ArSuras);

        mReadingQuranAdapter = new ReadingQuranAdapter(list);
        mReadingQuranAdapter.setOnItemClickListener(new ItemClick() {
            @Override
            public void onItemClicked(int position) {
                Toast.makeText(getContext(), list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        RecyclerViewReadingFragment.setLayoutManager(new GridLayoutManager(getContext(), 3, LinearLayoutManager.HORIZONTAL, false));

        RecyclerViewReadingFragment.setHasFixedSize(true);
        RecyclerViewReadingFragment.setItemAnimator(new DefaultItemAnimator());
        RecyclerViewReadingFragment.setAdapter(mReadingQuranAdapter);



        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
