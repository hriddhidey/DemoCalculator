package com.example.student.calculator;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class TabbedActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        /*
        this.getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
        getActionBar().setDisplayUseLogoEnabled(true);
        getActionBar().setDisplayShowCustomEnabled(true);
        //getActionBar().setCustomView(R.layout.actionbar_layout);
        //getActionBar().setCustomView(R.layout.actionbar_layout);
        */

        TabHost mTabHost = getTabHost();
        mTabHost.addTab(mTabHost.newTabSpec("first").setIndicator("Calculator").setContent(new Intent(this  ,MainActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("second").setIndicator("Second").setContent(new Intent(this , SecondActivity.class )));
        mTabHost.setCurrentTab(0);
    }


}
