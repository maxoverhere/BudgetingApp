package org.zoldan.trainhack.budgetingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_NAME = "budgeting";

    private static final String TABLE_EXPENSES = "expenses";

    private static final String KEY_ID = "id";
    private static final String KEY_TYPE_ID = "type_id";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_COST = "cost";
    private static final String KEY_DATE = "date";
    
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_EXPENSES + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TYPE_ID + " INTEGER," + KEY_USER_ID + " INTEGER," + KEY_NAME + " TEXT," + KEY_COST + " DOUBLE," +
                KEY_DATE + " STRING" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSES);
        onCreate(db);
    }

    public void addExpense(Expense expense) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TYPE_ID, expense.getTypeId());
        values.put(KEY_USER_ID, expense.getUserId());
        values.put(KEY_NAME, expense.getName());
        values.put(KEY_COST, expense.getCost());
        values.put(KEY_DATE, expense.getDate());

        db.insert(TABLE_EXPENSES, null, values);
        db.close(); // Closing database connection
    }
//
    public Expense getExpense(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_EXPENSES, new String[]{KEY_ID, KEY_TYPE_ID, KEY_USER_ID,
                        KEY_NAME, KEY_COST, KEY_DATE}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Expense contact = new Expense(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)),Integer.parseInt(cursor.getString(2)),
                cursor.getString(3), Double.parseDouble(cursor.getString(4)), cursor.getString(5));

        return contact;
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenseList = new ArrayList<Expense>();
        String selectQuery = "SELECT * FROM " + TABLE_EXPENSES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Expense expense = new Expense(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)),
                        Integer.parseInt(cursor.getString(2)),cursor.getString(3),
                        Double.parseDouble(cursor.getString(4)), cursor.getString(5));

                expenseList.add(expense);
            } while (cursor.moveToNext());
        }

        return expenseList;
    }

    public int updateExpense(Expense expense) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TYPE_ID, expense.getTypeId());
        values.put(KEY_USER_ID, expense.getUserId());
        values.put(KEY_NAME, expense.getName());
        values.put(KEY_COST, expense.getCost());
        values.put(KEY_DATE, expense.getDate());

        return db.update(TABLE_EXPENSES, values, KEY_ID + " = ?",
                new String[]{String.valueOf(expense.getId())});
    }

    public void deleteExpense(Expense expense) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EXPENSES, KEY_ID + " = ?",
                new String[] { String.valueOf(expense.getId()) });
        db.close();
    }

    public int getExpensesCount() {
        String countQuery = "SELECT * FROM " + TABLE_EXPENSES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int i = cursor.getCount();
        cursor.close();

        return i;
    }

}
