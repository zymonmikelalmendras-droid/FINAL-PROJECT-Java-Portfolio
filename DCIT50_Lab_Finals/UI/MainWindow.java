package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.TaskManager;
import model.AbstractTask;

public class MainWindow extends JFrame {
    private TaskManager manager;
    private JTable table;
    private DefaultTableModel model;
    private TaskForm form;

    public MainWindow(TaskManager manager) {
        this.manager = manager;

        setTitle("To-Do List Viewer");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addBtn = new JButton("Add Task");
        addBtn.setBounds(10, 10, 120, 30);
        add(addBtn);

        model = new DefaultTableModel(new Object[]{"Task ID", "Task Name", "Task Description", "Status"}, 0);
        table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(10, 50, 560, 300);
        add(scroll);

        addBtn.addActionListener(e -> {
            if (form == null || !form.isDisplayable()) {
                form = new TaskForm(this, manager);
                form.setVisible(true);
            }
        });

        refreshTable();
    }

    public void refreshTable() {
        model.setRowCount(0);
        for (AbstractTask t : manager.getTasks()) {
            model.addRow(new Object[]{
                t.getTaskId(),
                t.getTaskName(),
                t.getTaskDescription(),
                t.getStatus()
            });
        }
    }
}