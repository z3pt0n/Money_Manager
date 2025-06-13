import controller.ExpenseController;
import dao.ExpenseDAO;
import dao.MongoExpenseDAO;
import service.ExpenseService;
import ui.ExpenseManagerGUI;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {
        // Load environment variables
        Dotenv dotenv = Dotenv.load();

        String uri = dotenv.get("MONGO_URI");
        if (uri == null || uri.isEmpty()) {
            System.err.println("MONGO_URI not found in environment variables");
            return;
        }

        ExpenseDAO dao = new MongoExpenseDAO(uri);
        ExpenseService service = new ExpenseService(dao);
        ExpenseController controller = new ExpenseController(service);

        javax.swing.SwingUtilities.invokeLater(() -> new ExpenseManagerGUI(controller));
    }
}
