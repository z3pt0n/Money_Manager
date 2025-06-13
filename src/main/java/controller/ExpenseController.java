package controller;

import model.Expense;
import service.ExpenseService;

import java.util.List;

public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public void addExpense(String title, double amount, String date, String category) {
        expenseService.addExpense(title, amount, date, category);
    }

    public void deleteExpense(int id) {
        expenseService.deleteExpense(id);
    }

    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }
}
