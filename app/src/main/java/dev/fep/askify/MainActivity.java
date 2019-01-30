package dev.fep.askify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    public int selectedtab = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        setBottomTabs();
        selectFirstTab();

        getSupportActionBar().hide();
    }

    private void setBottomTabs() {
        if (tabLayout != null) {

            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.replyb).setText("Fragment A"), true);
            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.question).setText("Fragment B"), false);
            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.btc).setText("Fragment C"), false);
            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.settings).setText("Fragment D"), false);

            //tabLayout.setTabTextColors(colorStateList);

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    //    Log.e("xxx", tab.getPosition() + "");
                    switch (tab.getPosition()) {/**/
                        case 0:
                            invalidateOptionsMenu();
                            selectedtab=0;
                            Log.e("goon",selectedtab+"");
                            //             toolbar.setTitle(R.string.app_name);
                            FragmentA favoriteFragmenta = new FragmentA();
                            //   favoriteFragmenta.setTabLayout(tabLayout);
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new FragmentA(), "A FRAGMENT").addToBackStack("").commit();
                            break;
                        case 1:
                            selectedtab=1;
                            invalidateOptionsMenu();
                            Log.e("goon",selectedtab+"");
                            //    toolbar.setTitle(R.string.app_name);
                            FragmentB favoriteFragmentb = new FragmentB();
                            favoriteFragmentb.setTabLayout(tabLayout);
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new FragmentB(), "B FRAGMENT").addToBackStack("").commit();
                            break;
                        case 2:
                            invalidateOptionsMenu();
                            selectedtab=2;
                            Log.e("goon",selectedtab+"");
                            //        toolbar.setTitle(R.string.app_name);
                            FragmentC favoriteFragmentc = new FragmentC();
                         //   favoriteFragmentc.setTabLayout(tabLayout);
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new FragmentC(), "C FRAGMENT").addToBackStack("").commit();
                            break;
                        case 3:
                                selectedtab=3;
                                invalidateOptionsMenu();
                                Log.e("goon",selectedtab+"");
                                //        toolbar.setTitle(R.string.app_name);
                            FragmentD favoriteFragmentd = new FragmentD();
                             //   favoriteFragmentd.setTabLayout(tabLayout);
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                        new FragmentD(), "D FRAGMENT").addToBackStack("").commit();
                            break;


                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
    }

    public void selectFirstTab() {
        TabLayout.Tab homeTab = tabLayout.getTabAt(1);
        homeTab.select();
        homeTab = tabLayout.getTabAt(0);
        homeTab.select();
    }
}
