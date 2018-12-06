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
import vn.edu.poly.projectone.adapter.northern.AdapterNorthernChicken;
import vn.edu.poly.projectone.model.Food;

public class NorthernChickenActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterNorthernChicken adapterNorthernChicken;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northern_chicken);
        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterNorthernChicken = new AdapterNorthernChicken(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterNorthernChicken);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.thit_ga));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.chao_ga_mien_bac, getString(R.string.chao_ga),
                getString(R.string.chao_ga_1) + "\n" + getString(R.string.chao_ga_2)
                        + "\n" + getString(R.string.chao_ga_3) + "\n"
                        + getString(R.string.chao_ga_4) + "\n" + getString(R.string.chao_ga_5)
                        + "\n" + getString(R.string.chao_ga_6) + "\n" + getString(R.string.chao_ga_7)
                        + "\n" + getString(R.string.chao_ga_8) + "\n"
                        + getString(R.string.chao_ga_9),
                getString(R.string.chao_ga_10) + "\n" + getString(R.string.chao_ga_11)
                        + "\n" + getString(R.string.chao_ga_12) + "\n"
                        + getString(R.string.chao_ga_13) + "\n" + getString(R.string.chao_ga_14));
        foodList.add(food);
        food = new Food(R.drawable.ga_rim_nuoc_mam, getString(R.string.ga_rim_nuoc_mam),
                getString(R.string.ga_rim_nuoc_mam_1) + "\n" + getString(R.string.ga_rim_nuoc_mam_2),
                getString(R.string.ga_rim_nuoc_mam_3) + "\n" + getString(R.string.ga_rim_nuoc_mam_4)
                        + "\n" + getString(R.string.ga_rim_nuoc_mam_5) + "\n"
                        + getString(R.string.ga_rim_nuoc_mam_6));
        foodList.add(food);
        food = new Food(R.drawable.sup_ga, getString(R.string.sup_ga),
                getString(R.string.sup_ga_1) + "\n" + getString(R.string.sup_ga_2)
                        + "\n" + getString(R.string.sup_ga_3) + "\n"
                        + getString(R.string.sup_ga_4) + "\n" + getString(R.string.sup_ga_5)
                        + "\n" + getString(R.string.sup_ga_6) + "\n" + getString(R.string.sup_ga_7)
                        + "\n" + getString(R.string.sup_ga_8),
                getString(R.string.sup_ga_9) + "\n" + getString(R.string.sup_ga_10)
                        + "\n" + getString(R.string.sup_ga_11) + "\n"
                        + getString(R.string.sup_ga_12));
        foodList.add(food);
        food = new Food(R.drawable.pho_ga, getString(R.string.pho_ga),
                getString(R.string.pho_ga_1) + "\n" + getString(R.string.pho_ga_2)
                        + "\n" + getString(R.string.pho_ga_3) + "\n"
                        + getString(R.string.pho_ga_4) + "\n" + getString(R.string.pho_ga_5)
                        + "\n" + getString(R.string.pho_ga_6) + "\n" + getString(R.string.pho_ga_7),
                getString(R.string.pho_ga_8) + "\n" + getString(R.string.pho_ga_9)
                        + "\n" + getString(R.string.pho_ga_10) + "\n"
                        + getString(R.string.pho_ga_11) + "\n" + getString(R.string.pho_ga_12)
                        + "\n" + getString(R.string.pho_ga_13) + "\n" + getString(R.string.pho_ga_14));
        foodList.add(food);
        adapterNorthernChicken.notifyDataSetChanged();
    }
}
