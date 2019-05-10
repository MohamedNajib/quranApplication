package com.example.newapplication.ui.activitise;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;

import com.example.newapplication.R;
import com.example.newapplication.ui.fragment.ReadingFragment;
import com.example.newapplication.ui.fragment.SebhaFragment;
import com.example.newapplication.adapter.ViewPagerTapsAdapter;
import com.example.newapplication.customFont.TextViewCustomFont;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

//    @BindView(R.id.imageButton)
//    ImageButton imageButton;
//    @BindView(R.id.textViewCustomFont)
//    TextViewCustomFont textViewCustomFont;
//    @BindView(R.id.toolbar)
//    Toolbar toolbar;
    @BindView(R.id.Home_Fragment_TabLayout_tabs)
    TabLayout HomeFragmentTabLayoutTabs;
    @BindView(R.id.Home_Fragment_ViewPager)
    ViewPager HomeFragmentViewPager;

    // var
    private int[] tabIcons = {
            R.drawable.quran,
            R.drawable.mention
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setupClientViewPager(HomeFragmentViewPager);
        HomeFragmentTabLayoutTabs.setupWithViewPager(HomeFragmentViewPager);
        setupTabIcons();
    }

    /* Add tab Icons */
    private void setupTabIcons() {
        HomeFragmentTabLayoutTabs.getTabAt(0).setIcon(tabIcons[0]);
        HomeFragmentTabLayoutTabs.getTabAt(0).setIcon(tabIcons[1]);
    }

    /* Add Fragments to Tabs */
    private void setupClientViewPager(ViewPager viewPager) {
        ViewPagerTapsAdapter adapter = new ViewPagerTapsAdapter(getSupportFragmentManager());
        adapter.addFragment(new ReadingFragment(), "");
        adapter.addFragment(new SebhaFragment(), "");

        viewPager.setAdapter(adapter);
    }

}
