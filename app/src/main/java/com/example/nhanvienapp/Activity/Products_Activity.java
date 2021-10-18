package com.example.nhanvienapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.nhanvienapp.Adapter.Categories_Adapter;
import com.example.nhanvienapp.Adapter.Products_Adapter;
import com.example.nhanvienapp.Model.Products;
import com.example.nhanvienapp.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class Products_Activity extends AppCompatActivity {

    private ExtendedFloatingActionButton floatingActionButton;
    private RecyclerView recyclerView_product;
    private LinearLayoutManager layoutManager;
    private ArrayList<Products> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Áo Polo");
        setContentView(R.layout.activity_products);

        recyclerView_product = findViewById(R.id.recyclerview_products);
        floatingActionButton = findViewById(R.id.extended_fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Products_Activity.this, Product_Form_Activity.class);
                startActivity(i);
            }
        });

        setData();
        setUpRecyclerView();
        showHideWhenScroll();

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setData(){
        data.add(new Products(
                001,
                "Áo Polo nam đẹp local brand Davies Black High Low",
                "https://product.hstatic.net/1000068564/product/img_7970_75bbeed385e84801a5bcb227b31a2442_master.jpg",
                20,
                295.000));
        data.add(new Products(
                002,
                "Áo Polo nam đẹp local brand Davies Black High Low",
                "https://product.hstatic.net/200000314865/product/7_6561fd140928417f89c9e6db46184383_grande.jpg",
                20,
                295.000));
        data.add(new Products(
                003,
                "Áo Polo nam đẹp local brand Davies Black High Low",
                "https://product.hstatic.net/200000314865/product/3_77a9bf3c925041208bd847dd66470958_1024x1024.jpg",
                20,
                295.000));
        data.add(new Products(
                003,
                "Áo Polo nam đẹp local brand Davies Black High Low",
                "https://product.hstatic.net/200000314865/product/3_77a9bf3c925041208bd847dd66470958_1024x1024.jpg",
                20,
                295.000));
        data.add(new Products(
                003,
                "Áo Polo nam đẹp local brand Davies Black High Low",
                "https://product.hstatic.net/200000314865/product/3_77a9bf3c925041208bd847dd66470958_1024x1024.jpg",
                20,
                295.000));
    }

    private void setUpRecyclerView(){
        Products_Adapter adapter = new Products_Adapter(data);
        recyclerView_product.setHasFixedSize(true);
        recyclerView_product.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView_product.setLayoutManager(layoutManager);

        // Item long click to edit and delete
        adapter.setOnItemLongClickListener(new Categories_Adapter.OnItemLongClickEventListener() {
            @Override
            public void onItemLongClick(View view, final int position) {
                // Popup menu
                PopupMenu popup = new PopupMenu(Products_Activity.this, view);
                popup.getMenuInflater().inflate(R.menu.main_list_menu, popup.getMenu());

                // Popup menu click event
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem a_item) {

                        final Products item = data.get(position);
                        switch (a_item.getItemId()) {
                            case R.id.action_edit:
                                Toast.makeText(Products_Activity.this, "Sửa " + item.getMaSanPham(), Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Products_Activity.this, Product_Form_Activity.class);
                                startActivity(i);
                                break;

                            case R.id.action_delete:
                                Toast.makeText(Products_Activity.this, "Xóa " + item.getMaSanPham(), Toast.LENGTH_SHORT).show();
                                break;

                            default:
                                break;
                        }
                        return false;
                    }
                });

                // Popup
                popup.show();
            }
        });
    }

    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showHideWhenScroll() {
        recyclerView_product.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //dy > 0: scroll up; dy < 0: scroll down
                if (dy > 0) floatingActionButton.hide();
                else floatingActionButton.show();
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}