package servlet;

import model.Expense;
import service.ExpenseService;
import dao.MongoExpenseDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import io.github.cdimascio.dotenv.Dotenv;

//@WebServlet("/expenses")
public class ExpenseServlet extends HttpServlet {
    private ExpenseService service;

    @Override
    public void init() {
        final Dotenv dotenv = Dotenv.load();
        final String uri = dotenv.get("MONGO_URI");
        MongoExpenseDAO dao = new MongoExpenseDAO(uri);
        service = new ExpenseService(dao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Expense> expenses = service.getAllExpenses();
        request.setAttribute("expenses", expenses);
        request.getRequestDispatcher("/jsp/viewExpenses.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String amountStr = request.getParameter("amount");
        String date = request.getParameter("date");
        String category = request.getParameter("category");

        try {
            double amount = Double.parseDouble(amountStr);
            service.addExpense(title, amount, date, category);
        } catch (Exception e) {
            request.setAttribute("error", "Invalid input: " + e.getMessage());
        }

        response.sendRedirect("expenses");  // Refresh page
    }
}
