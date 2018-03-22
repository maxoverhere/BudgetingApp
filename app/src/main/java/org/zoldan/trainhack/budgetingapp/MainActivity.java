package org.zoldan.trainhack.budgetingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchToAddRecord(View view){
        startActivity(new Intent(this, AddRecord.class));
    }

    public void switchToViewRecords(View view){
        startActivity(new Intent(this, ViewRecords.class));
    }
}
