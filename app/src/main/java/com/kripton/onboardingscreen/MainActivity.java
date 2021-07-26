package com.kripton.onboardingscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    Button next;
    int size,ci=0;
    List<Model> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = findViewById(R.id.next);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewpager);
        list.add(new Model("Google","I am a developer at google and I love to develop Android apps",R.drawable.gogle));
        list.add(new Model("Google","I am a developer at github and I have develop a calc app",R.drawable.calc_icon));
        list.add(new Model("Google","I am a developer at facebook and I love to develop Android apps",R.drawable.image));
        Adapter adapter = new Adapter(list);
        size = list.size();
        viewPager2.setAdapter(adapter);
        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> {})).attach();
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position == list.size()-1)
                {
                    next.setText("GET START");
                }
                else
                {
                    next.setText("NEXT");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ci = viewPager2.getCurrentItem();
                if(ci<size)
                {
                    ci=ci+1;
                    viewPager2.setCurrentItem(ci);
                }
                if(ci==size) {
                    Intent intent = new Intent(getApplicationContext(), IndexMain.class);
                    startActivity(intent);
                    finish();
                }

            }
        });


    }
}