package com.example.antoniobrito.td_challenge_project.augmentedimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;

public class bankaccountOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankaccount_options);
    }

    public void selectOption(View view) {
        int btn = view.getId();
        Intent intent =null;
        switch (view.getId())
        {
            case R.id.allinclusive:
                openWeb("https://www.tdcanadatrust.com/products-services/banking/accounts/byb.jsp?acc=CORE_ALL-INCLUSIVE");
                break;
            case R.id.unlimited:
                openWeb("https://www.tdcanadatrust.com/products-services/banking/accounts/byb.jsp?acc=CORE_UNLIMITED");
                break;
            case R.id.everydaysav:
                openWeb("https://www.tdcanadatrust.com/products-services/banking/accounts/byb.jsp?acc=CORE_EVERYDAY_CHEQ");
                break;
            case R.id.minimum:
                openWeb("https://www.tdcanadatrust.com/products-services/banking/accounts/byb.jsp?acc=CORE_MINIMUM");
                break;
            case R.id.studentsav:
                openWeb("https://www.td.com/ca/en/personal-banking/products/bank-accounts/chequing-accounts/student-chequing-account/");
                break;
        }
        // startActivity(intent);
    }

    private void openWeb(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
        startActivity(intent);
    }
}
