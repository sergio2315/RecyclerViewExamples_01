package com.crisspian.recyclerviewexamples_01.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crisspian.recyclerviewexamples_01.databinding.ItemListDataBinding;
import com.crisspian.recyclerviewexamples_01.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.itemViewHolder> {
private List<Item> itemList;
    public ItemAdapter(List<Item>itemList){
     this.itemList = itemList;
    }
    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListDataBinding binding = ItemListDataBinding.inflate
                (LayoutInflater.from(parent.getContext()),parent,false);
        return new itemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
    Item itemList= this.itemList.get(position);
    holder.textView.setText(itemList.getItemDescription());
    //mostrar la imagen con glide
        Glide.with(holder.imageView.getContext()).load(itemList.getUrlImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class itemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageView;
        public TextView textView;
        public itemViewHolder(@NonNull ItemListDataBinding binding) {
            super(binding.getRoot());
            imageView = binding.ivItem;
            textView = binding.tvItem;
        }

        @Override
    public void onClick(View v) {
            int position = getLayoutPosition();
            Item element = itemList.get(position);
            itemList.set(position,element);
            notifyDataSetChanged();
            //imageList.passElement(element);
    }
}

}
