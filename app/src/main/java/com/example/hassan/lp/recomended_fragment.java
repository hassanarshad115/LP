package com.example.hassan.lp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link recomended_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link recomended_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class recomended_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public recomended_fragment() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d("hassan", "MethodCall: recommended remomended ma"+isVisibleToUser);
        if(isVisibleToUser){

            Log.d("hassan","in visible inRecomended");
        }else{
            Log.d("hassan", "setUserVisibleHint: inElse recommended ");
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment recomended_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static recomended_fragment newInstance(String param1, String param2) {
        recomended_fragment fragment = new recomended_fragment();
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
Toolbar toolbar;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_recomended_fragment, container, false);
            toolbar= v.<Toolbar>findViewById(R.id.toobarRecommended);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("LECTUREPAD");
        //  ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("sub title here");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        return v;
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
          //kch na ay
          //  Toast.makeText(getActivity(), "recomended", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
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
