package Task2.View;

import Task2.Controller.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SpringLayout;

public class DeleteTask extends JFrame {
    private JLabel taskIdLabel = new JLabel("Task ID: ");
    private JTextField taskIdTextField = new JTextField(10);
    private JButton deleteButton = new JButton("Delete");
    private SpringLayout layout = new SpringLayout();
    private Task task = new Task();

    public DeleteTask() {
        setTitle("Delete Task");
        setLayout(new FlowLayout());
        setSize(500, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(taskIdLabel);
        layout.putConstraint(SpringLayout.NORTH, taskIdLabel, 5, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, taskIdLabel, 5, SpringLayout.EAST, this);

        add(taskIdTextField);
        layout.putConstraint(SpringLayout.NORTH, taskIdTextField, 5, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, taskIdTextField, 5, SpringLayout.WEST, taskIdLabel);

        add(deleteButton);
        layout.putConstraint(SpringLayout.NORTH, deleteButton, 5, SpringLayout.SOUTH, taskIdLabel);
        layout.putConstraint(SpringLayout.EAST, deleteButton, 50, SpringLayout.EAST, this);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task.delete(Integer.parseInt(taskIdTextField.getText()));
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DeleteTask dt = new DeleteTask();
        });
    }
}
