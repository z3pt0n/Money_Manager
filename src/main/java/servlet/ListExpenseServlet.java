package servlet;

import dao.MongoExpenseDAO;
import model.Expense;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import io.github.cdimascio.dotenv.Dotenv;


@WebServlet("/list-expenses")
public class ListExpenseServlet extends HttpServlet {

    private MongoExpenseDAO dao;

    @Override
    public void init() {
        final Dotenv dotenv = Dotenv.load();
        dao = new MongoExpenseDAO(dotenv.get("MONGO_URI"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Expense> expenses = dao.getAllExpenses();
        req.setAttribute("expenses", expenses);
        req.getRequestDispatcher("jsp/listExpenses.jsp").forward(req, resp);
    }
}
