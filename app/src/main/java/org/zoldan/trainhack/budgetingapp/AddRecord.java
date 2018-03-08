package org.zoldan.trainhack.budgetingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddRecord extends AppCompatActivity {
//tvdccdvfrgtgr
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

//        Expense expense = new Expense();
//
//        expense.setId(0);
//        expense.setTypeId( Integer.parseInt(type.getText().toString()));
//        expense.setUserId( Integer.parseInt(user.getText().toString()));
//        expense.setName(name.getText().toString());
//        expense.setCost( Double.parseDouble(amount.getText().toString()));
//        expense.setDate( date.getText().toString());

        Toast.makeText(getApplicationContext(), "Saved to database... i thing? \n there are " + db.getExpensesCount() + " in database" , Toast.LENGTH_LONG).show();
    }
}
