package com.example.nhanvienapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.nhanvienapp.Fragment.History_Fragment;
import com.example.nhanvienapp.Fragment.Categories_Fragment;
import com.example.nhanvienapp.Fragment.Invoice_Fragment;
import com.example.nhanvienapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main_Activity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);
        openFragment(new Categories_Fragment());

        bottomNavigationView.setOnItemSelectedListener (new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.loaiSanPham_Fragment:
                        openFragment(new Categories_Fragment());
                        return true;

                    case R.id.taoHoaDon_Fragment:
                        openFragment(new Invoice_Fragment());
                        return true;

                    case R.id.lichSu_Fragment:
                        openFragment(new History_Fragment());
                        return true;
                }
                return false;
            }
        });
    }

    void openFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //Menu ActionBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_search){
            Toast.makeText(this, "Click Search Icon.", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.nav_account){
            Toast.makeText(this, "Click Account Icon.", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Main_Activity.this, EmploymentInfo_Activity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}