package com.example.jdocter.can_i_borrow.MainFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.jdocter.can_i_borrow.HomeFragments.BorrowFragment;
import com.example.jdocter.can_i_borrow.HomeFragments.CalenderFragment;
import com.example.jdocter.can_i_borrow.HomeFragments.LendFragment;
import com.example.jdocter.can_i_borrow.HomeFragments.MessageFragment;
import com.example.jdocter.can_i_borrow.R;


public class HomeFragment extends Fragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.


    // define your fragments here
    final Fragment borrowFragment = new BorrowFragment();
    final Fragment calenderFragment = new CalenderFragment();
    final Fragment lendFragment = new LendFragment();
    final Fragment messageFragment = new MessageFragment();

    private BottomNavigationView bottomNavigationView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_home, parent, false);


    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        final FragmentManager homeFragmentManager = getActivity().getSupportFragmentManager();

        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.bottom_navigation);


        // handle navigation selection
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        FragmentTransaction fragmentTransaction = homeFragmentManager.beginTransaction();
                        switch (item.getItemId()) {
                            case R.id.borrow:
                                fragmentTransaction.replace(R.id.homeContainer, borrowFragment).commit();
                                return true;
                            case R.id.lend:
                                fragmentTransaction.replace(R.id.homeContainer, lendFragment).commit();
                                return true;
                            case R.id.calender:
                                fragmentTransaction.replace(R.id.homeContainer, calenderFragment).commit();
                                return true;
                            case R.id.message:
                                fragmentTransaction.replace(R.id.homeContainer, messageFragment).commit();
                                return true;
                        }
                        return true; // TODO this supposed to be here?
                    }
                }
        );

        bottomNavigationView.setSelectedItemId(R.id.home);
    }

}
