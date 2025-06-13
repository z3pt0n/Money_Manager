package ui;

import controller.ExpenseController;
import model.Expense;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ExpenseManagerGUI {
    private ExpenseController controller;
    private JFrame frame;
    private JTable expenseTable;
    private DefaultTableModel tableModel;

    public ExpenseManagerGUI(ExpenseController controller) {
        this.controller = controller;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Expense Manager (MongoDB + MVC)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Title", "Amount", "Date", "Category"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // prevent all edits for now
            }
        };
        expenseTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(expenseTable);

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton refreshButton = new JButton("Refresh");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        addButton.addActionListener(e -> showAddDialog());
        deleteButton.addActionListener(e -> deleteSelectedExpense());
        refreshButton.addActionListener(e -> refreshTable());

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        refreshTable();
        frame.setVisible(true);
    }

    private void showAddDialog() {
        JTextField titleField = new JTextField();
        JTextField amountField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField categoryField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        panel.add(dateField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add Expense",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String title = titleField.getText().trim();
                double amount = Double.parseDouble(amountField.getText().trim());
                String date = dateField.getText().trim();
                String category = categoryField.getText().trim();

                controller.addExpense(title, amount, date, category);
                refreshTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Invalid input: " + e.getMessage());
            }
        }
    }

    private void deleteSelectedExpense() {
        int selectedRow = expenseTable.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            controller.deleteExpense(id);
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(frame, "No expense selected!");
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Expense e : controller.getAllExpenses()) {
            tableModel.addRow(new Object[]{e.getId(), e.getTitle(), e.getAmount(), e.getDate(), e.getCategory()});
        }
    }

}
