package vn.edu.poly.projectone.activity;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import vn.edu.poly.projectone.R;
import vn.edu.poly.projectone.adapter.AdapterCentral;
import vn.edu.poly.projectone.model.Food;



public class CentralActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private List<Food> foodList;
    private RecyclerView rcView;
    private AdapterCentral adapterCentral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);
        toolBar = findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        initCollapsingToolbar();
        try {
            Glide.with(this).load(R.drawable.mientrung).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
        initView();
        initData();
    }
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.central));
                    toolBar.setNavigationIcon(R.drawable.ic_back);
                    toolBar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onBackPressed();
                        }
                    });
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    toolBar.setNavigationIcon(null);
                    isShow = false;
                }
            }
        });
    }

    private void initView() {
        rcView = findViewById(R.id.rcView);
        foodList = new ArrayList<>();
        adapterCentral = new AdapterCentral(this, foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapterCentral);
    }

    private void initData() {
        Food food = new Food(R.drawable.mon_nuong, getString(R.string.mon_nuong), "","");
        foodList.add(food);
        food = new Food(R.drawable.mon_xao, getString(R.string.mon_xao), "","");
        foodList.add(food);
        food = new Food(R.drawable.mon_chien, getString(R.string.mon_chien), "","");
        foodList.add(food);
        food = new Food(R.drawable.thit_bo, getString(R.string.thit_bo), "","");
        foodList.add(food);
        food = new Food(R.drawable.thit_ga, getString(R.string.thit_ga), "","");
        foodList.add(food);
        food = new Food(R.drawable.thit_lon, getString(R.string.thit_lon), "","");
        foodList.add(food);
        food = new Food(R.drawable.hai_san, getString(R.string.hai_san), "","");
        foodList.add(food);
        adapterCentral.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.idDiary) {
            Intent intent = new Intent(CentralActivity.this, DiaryActivity.class);
            startActivity(intent);
            return true;
        }if (id == R.id.idLanguage){
            Intent intent = new Intent(CentralActivity.this, ChageLanguageActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
