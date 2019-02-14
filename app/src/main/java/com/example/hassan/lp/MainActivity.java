package com.example.hassan.lp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hassan.lp.AddYourIdFolder.AddYourIdActivity;
import com.example.hassan.lp.ConfirmYourDetailFolder.ConfirmYourDetialActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button sinandsupbtn, dashboardbtn, addyouridbtn, confirmyourdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btn ko asy b handle kr skty ha
        sinandsupbtn = this.<Button>findViewById(R.id.signUpandSignInbtn);
        sinandsupbtn.setOnClickListener(this);
        //add your id btn
        addyouridbtn = findViewById(R.id.addyouridBtn);
        addyouridbtn.setOnClickListener(this);


        //btn ko asy b handle kr stky hainDashboardbtn
  /*      dashboardbtn= this.<Button>findViewById(R.id.dashboardbtndb);
        dashboardbtn.setOnClickListener(this);
*/
        Button dmy = findViewById(R.id.btndb);
        dmy.setOnClickListener(this);
        //confirm your detail
        confirmyourdetail = findViewById(R.id.confirmyourdetailBtn);
        confirmyourdetail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.signUpandSignInbtn) {
            startActivity(new Intent(MainActivity.this, SigninandSignupActivity.class));
            Toast.makeText(this, "SignInandSignOut", Toast.LENGTH_SHORT).show();
        }


        if (v.getId() == R.id.btndb) {
            Toast.makeText(this, "dymmy", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, DashboardActivity.class));
        }
        if (v.getId() == R.id.addyouridBtn) {
            startActivity(new Intent(this, AddYourIdActivity.class));
        }
        if (v.getId() == R.id.confirmyourdetailBtn) {
            startActivity(new Intent(this, ConfirmYourDetialActivity.class));
        }
    }
}
