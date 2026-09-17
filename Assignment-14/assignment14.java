package Assignment14;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class StudentMarks {
    int rollNo;
    String name;
    double marks;

    StudentMarks(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
}

public class assignment14 {
    private final JFrame frame = new JFrame("Student Marks Viewer");
    private final JTextField rollField = new JTextField(6);
    private final JTextField nameField = new JTextField(10);
    private final JTextField marksField = new JTextField(6);
    private final DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Roll No", "Name", "Marks"}, 0);
    private final JTable table = new JTable(tableModel);
    private final JLabel averageLabel = new JLabel("Class Average: 0.0", SwingConstants.CENTER);
    private final List<StudentMarks> studentList = new ArrayList<>();

    public assignment14() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Roll No:"));
        inputPanel.add(rollField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Marks:"));
        inputPanel.add(marksField);

        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0 && row < studentList.size()) {
                rollField.setText(tableModel.getValueAt(row, 0).toString());
                nameField.setText(tableModel.getValueAt(row, 1).toString());
                marksField.setText(tableModel.getValueAt(row, 2).toString());
            }
        });

        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        JButton avgBtn = new JButton("Show Average");
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(avgBtn);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(btnPanel, BorderLayout.NORTH);
        bottomPanel.add(averageLabel, BorderLayout.SOUTH);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> addRecord());
        updateBtn.addActionListener(e -> updateRecord());
        deleteBtn.addActionListener(e -> deleteRecord());
        avgBtn.addActionListener(e -> showAverage());

        frame.setSize(550, 420);
        frame.setLocationRelativeTo(null);
    }

    private void addRecord() {
        try {
            int r = Integer.parseInt(rollField.getText().trim());
            String n = nameField.getText().trim();
            double m = Double.parseDouble(marksField.getText().trim());
            if (n.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");

            studentList.add(new StudentMarks(r, n, m));
            tableModel.addRow(new Object[]{r, n, m});
            System.out.println("[Add clicked] Roll No: " + r + ", Name: " + n + ", Marks: " + m);
            System.out.println("Row added to table.");
            clearInputs();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateRecord() {
        try {
            int row = table.getSelectedRow();
            if (row < 0) throw new ArrayIndexOutOfBoundsException("Please select a row to update.");
            int r = Integer.parseInt(rollField.getText().trim());
            String n = nameField.getText().trim();
            double m = Double.parseDouble(marksField.getText().trim());
            if (n.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");

            StudentMarks sm = studentList.get(row);
            sm.rollNo = r;
            sm.name = n;
            sm.marks = m;
            tableModel.setValueAt(r, row, 0);
            tableModel.setValueAt(n, row, 1);
            tableModel.setValueAt(m, row, 2);
            System.out.println("[Row " + (row + 1) + " selected, Update clicked] Marks changed to " + m);
            System.out.println("Row updated successfully.");
            clearInputs();
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteRecord() {
        try {
            int row = table.getSelectedRow();
            if (row < 0) throw new ArrayIndexOutOfBoundsException("Please select a row to delete.");
            studentList.remove(row);
            tableModel.removeRow(row);
            System.out.println("Row deleted successfully.");
            clearInputs();
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showAverage() {
        double avg = studentList.stream().mapToDouble(s -> s.marks).average().orElse(0.0);
        averageLabel.setText(String.format("Class Average: %.1f", avg));
        System.out.println("[Show Average clicked]");
        System.out.printf("Class Average: %.1f%n", avg);
        launchJavaFXPreview(avg);
    }

    @SuppressWarnings("unchecked")
    private void launchJavaFXPreview(double avg) {
        System.out.println("[JavaFX window launched]");
        System.out.printf("Class Average (JavaFX): %.1f%n", avg);
        try {
            Class<?> plat = Class.forName("javafx.application.Platform");
            Class<?> stg = Class.forName("javafx.stage.Stage");
            Class<?> scn = Class.forName("javafx.scene.Scene");
            Class<?> lbl = Class.forName("javafx.scene.control.Label");
            Class<?> btn = Class.forName("javafx.scene.control.Button");
            Class<?> box = Class.forName("javafx.scene.layout.VBox");

            plat.getMethod("runLater", Runnable.class).invoke(null, (Runnable) () -> {
                try {
                    Object s = stg.getConstructor().newInstance();
                    Object l = lbl.getConstructor(String.class).newInstance(String.format("Class Average (JavaFX): %.1f", avg));
                    Object b = btn.getConstructor(String.class).newInstance("Close");
                    btn.getMethod("setOnAction", Class.forName("javafx.event.EventHandler")).invoke(b, java.lang.reflect.Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[]{Class.forName("javafx.event.EventHandler")}, (p, m, a) -> {
                        stg.getMethod("close").invoke(s);
                        return null;
                    }));
                    Object v = box.getConstructor(double.class).newInstance(10.0);
                    ((List<Object>) box.getMethod("getChildren").invoke(v)).addAll(List.of(l, b));
                    s.getClass().getMethod("setScene", scn).invoke(s, scn.getConstructor(Class.forName("javafx.scene.Parent"), double.class, double.class).newInstance(v, 260.0, 120.0));
                    s.getClass().getMethod("show").invoke(s);
                } catch (Exception ignored) {}
            });
        } catch (Throwable t) {
            JDialog d = new JDialog(frame, "Class Average (JavaFX)", true);
            d.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
            d.add(new JLabel(String.format("Class Average (JavaFX): %.1f", avg)));
            JButton b = new JButton("Close");
            b.addActionListener(e -> d.dispose());
            d.add(b);
            d.setSize(260, 120);
            d.setLocationRelativeTo(frame);
            d.setVisible(true);
        }
    }

    private void clearInputs() {
        rollField.setText("");
        nameField.setText("");
        marksField.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new assignment14().frame.setVisible(true));
    }
}