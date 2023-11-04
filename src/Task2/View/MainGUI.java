package Task2.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JButton addTask = new JButton("Add");
    private JButton deleteTask = new JButton("Delete");
    private JButton view = new JButton("View Tasks");

    public MainGUI(){
        setTitle("Task Manager");
        setLayout(new FlowLayout());
        setSize(150,150);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(addTask);
        add(deleteTask);
        add(view);

        addTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(()->{
                    AddTask at = new AddTask();
                });
            }
        });

        deleteTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(()->{
                    DeleteTask dt = new DeleteTask();
                });
            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(()->{
                    TaskView tv = new TaskView();
                });
            }
        });
    }

    public static void main(String... args){
        SwingUtilities.invokeLater(()->{
            MainGUI mgui = new MainGUI();
        });
    }
}
