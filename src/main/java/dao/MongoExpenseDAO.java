package dao;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import model.Expense;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class MongoExpenseDAO implements ExpenseDAO {
    private final MongoCollection<Document> expenseCollection;

    public MongoExpenseDAO(String connectionString) {
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("expense_manager");
        expenseCollection = database.getCollection("expenses");
    }

    @Override
    public void addExpense(Expense expense) {
        Document doc = new Document()
                .append("title", expense.getTitle())
                .append("amount", expense.getAmount())
                .append("date", expense.getDate())
                .append("category", expense.getCategory());
        expenseCollection.insertOne(doc);
    }

    @Override
    public void deleteExpense(int id) {
        Bson filter = Filters.eq("id", id);
        expenseCollection.deleteOne(filter);
    }

    @Override
    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        FindIterable<Document> docs = expenseCollection.find();
        for (Document doc : docs) {
            Expense e = new Expense();
            e.setId(doc.containsKey("id") ? doc.getInteger("id") : 0); // optional
            e.setTitle(doc.getString("title"));
            e.setAmount(doc.getDouble("amount"));
            e.setDate(doc.getString("date"));
            e.setCategory(doc.getString("category"));
            expenses.add(e);
        }
        return expenses;
    }
}
