package com.example.newapplication.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.newapplication.R;
import com.example.newapplication.adapter.CustomSpinnerAdapter;
import com.example.newapplication.helper.model.CustomSpinnerItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class SebhaFragment extends Fragment {

    @BindView(R.id.SpinnerSebhaFragment)
    Spinner SpinnerSebhaFragment;
    Unbinder unbinder;
    private ArrayList<CustomSpinnerItem> customList;

    public SebhaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sebha, container, false);
        unbinder = ButterKnife.bind(this, view);

        customList = getCustomList();
        CustomSpinnerAdapter customAdapter=new CustomSpinnerAdapter(getContext(), customList);

        if (SpinnerSebhaFragment != null) {
            SpinnerSebhaFragment.setAdapter(customAdapter);
            SpinnerSebhaFragment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

        return view;
    }

    private ArrayList<CustomSpinnerItem> getCustomList() {
        customList = new ArrayList<>();
        customList.add(new CustomSpinnerItem("استغفر الله"));
        customList.add(new CustomSpinnerItem("سبحان الله"));
        customList.add(new CustomSpinnerItem("الحمدلله"));
        customList.add(new CustomSpinnerItem("لا اله الا الله"));
        customList.add(new CustomSpinnerItem("الله اكبر"));

        return customList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
