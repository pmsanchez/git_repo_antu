package com.example.antoniobrito.td_challenge_project.augmentedimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class bankAccountAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_account);
    }

    public void selectBankAccount(View view) {
        int btn = view.getId();
        Intent intent =null;
        switch (view.getId())
        {
            case R.id.btnChequings  :
                intent = new Intent(this,bankaccountOptionsActivity.class);
                break;
        }

        startActivity(intent);
    }
}
