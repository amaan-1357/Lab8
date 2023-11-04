package Task2.View;

import Task2.Controller.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTask extends JFrame {
    private JLabel descriptionLabel = new JLabel("Description: ");
    private JTextArea descriptionTextArea = new JTextArea(3,15);
    private JLabel isCompletedLabel = new JLabel("Is Completed: ");
    private JComboBox<String> isCompletedComboBox = new JComboBox<>(new String[]{"True", "False"});
    private JButton addButton = new JButton("Add");
    private SpringLayout layout = new SpringLayout();

    private Task task = new Task();

    public AddTask() {
        setTitle("Add Task");
        setLayout(new FlowLayout());
        setSize(500,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(descriptionLabel);
        layout.putConstraint(SpringLayout.NORTH,descriptionLabel,5,SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.EAST,descriptionLabel,5,SpringLayout.EAST,this);

        add(descriptionTextArea);
        layout.putConstraint(SpringLayout.NORTH,descriptionTextArea, 5, SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.EAST,descriptionTextArea, 5, SpringLayout.WEST,descriptionLabel);

        add(isCompletedLabel);
        layout.putConstraint(SpringLayout.NORTH,isCompletedLabel, 5, SpringLayout.SOUTH,descriptionTextArea);
        layout.putConstraint(SpringLayout.EAST,isCompletedLabel, 5, SpringLayout.EAST,this);

        add(isCompletedComboBox);
        layout.putConstraint(SpringLayout.NORTH,isCompletedComboBox,5,SpringLayout.SOUTH,descriptionTextArea);
        layout.putConstraint(SpringLayout.EAST,isCompletedComboBox,5,SpringLayout.EAST,isCompletedLabel);

        add(addButton);
        layout.putConstraint(SpringLayout.NORTH,addButton,5,SpringLayout.SOUTH,isCompletedLabel);
        layout.putConstraint(SpringLayout.EAST,addButton,50,SpringLayout.EAST,this);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task = new Task(descriptionTextArea.getText(),Boolean.getBoolean(isCompletedComboBox.getSelectedItem().toString()));
                task.insert();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddTask at = new AddTask();
        });
    }
}
