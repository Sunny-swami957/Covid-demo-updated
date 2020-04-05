package com.android4dev.covid_demo;

import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView)
                findViewById(R.id.navigation_view);
        mainActivity=this;
        //Default Fragment
        HomeFragment homefragment = new HomeFragment(this);
        android.support.v4.app.FragmentTransaction homeFragmentTransaction
                = getSupportFragmentManager().beginTransaction();
        homeFragmentTransaction.replace(R.id.frame,homefragment);
        homeFragmentTransaction.commit();

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){

                    case R.id.home:
                        HomeFragment homefragment = new HomeFragment(mainActivity);
                        android.support.v4.app.FragmentTransaction homeFragmentTransaction
                                = getSupportFragmentManager().beginTransaction();
                        homeFragmentTransaction.replace(R.id.frame,homefragment);
                        homeFragmentTransaction.commit();
                        return true;

                    case R.id.a1:

                        TrackerFragment a1fragment = new TrackerFragment();
                        android.support.v4.app.FragmentTransaction a1FragmentTransaction
                                = getSupportFragmentManager().beginTransaction();
                        a1FragmentTransaction.replace(R.id.frame,a1fragment);
                        a1FragmentTransaction.commit();

                        return true;

                    case R.id.a2:
                        TrendsFragment a2fragment = new TrendsFragment();
                        android.support.v4.app.FragmentTransaction a2FragmentTransaction
                                = getSupportFragmentManager().beginTransaction();
                        a2FragmentTransaction.replace(R.id.frame,a2fragment);
                        a2FragmentTransaction.commit();
                        return true;


                    default:
                        Toast.makeText(getApplicationContext(),"Somethings Wrong",Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle
                = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void callNumber(final String s)
    {
        runOnUiThread(new Thread(new Runnable() {
            @Override
            public void run()
            {
                    try{
                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse(s));
                        startActivity(callIntent);
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }

            }
        }));


    }
    public synchronized void loadfragment(View v)
    {
        switch(v.getId())
        {
            case R.id.self_ass:
                SelfAssessmentFragment homefragment = new SelfAssessmentFragment(mainActivity);
                android.support.v4.app.FragmentTransaction homeFragmentTransaction
                        = getSupportFragmentManager().beginTransaction();
                homeFragmentTransaction.replace(R.id.frame,homefragment);
                homeFragmentTransaction.commit();
                break;
            case R.id.hrlp_line:
                HelpLinesFragment homefragment1 = new HelpLinesFragment(mainActivity);
                android.support.v4.app.FragmentTransaction homeFragmentTransaction1
                        = getSupportFragmentManager().beginTransaction();
                homeFragmentTransaction1.replace(R.id.frame,homefragment1);
                homeFragmentTransaction1.commit();
                break;
            case R.id.test_center:
                TestCenterFragment homefragment2 = new TestCenterFragment();
                android.support.v4.app.FragmentTransaction homeFragmentTransaction2
                        = getSupportFragmentManager().beginTransaction();
                homeFragmentTransaction2.replace(R.id.frame,homefragment2);
                homeFragmentTransaction2.commit();
                break;
            default:
                break;
        }
    }
}
