package com.example.hassan.lp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyDiscovere.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyDiscovere#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyDiscovere extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MyDiscovere() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyDiscovere.
     */
    // TODO: Rename and change types and number of parameters
    public static MyDiscovere newInstance(String param1, String param2) {
        MyDiscovere fragment = new MyDiscovere();
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

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    Toolbar toolbar; //TOOLBAR K LYE                    1
    View v;  //access krny k lye view lty h ismy
    RecyclerView programmingList,programmingListsecond;
    FeaturedModelClass featuredModelClass;
    ArrayList<FeaturedModelClass> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_my_discovere, container, false);
        toolbar = v.<Toolbar>findViewById(R.id.toobarMyCource); //toolbar


        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("LECTUREPAD");
        //  ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("sub title here");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //recycler view ko attach krny klye
        programmingList = v.<RecyclerView>findViewById(R.id.programmingListinDiscover);
        programmingListsecond=v.findViewById(R.id.programmingListinDiscoverSecond);

        String[] arraytxt = {"How to become a Scientist?", "Become a Digital Marketer?", "Become a Digital Marketer?"};
        String[] arraybtn = {"5 Cources", "11 Cources", "11 Cources"};
        int[] arrayimg = {R.drawable.datascientist, R.drawable.digitalmarkeet, R.drawable.digitalmarkeet};
        arrayList = new ArrayList<>();

        for (int i = 0; i < arraybtn.length; i++) {
            featuredModelClass = new FeaturedModelClass(arraytxt[i], arraybtn[i], arrayimg[i]);
            arrayList.add(featuredModelClass);
        }

        programmingList.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        programmingList.setAdapter(new programmingAdapterForDiscover(arrayList, getActivity()));

        programmingListsecond.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        programmingListsecond.setAdapter(new programmingAdapterForDiscover(arrayList, getActivity()));


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            //
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    //ye toolbar k lye bnanya ha  https://www.youtube.com/watch?v=InF5tU_hecI&t=65s

    //FRAGMENT K ANDER ISKO ASY LGATY H menu r fragment ko attach krny  lye
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.mycourcesmenu, menu); //FRAMGMENT M ASY KRNA H
        super.onCreateOptionsMenu(menu, inflater);

    }   //4

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    //toolbar ma back home pr jany k lye        5 end for toolbar
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
