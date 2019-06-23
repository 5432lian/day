package com.example.lianxi;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.lianxi.Adapter.MainAdapter;
import com.example.lianxi.Fragment.ColickFragment;
import com.example.lianxi.Fragment.HomeFragment;

import java.util.ArrayList;

/**
 * @author 李玉莲
 * @date 2019-6-20 20:33:54
 **/
public class MainActivity extends AppCompatActivity {

    private TextView te;
    private Toolbar tool;
    private TabLayout tabla;
    private NavigationView na;
    private FrameLayout vp;
    private HomeFragment homeFragment;
    private ColickFragment colickFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        te = (TextView) findViewById(R.id.te);
        tool = (Toolbar) findViewById(R.id.tool);
        vp = (FrameLayout) findViewById(R.id.vp);

        tabla = (TabLayout) findViewById(R.id.tabla);
        na = (NavigationView) findViewById(R.id.na);
        setSupportActionBar(tool);


        tabla.addTab(tabla.newTab().setIcon(R.drawable.select).setText("首页"));
        tabla.addTab(tabla.newTab().setIcon(R.drawable.select).setText("收藏"));
        homeFragment = new HomeFragment();
        colickFragment = new ColickFragment();
        //获取碎片管理器
        getSupportFragmentManager().beginTransaction()
         .add(R.id.vp, homeFragment).show(homeFragment)
         .add(R.id.vp, colickFragment).hide(colickFragment)
         .commit();
        tabla.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 if (tab.getPosition()==0){
                     getSupportFragmentManager().beginTransaction()
                             .show(homeFragment)
                             .hide(colickFragment)
                             .commit();
                    }else {
                     getSupportFragmentManager().beginTransaction()
                             .show(colickFragment)
                             .hide(homeFragment)
                             .commit();
                         }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
