package com.example.nhanvienapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhanvienapp.Model.Products;
import com.example.nhanvienapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Products_Adapter extends RecyclerView.Adapter<Products_Adapter.ViewHolder> {

    private ArrayList<Products> data;

    public Products_Adapter(ArrayList<Products> data) {
        this.data = data;
    }

    // Item long click event listener
    public interface OnItemLongClickEventListener {
        void onItemLongClick(View view, int position);
    }

    private Categories_Adapter.OnItemLongClickEventListener mItemLongClickListener;

    public void setOnItemLongClickListener(Categories_Adapter.OnItemLongClickEventListener listener) {
        mItemLongClickListener = listener;
    }

    @NonNull
    @Override
    public Products_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products, parent, false);
        return new Products_Adapter.ViewHolder(view, mItemLongClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull Products_Adapter.ViewHolder holder, int position) {
        holder.maSanPham.setText(data.get(position).getMaSanPham().toString());
        holder.tenSanPham.setText(data.get(position).getTenSanPham());
        holder.soLuong.setText(data.get(position).getSoLuong().toString());
        holder.giaTien.setText(data.get(position).getGiaTien().toString());
        Picasso.get()
                .load(data.get(position).getHinhSanPham())
                .fit()
                .centerCrop()
                .into(holder.hinhSanPham);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView maSanPham, tenSanPham, soLuong, giaTien;
        ImageView hinhSanPham;

        public ViewHolder(@NonNull View itemView, final Categories_Adapter.OnItemLongClickEventListener itemLongClickListener) {
            super(itemView);
            maSanPham = itemView.findViewById(R.id.txt_product_id);
            tenSanPham = itemView.findViewById(R.id.txt_product_name);
            soLuong = itemView.findViewById(R.id.txt_product_quantity);
            giaTien = itemView.findViewById(R.id.txt_product_price);
            hinhSanPham = itemView.findViewById(R.id.img_product);

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
