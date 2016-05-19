package com.example.administrator.myapplication.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.fragment.ChartFragment;
import com.example.administrator.myapplication.activity.fragment.ItemListenningFragment;
import com.example.administrator.myapplication.activity.fragment.ItemTranslationFragment;
import com.example.administrator.myapplication.activity.fragment.ItemWritingFragment;
import com.example.administrator.myapplication.activity.fragment.PullFragment;

/**
 * Created by 沙云杰 on 2016/5/3.
 */
public class NavigationActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nagivation);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.nav_view);
        //为NavigationView中的header中的textview命名
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
//        Log.v("-------------",userName);
        navigationView.getHeaderView(0);
        TextView textView = (TextView)navigationView.findViewById(R.id.tv_username);
  //      textView.setText(userName);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
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
        if(menuItem.getItemId() == R.id.nav_read){
            Intent intent = new Intent (this,ReadingActivity.class);
            startActivity(intent);
        }else {
            switch (menuItem.getItemId()) {
                case R.id.nav_liten:
                    fragmentClass = ItemListenningFragment.class;
                    break;

//            case R.id.nav_read:
//                Intent intent = new Intent(this,ReadingActivity.class);
//                startActivity(intent);


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
//            default :
//                fragmentClass = ItemWritingFragment.class;
//                break;
            }

            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layout_replace, fragment).commit();

        }
        // 选中高亮
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();
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
