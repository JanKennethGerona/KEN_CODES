/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication15;
import javax.swing.*;
import java.awt.*;

import java.sql.*;


public class JavaApplication15 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/finals";
    private static final String DB_USER = "root";   
    private static final String DB_PASSWORD = "root"; 

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
        loginButton.setBackground(new Color(0, 123, 255));  // Blue background for button
        loginButton.setForeground(Color.WHITE);  // White text
        loginButton.setFocusPainted(false);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setBackground(new Color(40, 167, 69));  // Green background for button
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
        JFrame registerFrame = new JFrame("Register");
        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerFrame.setSize(800, 480);
        registerFrame.setLayout(new GridBagLayout());
        registerFrame.setLocationRelativeTo(null);

        
        registerFrame.getContentPane().setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.anchor = GridBagConstraints.WEST;

        
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JTextField firstNameField = new JTextField(20);
        firstNameField.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JTextField lastNameField = new JTextField(20);
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JTextField emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));

        // Register button with styling
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setBackground(new Color(40, 167, 69)); 
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);

       
        registerButton.addActionListener(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            registerUser(firstName, lastName, email, password, registerFrame);
        });

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        registerFrame.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        registerFrame.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        registerFrame.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        registerFrame.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        registerFrame.add(emailLabel, gbc);

        gbc.gridx = 1;
        registerFrame.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        registerFrame.add(passwordLabel, gbc);

        gbc.gridx = 1;
        registerFrame.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        registerFrame.add(new JLabel());

        gbc.gridx = 1;
        registerFrame.add(registerButton, gbc);

        registerFrame.setVisible(true);
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
                openUserFrame();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid email or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(loginFrame, "Database error.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registerUser(String firstName, String lastName, String email, String password, JFrame registerFrame) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO users (firstname, lastname, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setString(4, password);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(registerFrame, "Registration successful!");
            registerFrame.dispose();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(registerFrame, "Email already exists or database error.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openUserFrame() {
        JFrame userFrame = new JFrame("User Dashboard");
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setSize(800, 480);
        userFrame.setVisible(true);
        userFrame.setLocationRelativeTo(null);
    }
}
