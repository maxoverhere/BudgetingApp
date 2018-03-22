package org.zoldan.trainhack.budgetingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);


    }

    public void addRecord(View view){
        DBHandler db = new DBHandler(this);
        TextView type = findViewById(R.id.editText2);
        TextView user = findViewById(R.id.editText4);
        TextView name = findViewById(R.id.editText);
        TextView amount = findViewById(R.id.editText3);
        TextView date = findViewById(R.id.editText5);

        Expense expense = new Expense(0, Integer.parseInt(type.getText().toString()), Integer.parseInt(user.getText().toString()),
                name.getText().toString(), Double.parseDouble(amount.getText().toString()), date.getText().toString());
        db.addExpense(expense);

        Toast.makeText(getApplicationContext(), "Saved to database. There are " + db.getExpensesCount() + " items in database" , Toast.LENGTH_LONG).show();
    }
}
