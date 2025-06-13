package model;

import org.bson.Document;


public class Expense {
    private int id;           // MongoDB ObjectId as String
    private String title;
    private double amount;
    private String date;
    private String category;

    public Expense() {}

    public Expense(int id, String title, double amount, String date, String category) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    // toString() for displaying expense info
    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Amount: ₹" + amount + ", Date: " + date + ", Category: " + category;
    }

    // Convert model.Expense object to MongoDB Document
    public Document toDocument() {
        return new Document("id", id)
                .append("title", title)
                .append("amount", amount)
                .append("date", date)
                .append("category", category);
    }

    // Convert MongoDB Document to model.Expense object
    public static Expense fromDocument(Document doc) {
        int id = doc.getInteger("id");
        String title = doc.getString("title");
        double amount = doc.getDouble("amount");
        String date = doc.getString("date");
        String category = doc.getString("category");

        return new Expense(id, title, amount, date, category);
    }
}
