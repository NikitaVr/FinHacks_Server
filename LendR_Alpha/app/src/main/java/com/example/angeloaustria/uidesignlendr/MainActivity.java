package com.example.angeloaustria.uidesignlendr;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAccount, fabLoan, fabBorrow;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAccount = (FloatingActionButton) findViewById(R.id.fabAccount);
        fabLoan = (FloatingActionButton) findViewById(R.id.fabLoan);
        fabBorrow = (FloatingActionButton) findViewById(R.id.fabBorrow);

        fabAccount.show();
        fabBorrow.hide();
        fabLoan.hide();

        fabBorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Do you want to borrow from a lender?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and return it
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        fabLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Do you want to lend someone money?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and return it
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setCurrentBalance();


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        fabAccount.show();
                        fabBorrow.hide();
                        fabLoan.hide();
                        break;

                    case 1:
                        fabAccount.hide();
                        fabBorrow.hide();
                        fabLoan.show();
                        break;

                    case 2:
                        fabAccount.hide();
                        fabBorrow.show();
                        fabLoan.hide();
                        break;

                    default:
                        fabAccount.hide();
                        fabBorrow.hide();
                        fabLoan.hide();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setCurrentBalance() {
        // set the current balance in the toolbar
        balance = (TextView) findViewById(R.id.balance);
        balance.setText("$9999.99");
        TextView balanceLabel = (TextView) findViewById(R.id.balanceLabel);
        balanceLabel.setText("Current Balance");
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AccountFragment(), "Account");
        adapter.addFragment(new LoanFragment(), "Lend");
        adapter.addFragment(new BorrowFragment(), "Borrow");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}