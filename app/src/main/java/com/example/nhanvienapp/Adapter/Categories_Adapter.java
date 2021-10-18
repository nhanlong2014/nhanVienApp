package com.example.nhanvienapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhanvienapp.Activity.Products_Activity;
import com.example.nhanvienapp.Model.Categories;
import com.example.nhanvienapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Categories_Adapter extends RecyclerView.Adapter<Categories_Adapter.ViewHolder>{

    private Context context;
    private ArrayList<Categories> data;

    public Categories_Adapter(Context context, ArrayList<Categories> data) {
        this.context = context;
        this.data = data;
    }

    // Item long click event listener
    public interface OnItemLongClickEventListener {
        void onItemLongClick(View view, int position);
    }

    private OnItemLongClickEventListener mItemLongClickListener;

    public void setOnItemLongClickListener(OnItemLongClickEventListener listener) {
        mItemLongClickListener = listener;
    }

    @NonNull
    @Override
    public Categories_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories, parent, false);
        return new ViewHolder(view, mItemLongClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull Categories_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.maLoaiSanPham.setText(data.get(position).getMaLoaiSanPham().toString());
        holder.tenLoaiSanPham.setText(data.get(position).getTenLoaiSanPham());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).getTenLoaiSanPham() + " is clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, Products_Activity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView maLoaiSanPham, tenLoaiSanPham;

        public ViewHolder(@NonNull View itemView, final OnItemLongClickEventListener itemLongClickListener) {
            super(itemView);
            maLoaiSanPham = itemView.findViewById(R.id.txt_category_id);
            tenLoaiSanPham = itemView.findViewById(R.id.txt_category_name);

            // long Click event
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    final int position = getAbsoluteAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        itemLongClickListener.onItemLongClick(view, position);
                    }

                    return false;
                }
            });
        }
    }
}
