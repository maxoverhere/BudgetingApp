package org.zoldan.trainhack.budgetingapp;

public class Expense {

    private int id;
    private int typeId;
    private int userId;
    private String name;
    private double cost;
    private String date;

    public Expense(int id ,int typeId ,int userId ,String name ,double cost ,String date){
        this.id = id;
        this.typeId = typeId;
        this.userId = userId;
        this.name = name;
        this.cost = cost;
        this.date = date;
    }

    public void setId(int id) {this.id = id;}
    public void setTypeId(int typeId) {this.typeId = typeId;}
    public void setUserId(int userId) {this.userId = userId;}
    public void setName(String name) {this.name = name;}
    public void setCost(double cost) {this.cost = cost;}
    public void setDate(String date) {this.date = date;}

    public int getId() {return id;}
    public int getTypeId() {return typeId;}
    public int getUserId() {return userId;}
    public String getName() {return name;}
    public double getCost() {return cost;}
    public String getDate() {return date;}
}
