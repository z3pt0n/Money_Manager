package servlet;

import dao.MongoExpenseDAO;
import io.github.cdimascio.dotenv.Dotenv;
import model.Expense;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import io.github.cdimascio.dotenv.Dotenv;

@WebServlet("/add-expense")
public class AddExpenseServlet extends HttpServlet {

    private MongoExpenseDAO dao;

    @Override
    public void init() {
        final Dotenv dotenv = Dotenv.load();

        dao = new MongoExpenseDAO(dotenv.get("MONGO_URI"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        double amount = Double.parseDouble(req.getParameter("amount"));
        String date = req.getParameter("date");
        String category = req.getParameter("category");

        Expense expense = new Expense(title, amount, date, category);
        dao.addExpense(expense);

        resp.sendRedirect("list-expenses"); // redirect to listing page
    }
}
