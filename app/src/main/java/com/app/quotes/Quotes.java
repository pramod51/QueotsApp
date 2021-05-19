package com.app.quotes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.app.quotes.Fragments.PhotoFragment;
import com.app.quotes.Fragments.TextFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Quotes extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    String[] tabsTitles;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quotes);
        initViewPager();
    }

    private void initViewPager() {
        /*toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }*/

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getIntent().getStringExtra("name"));
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        mTitle.setTextColor(getResources().getColor(R.color.white));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);

        Bundle bundle=new Bundle();
        bundle.putString("key",getIntent().getStringExtra("key"));
        TextFragment textFragment=new TextFragment();
        textFragment.setArguments(bundle);
        PhotoFragment photoFragment=new PhotoFragment();
        photoFragment.setArguments(bundle);
        List<Fragment> simpleTabList = new ArrayList<>();
        simpleTabList.add(textFragment);
        simpleTabList.add(photoFragment);
        tabsTitles = new String[]{"Text", "Photos"};
        viewPager.setAdapter(new TabsSetup(simpleTabList, getSupportFragmentManager(), tabsTitles));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onSupportNavigateUp() {
        supportFinishAfterTransition();
        return true;
    }



}
