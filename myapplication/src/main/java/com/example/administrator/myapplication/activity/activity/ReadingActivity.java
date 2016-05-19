package com.example.administrator.myapplication.activity.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.adapter.RViewPageAdapter;
import com.example.administrator.myapplication.activity.fragment.ChartFragment;
import com.example.administrator.myapplication.activity.fragment.ItemLRFragment;
import com.example.administrator.myapplication.activity.fragment.ItemListenningFragment;
import com.example.administrator.myapplication.activity.fragment.ItemSRFragment;
import com.example.administrator.myapplication.activity.fragment.ItemSWFragment;
import com.example.administrator.myapplication.activity.fragment.ItemTranslationFragment;
import com.example.administrator.myapplication.activity.fragment.ItemWritingFragment;
import com.example.administrator.myapplication.activity.fragment.PullFragment;

/**
 * Created by 沙云杰 on 2016/5/3.
 */
public class ReadingActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nagivation_read);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.nav_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setTitle("翻译");
        ab.setDisplayHomeAsUpEnabled(true);

        setDrawerContent(navigationView);

    }
    void setDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener()
                {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem)
                    {
                        changeFragmentContent(menuItem);
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }
    void changeFragmentContent(MenuItem menuItem){
        Fragment fragment = null;
        Class fragmentClass = null;
        if(menuItem.getItemId()==R.id.nav_read){
            //do nothing
//            Intent intent = new Intent(ReadingActivity.this, ReadingActivity.class);
//            startActivity(intent);
        }else {
            switch (menuItem.getItemId()) {
                case R.id.nav_liten:
                    fragmentClass = ItemListenningFragment.class;
                    break;

                case R.id.nav_read:
//                    Intent intent = new Intent(ReadingActivity.this, ReadingActivity.class);
//                    startActivity(intent);
                    break;

                case R.id.nav_traslate:
                    fragmentClass = ItemTranslationFragment.class;
                    break;
                case R.id.nav_write:
                    fragmentClass = ItemWritingFragment.class;
                    break;
                case R.id.nav_pull:
                    fragmentClass = PullFragment.class;
                    break;
                case R.id.nav_chart:
                    fragmentClass = ChartFragment.class;
                    break;
            }

            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.viewpager, fragment).commit();
        }

        // 选中高亮
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();
    }
    void setupViewPager(ViewPager viewPager){
        RViewPageAdapter adapter = new RViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ItemLRFragment(), "LongReading");
        adapter.addFragment(new ItemSRFragment(), "ShortReading");
        adapter.addFragment(new ItemSWFragment(), "SelectWord");
        viewPager.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
