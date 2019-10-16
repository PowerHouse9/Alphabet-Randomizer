package com.example.randomalphabet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;
    List<Fragment> list;
    Button nextButton;
    Button backButton;
    int page = 0;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton = findViewById(R.id.nextBtn);
        backButton = findViewById(R.id.backBtn);

        backButton.setVisibility(View.GONE);

        list = new ArrayList<>();
//        list.add(new webviewFragment());

        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(pagerAdapter);

        nextBtnClicked();
        backBtnClicked();

        pageChange();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.addButton) {
            Toast.makeText(MainActivity.this, "Plus Button Clicked, List Size:" + list.size(), Toast.LENGTH_SHORT).show();
            pagerAdapter.addView(new webviewFragment(),list.size());
            viewPager.setCurrentItem(list.size(),true);
        }
        else if (i == R.id.deleteButton) {
            Toast.makeText(MainActivity.this, "Delete Button Clicked", Toast.LENGTH_SHORT).show();
            pagerAdapter.removeView(viewPager.getCurrentItem());
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1,true);
        }
        return super.onOptionsItemSelected(item);
    }

    public void nextBtnClicked () {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "CurrentItem:" + viewPager.getCurrentItem(),Toast.LENGTH_SHORT).show();
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            }
        });
    }

    public void backBtnClicked () {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
            }
        });
    }

    private void pageChange() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page = position;
                if (position == 0) {
                    backButton.setVisibility(View.GONE);
                    nextButton.setVisibility(View.VISIBLE);
                }
                else if (position == list.size() - 1) {
                    backButton.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.GONE);
                }
                else {
                    backButton.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void addViewPage () {
        list.add(new webviewFragment());
    }
}
