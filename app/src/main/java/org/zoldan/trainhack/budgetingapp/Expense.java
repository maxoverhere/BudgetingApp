package org.zoldan.trainhack.budgetingapp;
///
public class Expense {

    private int id;
    private String category;
    private String details;
    private double cost;
    private String date;

    public Expense(int id, String category, String details, double cost, String date){
        this.id = id;
        this.category = category;
        this.details = details;
        this.cost = cost;
        this.date = date;
    }

    public void setId(int id) {this.id = id;}
    public void setCategory(String category) {this.category = category;}
    public void setDetails(String details) {this.details = details;}
    public void setCost(double cost) {this.cost = cost;}
    public void setDate(String date) {this.date = date;}

    public int getId() {return id;}
    public String getCategory() {return category;}
    public String getDetails() {return details;}
    public double getCost() {return cost;}
    public String getDate() {return date;}
}
