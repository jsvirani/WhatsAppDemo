package com.example.whatsappdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    TabLayout t1;
    ViewPager vp;
    Fragement fm;
    BottomNavigationView bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.t1);
        vp=findViewById(R.id.vp);
        bn=findViewById(R.id.bn);
      // Fragment1 f1 = new Fragment1();//
        //Fragment2 f2 = new Fragment2();
        fm=new Fragement(getSupportFragmentManager());
        fm.add(new Fragment1(),"Chat");
        fm.add(new Fragment2(),"Status");
        fm.add(new Fragment3(),"Calls");
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case 0:
                        bn.getMenu().findItem(R.id.chat1).setChecked(true);
                        break;
                    case 1:
                        bn.getMenu().findItem(R.id.status1).setChecked(true);
                        break;
                    case 2:
                        bn.getMenu().findItem(R.id.calls1).setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        vp.setAdapter(fm);
        t1.setupWithViewPager(vp);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.chat1:
                vp.setCurrentItem(0);
                break;
            case R.id.status1:
                vp.setCurrentItem(1);
                break;
            case R.id.calls1:
                vp.setCurrentItem(2);
                break;
        }
        return true;
    }
}