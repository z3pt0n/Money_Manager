package dao;

import model.Expense;
import java.util.List;

public interface ExpenseDAO {
    void addExpense(Expense expense);
    void deleteExpense(int id);
    List<Expense> getAllExpenses();
}
