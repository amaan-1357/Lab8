package Task2.View;

import Task2.Controller.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import javax.swing.table.DefaultTableModel;

public class TaskView extends JFrame {
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private JButton close = new JButton("Close");
    private Task tasks = new Task();

    public TaskView() {
        setVisible(true);
        setTitle("Task Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] columnNames = {"ID", "Description", "IsCompleted"};
        tableModel = new DefaultTableModel(columnNames, 0);
        taskTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(taskTable);

        JPanel panel = new JPanel(new BorderLayout());
        add(close);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(close,BorderLayout.SOUTH);

        add(panel);
        ArrayList<Task> task = tasks.getTasks();
        for(Task t: task){
            addTaskToTable(t.getTask_id().toString(),t.getTask_description(),t.getIs_completed().toString());
        }
    }

    private void addTaskToTable(String id, String description, String isCompleted) {
        Object[] rowData = {id, description, isCompleted};
        tableModel.addRow(rowData);
    }
}
