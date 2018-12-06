package vn.edu.poly.projectone.type;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.adapter.northern.AdapterNorthernCow;
import vn.edu.poly.projectone.model.Food;

public class NorthernCowActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterNorthernCow adapterNorthernCow;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northern_cow);

        initView();
        initData();
    }

    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterNorthernCow = new AdapterNorthernCow(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterNorthernCow);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.thit_bo));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.bo_sot_vang, getString(R.string.bo_sot_vang),
                getString(R.string.bo_sot_vang_1) + "\n" + getString(R.string.bo_sot_vang_2)
                        + "\n" + getString(R.string.bo_sot_vang_3) + "\n"
                        + getString(R.string.bo_sot_vang_4) + "\n" + getString(R.string.bo_sot_vang_5)
                        + "\n" + getString(R.string.bo_sot_vang_6) + "\n" + getString(R.string.bo_sot_vang_7),
                getString(R.string.bo_sot_vang_8) + "\n" + getString(R.string.bo_sot_vang_9)
                        + "\n" + getString(R.string.bo_sot_vang_10) + "\n"
                        + getString(R.string.bo_sot_vang_11) + "\n" + getString(R.string.bo_sot_vang_12));
        foodList.add(food);
        food = new Food(R.drawable.bo_sot_tieu_den, getString(R.string.bo_sot_tieu),
                getString(R.string.bo_sot_tieu_1) + "\n" + getString(R.string.bo_sot_tieu_2)
                        + "\n" + getString(R.string.bo_sot_tieu_3) + "\n"
                        + getString(R.string.bo_sot_tieu_4) + "\n" + getString(R.string.bo_sot_tieu_5)
                        + "\n" + getString(R.string.bo_sot_tieu_6),
                getString(R.string.bo_sot_tieu_7) + "\n" + getString(R.string.bo_sot_tieu_8)
                        + "\n" + getString(R.string.bo_sot_tieu_9) + "\n"
                        + getString(R.string.bo_sot_tieu_10) + "\n" + getString(R.string.bo_sot_tieu_11)
                        + "\n" + getString(R.string.bo_sot_tieu_12) + "\n" + getString(R.string.bo_sot_tieu_13));
        foodList.add(food);
        food = new Food(R.drawable.pho_bo, getString(R.string.pho_bo),
                getString(R.string.pho_bo_1) + "\n" + getString(R.string.pho_bo_2)
                        + "\n" + getString(R.string.pho_bo_3) + "\n"
                        + getString(R.string.pho_bo_4) + "\n" + getString(R.string.pho_bo_5)
                        + "\n" + getString(R.string.pho_bo_6) + "\n" + getString(R.string.pho_bo_7),
                getString(R.string.pho_bo_8) + "\n" + getString(R.string.pho_bo_9)
                        + "\n" + getString(R.string.pho_bo_10) + "\n"
                        + getString(R.string.pho_bo_11) + "\n" + getString(R.string.pho_bo_12)
                        + "\n" + getString(R.string.pho_bo_13) + "\n" + getString(R.string.pho_bo_14));
        foodList.add(food);
        food = new Food(R.drawable.bo_xao_pho, getString(R.string.bo_xao_pho),
                getString(R.string.bo_xao_pho_1) + "\n" + getString(R.string.bo_xao_pho_2)
                        + "\n" + getString(R.string.bo_xao_pho_3) + "\n"
                        + getString(R.string.bo_xao_pho_4) + "\n" + getString(R.string.bo_xao_pho_5)
                        + "\n" + getString(R.string.bo_xao_pho_6) + "\n" + getString(R.string.bo_xao_pho_7)
                        + "\n" + getString(R.string.bo_xao_pho_8) + "\n"
                        + getString(R.string.bo_xao_pho_9) + "\n" + getString(R.string.bo_xao_pho_10),
                getString(R.string.bo_xao_pho_11) + "\n" + getString(R.string.bo_xao_pho_12)
                        + "\n" + getString(R.string.bo_xao_pho_13) + "\n"
                        + getString(R.string.bo_xao_pho_14) + "\n" + getString(R.string.bo_xao_pho_15));
        foodList.add(food);
        food = new Food(R.drawable.rau_muong_xao_thit_bo, getString(R.string.rau_muong_xao_thit_bo),
                getString(R.string.rau_muong_xao_thit_bo_1) + "\n" + getString(R.string.rau_muong_xao_thit_bo_2)
                        + "\n" + getString(R.string.rau_muong_xao_thit_bo_3),
                getString(R.string.rau_muong_xao_thit_bo_4) + "\n" + getString(R.string.rau_muong_xao_thit_bo_5)
                        + "\n" + getString(R.string.rau_muong_xao_thit_bo_6) + "\n"
                        + getString(R.string.rau_muong_xao_thit_bo_7) + "\n" + getString(R.string.rau_muong_xao_thit_bo_8)
                        + "\n" + getString(R.string.banh_canh_ghe_6) + "\n" + getString(R.string.banh_canh_ghe_7));
        foodList.add(food);
        adapterNorthernCow.notifyDataSetChanged();
    }
}
