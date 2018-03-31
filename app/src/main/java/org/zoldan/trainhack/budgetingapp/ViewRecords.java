package org.zoldan.trainhack.budgetingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ViewRecords extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);

        DBHandler db = new DBHandler(this);
        TextView textView = findViewById(R.id.textView);
        List<Expense> expenses = db.getAllExpenses();
        textView.setText("Data in database: \n");

        for (Expense expense : expenses){
            textView.append("Category: " + expense.getCategory() + ", Details: " + expense.getDetails()
            + ", amount: " + expense.getCost() + ", date: " + expense.getDate() + "\n");
        }
    }
}
