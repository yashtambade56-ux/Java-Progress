package Assignment13;

import java.awt.*;
import javax.swing.*;

public class assignment13 {

    private JFrame frame;
    private JTextField nameField;
    private JTextField courseField;
    private JTextField ratingField;
    private JTextField commentsField;
    private JTextArea feedbackArea;

    public assignment13() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Student Feedback Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save Feedback");
        JMenuItem clearItem = new JMenuItem("Clear Form");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(saveItem);
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 8, 8));
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 15, 5, 15),
                BorderFactory.createTitledBorder("Enter Student Feedback")
        ));

        nameField = new JTextField();
        courseField = new JTextField();
        ratingField = new JTextField();
        commentsField = new JTextField();

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Course:"));
        formPanel.add(courseField);
        formPanel.add(new JLabel("Rating (1-5):"));
        formPanel.add(ratingField);
        formPanel.add(new JLabel("Comments:"));
        formPanel.add(commentsField);

        feedbackArea = new JTextArea(10, 40);
        feedbackArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 15, 5, 15),
                BorderFactory.createTitledBorder("Submitted Feedback List")
        ));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton submitButton = new JButton("Submit Feedback");
        JButton clearButton = new JButton("Clear Form");
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(e -> submitFeedback());
        saveItem.addActionListener(e -> submitFeedback());

        clearButton.addActionListener(e -> clearForm());
        clearItem.addActionListener(e -> clearForm());

        exitItem.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to exit?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(
                frame,
                "About: Student Feedback Form v1.0\nSubmitted by: Rahul Sharma\nCourse: B.Tech CE\nPurpose: Collect, validate, and display student feedback.",
                "About",
                JOptionPane.INFORMATION_MESSAGE
        ));

        frame.setSize(520, 520);
        frame.setLocationRelativeTo(null);
    }

    private void submitFeedback() {
        String name = nameField.getText().trim();
        String course = courseField.getText().trim();
        String ratingStr = ratingField.getText().trim();
        String comments = commentsField.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Name field cannot be empty! Please enter a valid name.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            nameField.requestFocus();
            return;
        }

        if (course.isEmpty()) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Course field cannot be empty! Please enter a course.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            courseField.requestFocus();
            return;
        }

        int rating;
        try {
            rating = Integer.parseInt(ratingStr);
            if (rating < 1 || rating > 5) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Rating must be between 1 and 5.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE
                );
                ratingField.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Rating must be a valid numeric integer! (e.g. 1 to 5)",
                    "Invalid Rating",
                    JOptionPane.ERROR_MESSAGE
            );
            ratingField.requestFocus();
            return;
        }

        String entry = String.format("Name: %-14s | Course: %-10s | Rating: %d/5 | Comments: %s%n",
                name, course, rating, comments.isEmpty() ? "None" : comments);
        feedbackArea.append(entry);

        JOptionPane.showMessageDialog(
                frame,
                "Feedback added to list successfully!",
                "Feedback Submitted",
                JOptionPane.INFORMATION_MESSAGE
        );

        clearForm();
    }

    private void clearForm() {
        nameField.setText("");
        courseField.setText("");
        ratingField.setText("");
        commentsField.setText("");
        nameField.requestFocus();
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            assignment13 app = new assignment13();
            app.setVisible(true);
        });
    }
}
