package com.example.newapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newapplication.R;
import com.example.newapplication.customFont.TextViewCustomFont;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadingQuranAdapter extends RecyclerView.Adapter<ReadingQuranAdapter.ReadingQuranHolder> {

    private List<String> urasList;
    private ItemClick mItemClick;

    public ReadingQuranAdapter(List<String> urasList) {
        this.urasList = urasList;
    }

    @NonNull
    @Override
    public ReadingQuranHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ReadingQuranHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.quran_item, viewGroup, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ReadingQuranHolder readingQuranHolder, int i) {

        readingQuranHolder.TextViewCustomFontName.setText(urasList.get(i));
    }

    @Override
    public int getItemCount() {
        return urasList.size();
    }

    public class ReadingQuranHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.TextViewCustomFontName)
        TextViewCustomFont TextViewCustomFontName;

        private final View view;

        public ReadingQuranHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (mItemClick != null && position != RecyclerView.NO_POSITION) {

                        mItemClick.onItemClicked(position);
                    }
                }
            });
        }
    }

    public void setOnItemClickListener(ItemClick itemClick) {
        this.mItemClick = itemClick;
    }
}

