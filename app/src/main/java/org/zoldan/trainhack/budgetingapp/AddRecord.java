package org.zoldan.trainhack.budgetingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ArrayAdapter;


public class AddRecord extends AppCompatActivity {

    private Spinner category = (Spinner) findViewById(R.id.category);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
    }

    public void addRecord(View view){
        DBHandler db = new DBHandler(this);

        String[] items = new String[]{"Food", "Transport", "Socialising", "Course Material", "Clothes"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        category.setAdapter(adapter);

        TextView details = findViewById(R.id.details);
        TextView amount = findViewById(R.id.amountSpent);
        TextView date = findViewById(R.id.date);

        Expense expense = new Expense(0,
                /* Category*/ category.getSelectedItem().toString(),
                /* Details */ details.getText().toString(),
                /* Amount */ Double.parseDouble(amount.getText().toString()),
                /* Date */ date.getText().toString()
        );

        db.addExpense(expense);

        Toast.makeText(getApplicationContext(), "Saved to database. There are " + db.getExpensesCount() + " items in database" , Toast.LENGTH_LONG).show();
    }
}
