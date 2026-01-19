package ui;

import javax.swing.*;
import controller.TaskManager;
import model.Task;

public class TaskForm extends JFrame {
    public TaskForm(MainWindow main, TaskManager manager) {
        setTitle("Add Task");
        setSize(350, 300);
        setLayout(null);

        JLabel lblId = new JLabel("Task ID:");
        lblId.setBounds(10, 10, 100, 20);
        add(lblId);

        JTextField txtId = new JTextField(String.valueOf(manager.generateTaskId()));
        txtId.setBounds(120, 10, 150, 20);
        txtId.setEditable(false);
        add(txtId);

        JLabel lblName = new JLabel("Task Name:");
        lblName.setBounds(10, 40, 100, 20);
        add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(120, 40, 150, 20);
        add(txtName);

        JLabel lblDesc = new JLabel("Description:");
        lblDesc.setBounds(10, 70, 100, 20);
        add(lblDesc);

        JTextArea txtDesc = new JTextArea();
        JScrollPane descScroll = new JScrollPane(txtDesc);
        descScroll.setBounds(120, 70, 150, 60);
        add(descScroll);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(10, 140, 100, 20);
        add(lblStatus);

        JComboBox<String> statusBox = new JComboBox<>();
        statusBox.addItem("Not Started");
        statusBox.addItem("Ongoing");
        statusBox.addItem("Completed");
        statusBox.setBounds(120, 140, 150, 20);
        add(statusBox);

        JButton saveBtn = new JButton("Save Task");
        saveBtn.setBounds(100, 190, 120, 30);
        add(saveBtn);

        saveBtn.addActionListener(e -> {
            String name = txtName.getText().trim();
            String status = (String) statusBox.getSelectedItem();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Task Name is required.");
                return;
            }

            Task task = new Task(
                Integer.parseInt(txtId.getText()),
                txtName.getText(),
                txtDesc.getText(),
                status
            );

            manager.addTask(task);
            main.refreshTable();
            dispose();
        });
    }
}