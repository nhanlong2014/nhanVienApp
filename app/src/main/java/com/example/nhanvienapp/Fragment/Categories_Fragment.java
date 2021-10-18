package com.example.nhanvienapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.nhanvienapp.Activity.Category_Form_Activity;
import com.example.nhanvienapp.Adapter.Categories_Adapter;
import com.example.nhanvienapp.Model.Categories;
import com.example.nhanvienapp.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class Categories_Fragment extends Fragment {

    private ExtendedFloatingActionButton floatingActionButton;
    private RecyclerView recyclerView_category;
    private LinearLayoutManager layoutManager;
    private ArrayList<Categories> data = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Loại sản phẩm");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        recyclerView_category = view.findViewById(R.id.recyclerview_categories);
        floatingActionButton = view.findViewById(R.id.extended_fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Category_Form_Activity.class);
                startActivity(i);
            }
        });

        setData();
        setUpRecyclerView();
        showHideWhenScroll();

        return view;
    }

    private void setData(){
        data.add(new Categories(
                001,
                "Áo Polo"));
        data.add(new Categories(
                002,
                "Áo Polo1"));
        data.add(new Categories(
                003,
                "Áo Polo2"));
        data.add(new Categories(
                004,
                "Áo Polo3"));
        data.add(new Categories(
                004,
                "Áo Polo3"));
        data.add(new Categories(
                004,
                "Áo Polo3"));
    }

    private void setUpRecyclerView()
    {
        Categories_Adapter adapter = new Categories_Adapter(getActivity(), data);
        recyclerView_category.setHasFixedSize(true);
        recyclerView_category.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView_category.setLayoutManager(layoutManager);

        // Item long click to edit and delete
        adapter.setOnItemLongClickListener(new Categories_Adapter.OnItemLongClickEventListener() {
            @Override
            public void onItemLongClick(View view, final int position) {
                // Popup menu
                PopupMenu popup = new PopupMenu(getActivity(), view);
                popup.getMenuInflater().inflate(R.menu.main_list_menu, popup.getMenu());

                // Popup menu click event
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem a_item) {

                        final Categories item = data.get(position);
                        switch (a_item.getItemId()) {
                            case R.id.action_edit:
                                Toast.makeText(getActivity(), "Sửa " + item.getMaLoaiSanPham(), Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getActivity(), Category_Form_Activity.class);
                                startActivity(i);
                                break;

                            case R.id.action_delete:
                                Toast.makeText(getActivity(), "Xóa " + item.getMaLoaiSanPham(), Toast.LENGTH_SHORT).show();
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

    private void showHideWhenScroll() {
        recyclerView_category.addOnScrollListener(new RecyclerView.OnScrollListener() {
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