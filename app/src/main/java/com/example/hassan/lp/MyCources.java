package com.example.hassan.lp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyCources extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //TABLAYOUT K LYE
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public MyCources() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MyCources newInstance(String param1, String param2) {
        MyCources fragment = new MyCources();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//Make sure you have this line of code.  //TOOLBAR K LYE HE H

        setRetainInstance(true);
    }
    Toolbar toolbar; //TOOLBAR K LYE


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_cources,container, false);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpageridMyCourcwali);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) view.findViewById(R.id.tablyoutidMyCourcewali);
        tabs.setupWithViewPager(viewPager);

        toolbar = view.<Toolbar>findViewById(R.id.toobarMyCource); //toolbar
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("LECTUREPAD");
        //  ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("sub title here");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return view;

    }


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {


        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new content_resourcesActivity(), "CURRENT COURCES");
        adapter.addFragment(new past_resourcesActivity(), "PAST COURCES");
        adapter.addFragment(new future_resourcesAcitivty(), "FUTURE COURCES");
        viewPager.setAdapter(adapter);



    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
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



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    //ye toolbar k lye bnanya ha  https://www.youtube.com/watch?v=InF5tU_hecI&t=65s

    //FRAGMENT K ANDER ISKO ASY LGATY H menu r fragment ko attach krny  lye
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.mycourcesmenu, menu); //FRAMGMENT M ASY KRNA H
        super.onCreateOptionsMenu(menu, inflater);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            // kch b ni
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    //toolbar ma back home pr jany k lye
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            //end the activity https://www.youtube.com/watch?v=s3pheMAmaPI  ye link h iska
            getActivity().finish();
        }

        String msg = " ";
        switch (item.getItemId()) {
            case R.id.searchmyc:
                msg = "Search";
                break;
            case R.id.editmyc:
                msg = "Edit";
                break;
            case R.id.settingmyc:
                msg = "Setting";
                break;
            case R.id.logoutmyc:
                msg = "LogOut";
                break;
        }
        Toast.makeText(getActivity(), msg + " Checked", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
