package com.crisspian.recyclerviewexamples_01.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crisspian.recyclerviewexamples_01.databinding.ItemListDataBinding;
import com.crisspian.recyclerviewexamples_01.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.imageViewHolder> {
private List<Item>imageList;
    public ItemAdapter(List<Item>imageList){
     this.imageList = imageList;
    }
    @NonNull
    @Override
    public imageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListDataBinding binding = ItemListDataBinding.inflate
                (LayoutInflater.from(parent.getContext()),parent,false);
        return new imageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull imageViewHolder holder, int position) {
    Item itemImage= imageList.get(position);
    //holder
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class imageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public imageViewHolder(@NonNull ItemListDataBinding binding) {
            super(binding.getRoot());
//trabajar aqui
        }

        @Override
    public void onClick(View v) {
            int position = getLayoutPosition();
            Item element = imageList.get(position);
            imageList.set(position,element);
            notifyDataSetChanged();
            //imageList.passElement(element);
    }
}

}
