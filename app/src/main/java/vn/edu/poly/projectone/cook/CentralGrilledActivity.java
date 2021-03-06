package vn.edu.poly.projectone.cook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.adapter.central.AdapterCentralGrilled;
import vn.edu.poly.projectone.model.Food;

public class CentralGrilledActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterCentralGrilled adapterCentralGrilled;
    private Toolbar toolBar;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_grilled);

        initView();
        initData();
    }
    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterCentralGrilled = new AdapterCentralGrilled(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterCentralGrilled);
        toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.ic_back);
        toolBar.setTitle(getString(R.string.mon_nuong));
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        Food food = new Food(R.drawable.nem_nuong, getString(R.string.nem_nuong),
                getString(R.string.nem_nuong_1) + "\n" + getString(R.string.nem_nuong_2) + "\n" + getString(R.string.nem_nuong_3) + "\n"
                        + getString(R.string.nem_nuong_4) + "\n" + getString(R.string.nem_nuong_5) + "\n" + getString(R.string.nem_nuong_6),
                getString(R.string.nem_nuong_7) + "\n" + getString(R.string.nem_nuong_8) + "\n" + getString(R.string.nem_nuong_9) + "\n"
                        + getString(R.string.nem_nuong_10) + "\n" + getString(R.string.nem_nuong_11) + "\n" + getString(R.string.nem_nuong_12)
                        + "\n" + getString(R.string.nem_nuong_13));
        foodList.add(food);
        food = new Food(R.drawable.banh_trang_nuong, getString(R.string.banh_trang_nuong),
                getString(R.string.banh_trang_nuong_1) + "\n" + getString(R.string.banh_trang_nuong_2) + "\n" + getString(R.string.banh_trang_nuong_3) + "\n"
                        + getString(R.string.banh_trang_nuong_4) + "\n" + getString(R.string.banh_trang_nuong_5) + "\n" + getString(R.string.banh_trang_nuong_6)
                        + "\n" + getString(R.string.banh_trang_nuong_7) + "\n" + getString(R.string.banh_trang_nuong_8),
                getString(R.string.banh_trang_nuong_9) + "\n" + getString(R.string.banh_trang_nuong_10) + "\n" + getString(R.string.banh_trang_nuong_11) + "\n"
                        + getString(R.string.banh_trang_nuong_12));
        foodList.add(food);
        food = new Food(R.drawable.ga_nuong_lu_xoi_chay, getString(R.string.ga_nuong_lu_xoi_chay),
                getString(R.string.ga_nuong_lu_xoi_chay_1) + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_2) + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_3) + "\n"
                        + getString(R.string.ga_nuong_lu_xoi_chay_4) + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_5) + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_6),
                getString(R.string.ga_nuong_lu_xoi_chay_7) + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_8) + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_9) + "\n"
                        + getString(R.string.ga_nuong_lu_xoi_chay_10) + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_11) + "\n" + getString(R.string.ga_nuong_lu_xoi_chay_12));
        foodList.add(food);
        food = new Food(R.drawable.bun_thit_nuong, getString(R.string.bun_thit_nuong),
                getString(R.string.bun_thit_nuong_1) + "\n" + getString(R.string.bun_thit_nuong_2) + "\n" + getString(R.string.bun_thit_nuong_3) + "\n"
                        + getString(R.string.bun_thit_nuong_4) + "\n" + getString(R.string.bun_thit_nuong_5) + "\n" + getString(R.string.bun_thit_nuong_6)
                        + "\n" + getString(R.string.bun_thit_nuong_7) + "\n" + getString(R.string.bun_thit_nuong_8),
                getString(R.string.bun_thit_nuong_9) + "\n" + getString(R.string.bun_thit_nuong_10) + "\n" + getString(R.string.bun_thit_nuong_11));
        foodList.add(food);
        adapterCentralGrilled.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem myActionMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) myActionMenuItem.getActionView();
        changeSearchViewTextColor(searchView);
        ((EditText) searchView.findViewById(
                android.support.v7.appcompat.R.id.search_src_text)).
                setHintTextColor(getResources().getColor(R.color.white));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                final  List<Food> filtermodelist=filter(foodList,newText);
                adapterCentralGrilled.setfilter(filtermodelist);
                return true;
            }
        });
        return true;
    }
    private List<Food> filter(List<Food> pl,String query) {
        query=query.toLowerCase();
        final List<Food> filteredModeList=new ArrayList<>();
        for (Food model:pl)
        {
            final String text=model.getTitle().toLowerCase();
            if (text.startsWith(query)) {
                filteredModeList.add(model);
            }
        }
        return filteredModeList;
    }
    //for changing the text color of searchview
    private void changeSearchViewTextColor(View view) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(Color.BLACK);
                return;
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    changeSearchViewTextColor(viewGroup.getChildAt(i));
                }
            }
        }
    }
}
