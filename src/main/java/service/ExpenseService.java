package service;

import dao.ExpenseDAO;
import model.Expense;

import java.util.List;

public class ExpenseService {
    private final ExpenseDAO expenseDAO;

    public ExpenseService(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    public void addExpense(String title, double amount, String date, String category) {
        Expense expense = new Expense();
        expense.setTitle(title);
        expense.setAmount(amount);
        expense.setDate(date);
        expense.setCategory(category);
        expenseDAO.addExpense(expense);
    }

    public void deleteExpense(int id) {
        expenseDAO.deleteExpense(id);
    }

    public List<Expense> getAllExpenses() {
        return expenseDAO.getAllExpenses();
    }
}
