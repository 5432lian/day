package com.example.lianxi.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.lianxi.Adapter.HoAdapter;
import com.example.lianxi.Bean.DatasBean;
import com.example.lianxi.R;
import com.example.lianxi.util.App;
import com.example.lianxi.util.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColickFragment extends Fragment {


    private RecyclerView rlv;
    ArrayList<DatasBean> list = new ArrayList<>();
    private HoAdapter hoAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View inflate = inflater.inflate(R.layout.fragment_home, container, false);

        TabLayout tab = getActivity().findViewById(R.id.tabla);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {

                } else if (tab.getPosition() == 1) {
                    list.clear();
                    initView(inflate);
                    initData();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return inflate;
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser){
//            initData();
//        }else {
//            list.clear();
//        }
//    }

    private void initData() {
//        List<DatasBean> dbBeans = Dbhelper.getUtil().queryAll();
        List<DatasBean> datasBeans = App.getDaoSession().getDatasBeanDao().loadAll();
        list.addAll(datasBeans);
        hoAdapter.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        CheckBox ch = inflate.findViewById(R.id.ch);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        hoAdapter = new HoAdapter(getContext(), list);
        rlv.setAdapter(hoAdapter);
//        hoAdapter.setOnclick(new HoAdapter.Onclick() {
//            @Override
//            public void onclick(int position) {
//                DatasBean datasBean = list.get(position);
//                list.remove(position);
//                User.delete(datasBean);
//                hoAdapter.notifyDataSetChanged();
//                Toast.makeText(getContext(), "取消收藏 ", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
