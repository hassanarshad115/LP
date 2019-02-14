package com.example.hassan.lp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class past_resourcesActivity extends Fragment {
    public past_resourcesActivity() {
    }

    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.past_resources,container,false);
        Log.d("hassan", " inPastCource");

        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d("hassan", "MethodCall: "+isVisibleToUser);
        if(isVisibleToUser){


        Log.d("hassan","in visible paste ka mthod");
        }else{
            Log.d("hassan", "setUserVisibleHint: past ka method else ma");
        }
    }

}
