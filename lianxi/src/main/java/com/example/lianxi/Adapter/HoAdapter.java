package com.example.lianxi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lianxi.Bean.DatasBean;
import com.example.lianxi.R;
import com.example.lianxi.util.User;

import java.util.ArrayList;

public class HoAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<DatasBean> list;

    public HoAdapter(Context mContext, ArrayList<DatasBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_item, null);
        Item item = new Item(inflate);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Item item = (Item) holder;
        item.item_te.setText(list.get(position).getTitle());
        item.ch.setTag(position);
        item.ch.setChecked(list.get(position).getChe());
        if (list.get(position).getChe() == false) {
            item.ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    list.get(position).setChe(true);
                    DatasBean datasBean = list.get(position);
                    User.insert(datasBean);
                    Toast.makeText(mContext, "收藏成功", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            item.ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    list.get(position).setChe(false);
                    DatasBean datasBean = list.get(position);
                    list.remove(position);
                    User.delete(datasBean);
                    notifyDataSetChanged();
                    Toast.makeText(mContext, "取消收藏", Toast.LENGTH_SHORT).show();
                }
            });
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclick != null) {
                    onclick.onclick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Item extends RecyclerView.ViewHolder {

        private TextView item_te;
        private CheckBox ch;

        public Item(View itemView) {
            super(itemView);
            item_te = itemView.findViewById(R.id.item_te);
            ch = itemView.findViewById(R.id.ch);
        }
    }

    private Onclick onclick;

    public interface Onclick {
        void onclick(int position);
    }

    public void setOnclick(Onclick onclick) {
        this.onclick = onclick;
    }
}
