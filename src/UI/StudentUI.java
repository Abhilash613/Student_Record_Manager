package UI;

import DAO.StudentDAO;
import entity.Student;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class StudentUI {
    private JFrame frame;
    private JTextField nameField, ageField, courseField;
    private JButton addButton;

    public StudentUI() {
        frame = new JFrame("Student Record Manager");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 30);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(140, 30, 200, 30);
        frame.add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(30, 70, 100, 30);
        frame.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(140, 70, 200, 30);
        frame.add(ageField);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(30, 110, 100, 30);
        frame.add(courseLabel);

        courseField = new JTextField();
        courseField.setBounds(140, 110, 200, 30);
        frame.add(courseField);

        addButton = new JButton("Add Student");
        addButton.setBounds(140, 160, 150, 30);
        frame.add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String course = courseField.getText();

                Student student = new Student(name, age, course);
                StudentDAO dao = new StudentDAO();

                try {
                    dao.addStudent(student);
                    JOptionPane.showMessageDialog(frame, "Student Added!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

