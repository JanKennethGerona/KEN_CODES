package Exer2_Gerona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.util.Vector;

public class JavaApplication15 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/finals";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    
    private JFrame userFrame;
    private CardLayout cardLayout;
    private JPanel contentPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JavaApplication15().createLoginFrame());
    }

    private void createLoginFrame() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(800, 480);
        loginFrame.setLayout(new GridBagLayout());
        loginFrame.setLocationRelativeTo(null);
        loginFrame.getContentPane().setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JTextField emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(new Color(0, 123, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setBackground(new Color(40, 167, 69));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);

        loginButton.addActionListener(e -> loginUser(emailField.getText(), new String(passwordField.getPassword()), loginFrame));
        registerButton.addActionListener(e -> openRegistrationFrame());

        gbc.gridx = 0;
        gbc.gridy = 0;
        loginFrame.add(emailLabel, gbc);

        gbc.gridx = 1;
        loginFrame.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        loginFrame.add(passwordLabel, gbc);

        gbc.gridx = 1;
        loginFrame.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        loginFrame.add(loginButton, gbc);

        gbc.gridx = 1;
        loginFrame.add(registerButton, gbc);

        loginFrame.setVisible(true);
    }

    private void openRegistrationFrame() {
    JFrame registrationFrame = new JFrame("Registration");
    registrationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    registrationFrame.setSize(400, 300);
    registrationFrame.setLocationRelativeTo(null);
    registrationFrame.setLayout(new GridBagLayout());
    registrationFrame.getContentPane().setBackground(new Color(240, 240, 240));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.anchor = GridBagConstraints.WEST;

    // Labels and text fields for registration
    JLabel firstNameLabel = new JLabel("First Name:");
    JLabel lastNameLabel = new JLabel("Last Name:");
    JLabel emailLabel = new JLabel("Email:");
    JLabel passwordLabel = new JLabel("Password:");

    firstNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
    lastNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
    emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
    passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));

    JTextField firstNameField = new JTextField(20);
    JTextField lastNameField = new JTextField(20);
    JTextField emailField = new JTextField(20);
    JPasswordField passwordField = new JPasswordField(20);

    firstNameField.setFont(new Font("Arial", Font.PLAIN, 14));
    lastNameField.setFont(new Font("Arial", Font.PLAIN, 14));
    emailField.setFont(new Font("Arial", Font.PLAIN, 14));
    passwordField.setFont(new Font("Arial", Font.PLAIN, 14));

    JButton registerButton = new JButton("Register");
    registerButton.setFont(new Font("Arial", Font.BOLD, 14));
    registerButton.setBackground(new Color(40, 167, 69));
    registerButton.setForeground(Color.WHITE);
    registerButton.setFocusPainted(false);

    registerButton.addActionListener(e -> registerUser(firstNameField.getText(), lastNameField.getText(), emailField.getText(), new String(passwordField.getPassword()), registrationFrame));

    // Add components to the frame
    gbc.gridx = 0;
    gbc.gridy = 0;
    registrationFrame.add(firstNameLabel, gbc);

    gbc.gridx = 1;
    registrationFrame.add(firstNameField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    registrationFrame.add(lastNameLabel, gbc);

    gbc.gridx = 1;
    registrationFrame.add(lastNameField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    registrationFrame.add(emailLabel, gbc);

    gbc.gridx = 1;
    registrationFrame.add(emailField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    registrationFrame.add(passwordLabel, gbc);

    gbc.gridx = 1;
    registrationFrame.add(passwordField, gbc);

    gbc.gridx = 1;
    gbc.gridy = 4;
    registrationFrame.add(registerButton, gbc);

    registrationFrame.setVisible(true);
}



private void registerUser(String firstName, String lastName, String email, String password, JFrame registrationFrame) {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        String query = "INSERT INTO users (firstname, lastname, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, email);
        pstmt.setString(4, password);  // Note: You should hash the password in a real system.

        int result = pstmt.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(registrationFrame, "Registration successful!");
            registrationFrame.dispose();  // Close registration frame
        } else {
            JOptionPane.showMessageDialog(registrationFrame, "Registration failed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(registrationFrame, "Database error.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}



    private void loginUser(String email, String password, JFrame loginFrame) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(loginFrame, "Login successful!");
                loginFrame.dispose();
                openUserDashboard();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid email or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(loginFrame, "Database error.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openUserDashboard() {
        userFrame = new JFrame("User Dashboard");
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setSize(2500, 950);
        userFrame.setLocationRelativeTo(null);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menu items
        JMenu menu = new JMenu("Manage");
        JMenuItem categoriesItem = new JMenuItem("Categories");
        JMenuItem suppliersItem = new JMenuItem("Suppliers");
        JMenuItem itemsItem = new JMenuItem("Items");
        JMenuItem transactionsItem = new JMenuItem("Transactions");

        categoriesItem.addActionListener(e -> showCrudPanel("Categories"));
        suppliersItem.addActionListener(e -> showCrudPanel("Suppliers"));
        itemsItem.addActionListener(e -> showCrudPanel("Items"));
        transactionsItem.addActionListener(e -> showCrudPanel("Transactions"));

        menu.add(categoriesItem);
        menu.add(suppliersItem);
        menu.add(itemsItem);
        menu.add(transactionsItem);
        menuBar.add(menu);
        userFrame.setJMenuBar(menuBar);

        // Set content panel with card layout for CRUD operations
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Add CRUD panels for each table
        contentPanel.add(createCrudPanel("Categories"), "Categories");
        contentPanel.add(createCrudPanel("Suppliers"), "Suppliers");
        contentPanel.add(createCrudPanel("Items"), "Items");
        contentPanel.add(createCrudPanel("Transactions"), "Transactions");

        userFrame.add(contentPanel);
        userFrame.setVisible(true);
    }

    private void showCrudPanel(String tableName) {
        cardLayout.show(contentPanel, tableName);
    }

    private JPanel createCrudPanel(String tableName) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create the table to display data from the database
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Create a panel for the CRUD controls (textfields, buttons)
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new FlowLayout());

        // Create fields based on table structure
        JTextField nameField = new JTextField(20);
        JTextField descriptionField = new JTextField(20);
        JTextField contactField = new JTextField(20);
        JTextField unitPriceField = new JTextField(10);
        JTextField quantityField = new JTextField(10);
        JTextField reorderLevelField = new JTextField(10);
        JTextField transactionDateField = new JTextField(12);
        JTextField transactionTypeField = new JTextField(10);
        JTextField notesField = new JTextField(20);
        JTextField categoryIdField = new JTextField(10);
        JTextField itemIdField = new JTextField(10);
        JTextField itemQuantityField = new JTextField(10);

        JButton createButton = new JButton("Create");
        JButton readButton = new JButton("Read");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        // Add text fields and buttons to the panel
        if (tableName.equals("Categories")) {
            controlsPanel.add(new JLabel("Name:"));
        controlsPanel.add(nameField);
        }
        if (tableName.equals("Suppliers")) {
            controlsPanel.add(new JLabel("Name:"));
        controlsPanel.add(nameField);
            controlsPanel.add(new JLabel("Contact Info:"));
            controlsPanel.add(contactField);
        }
        if (tableName.equals("Items")) {
            controlsPanel.add(new JLabel("Name:"));
        controlsPanel.add(nameField);
        controlsPanel.add(new JLabel("Category ID:"));  // Add Category ID field
    controlsPanel.add(categoryIdField);
    controlsPanel.add(new JLabel("Description:"));
    controlsPanel.add(descriptionField);
    controlsPanel.add(new JLabel("Unit Price:"));
    controlsPanel.add(unitPriceField);
    controlsPanel.add(new JLabel("Quantity On Hand:"));
    controlsPanel.add(quantityField);
    controlsPanel.add(new JLabel("Reorder Level:"));
    controlsPanel.add(reorderLevelField);
    
}
        if (tableName.equals("Transactions")) {
            controlsPanel.add(new JLabel("Item ID:"));
    controlsPanel.add(itemIdField);
    controlsPanel.add(new JLabel("Transaction Date& Time(YYYY-MM-DD) (HH:mm:ss):"));
    controlsPanel.add(transactionDateField);
    controlsPanel.add(new JLabel("Quantity:"));
    controlsPanel.add(itemQuantityField);
    controlsPanel.add(new JLabel("Transaction Type:"));
    controlsPanel.add(transactionTypeField);
    controlsPanel.add(new JLabel("Notes:"));
    controlsPanel.add(notesField);
    
}


        controlsPanel.add(createButton);
        controlsPanel.add(readButton);
        controlsPanel.add(updateButton);
        controlsPanel.add(deleteButton);

        panel.add(controlsPanel, BorderLayout.SOUTH);

        // Fetch and display the data for the selected table
        fetchAndDisplayData(table, tableName);

        // Button actions
        createButton.addActionListener(e -> {
            createRecord(tableName, nameField, descriptionField, contactField, unitPriceField, quantityField, reorderLevelField, transactionDateField, transactionTypeField, notesField, categoryIdField, itemIdField, itemQuantityField);
            fetchAndDisplayData(table, tableName); // Reload data after creation
        });

        updateButton.addActionListener(e -> {
            updateRecord(table, tableName, nameField, descriptionField, contactField, unitPriceField, quantityField, reorderLevelField, transactionDateField, transactionTypeField, notesField, categoryIdField, itemIdField, itemQuantityField);
            fetchAndDisplayData(table, tableName); // Reload data after update
        });

        deleteButton.addActionListener(e -> {
            deleteRecord(table, tableName);
            fetchAndDisplayData(table, tableName); // Reload data after deletion
        });

        readButton.addActionListener(e -> readRecord(table));

        return panel;
    }

    private void fetchAndDisplayData(JTable table, String tableName) {
        DefaultTableModel model = new DefaultTableModel();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM " + tableName;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Set table columns based on result set
            Vector<String> columns = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(metaData.getColumnName(i));
            }
            model.setColumnIdentifiers(columns);

            // Fill table data
            Vector<Vector<Object>> data = new Vector<>();
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }

            model.setDataVector(data, columns);
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createRecord(String tableName, JTextField nameField, JTextField descriptionField, JTextField contactField,
                              JTextField unitPriceField, JTextField quantityField, JTextField reorderLevelField, JTextField transactionDateField,
                              JTextField transactionTypeField, JTextField notesField, JTextField categoryIdField, JTextField itemIdField, JTextField itemQuantityField) {
        // Implement CREATE logic for each table here
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            if (tableName.equals("Categories")) {
                String query = "INSERT INTO Categories (category_name) VALUES (?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, nameField.getText());
                pstmt.executeUpdate();
            } else if (tableName.equals("Suppliers")) {
                String query = "INSERT INTO Suppliers (supplier_name, contact_info) VALUES (?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, nameField.getText());
                pstmt.setString(2, contactField.getText());
                pstmt.executeUpdate();
            } else if (tableName.equals("Items")) {
    String query = "INSERT INTO Items (item_name, description, unit_price, quantity_on_hand, reorder_level, category_id) VALUES (?, ?, ?, ?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(query);
    pstmt.setString(1, nameField.getText());
    pstmt.setString(2, descriptionField.getText());
    pstmt.setDouble(3, Double.parseDouble(unitPriceField.getText()));
    pstmt.setInt(4, Integer.parseInt(quantityField.getText()));
    pstmt.setInt(5, Integer.parseInt(reorderLevelField.getText()));
    pstmt.setInt(6, Integer.parseInt(categoryIdField.getText()));  // Include category_id
    pstmt.executeUpdate();
}
 else if (tableName.equals("Transactions")) {
    String query = "INSERT INTO Transactions (item_id, transaction_date, quantity, transaction_type, notes) VALUES (?, ?, ?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(query);
    pstmt.setInt(1, Integer.parseInt(itemIdField.getText()));  
    pstmt.setString(2, (transactionDateField.getText()));
    pstmt.setInt(3, Integer.parseInt(itemQuantityField.getText()));
    pstmt.setString(4, transactionTypeField.getText());
    pstmt.setString(5, notesField.getText());
    pstmt.executeUpdate();
}

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateRecord(JTable table, String tableName, JTextField nameField, JTextField descriptionField, JTextField contactField,
                              JTextField unitPriceField, JTextField quantityField, JTextField reorderLevelField, JTextField transactionDateField,
                              JTextField transactionTypeField, JTextField notesField, JTextField categoryIdField, JTextField itemIdField, JTextField itemQuantityField) {
        // Assuming that the user has selected a row to update
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                // Get current data
                int id = (int) table.getValueAt(selectedRow, 0); // Get the ID of the selected record
                if (tableName.equals("Categories")) {
                    String query = "UPDATE Categories SET category_name = ? WHERE category_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, nameField.getText());
                    pstmt.setInt(2, id);
                    pstmt.executeUpdate();
                } else if (tableName.equals("Suppliers")) {
                    String query = "UPDATE Suppliers SET supplier_name = ?, contact_info = ? WHERE supplier_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, nameField.getText());
                    pstmt.setString(2, contactField.getText());
                    pstmt.setInt(3, id);
                    pstmt.executeUpdate();
                } else if (tableName.equals("Items")) {
                    String query = "UPDATE Items SET item_name = ?, category_id = ?, description = ?, unit_price = ?, quantity_on_hand = ?, reorder_level = ? WHERE item_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, nameField.getText());
                    pstmt.setInt(2, Integer.parseInt(categoryIdField.getText()));
                    pstmt.setString(3, descriptionField.getText());
                    pstmt.setDouble(4, Double.parseDouble(unitPriceField.getText()));
                    pstmt.setInt(5, Integer.parseInt(quantityField.getText()));
                    pstmt.setInt(6, Integer.parseInt(reorderLevelField.getText()));
                    pstmt.setInt(7, id);
                    pstmt.executeUpdate();
                } else if (tableName.equals("Transactions")) {
                    
                    String query = "UPDATE Transactions SET item_id = ?, transaction_date = ?, quantity = ?, transaction_type = ?, notes = ? WHERE transaction_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, Integer.parseInt(itemIdField.getText()));  
                    pstmt.setString(2, (transactionDateField.getText()));
                    pstmt.setInt(3, Integer.parseInt(itemQuantityField.getText()));
                    pstmt.setString(4, transactionTypeField.getText());
                    pstmt.setString(5, notesField.getText());
                    pstmt.setInt(6, id);
                    pstmt.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteRecord(JTable table, String tableName) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) table.getValueAt(selectedRow, 0); // Get the ID of the selected record
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String query = "";
                if (tableName.equals("Categories")) {
                    query = "DELETE FROM Categories WHERE category_id = ?";
                } else if (tableName.equals("Suppliers")) {
                    query = "DELETE FROM Suppliers WHERE supplier_id = ?";
                } else if (tableName.equals("Items")) {
                    query = "DELETE FROM Items WHERE item_id = ?";
                } else if (tableName.equals("Transactions")) {
                    query = "DELETE FROM Transactions WHERE transaction_id = ?";
                }
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void readRecord(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            StringBuilder details = new StringBuilder();
            for (int i = 0; i < table.getColumnCount(); i++) {
                details.append(table.getColumnName(i)).append(": ").append(table.getValueAt(selectedRow, i)).append("\n");
            }
            JOptionPane.showMessageDialog(userFrame, details.toString(), "Record Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
