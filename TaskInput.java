import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskInput {
    private JLabel success;
    private JTextField dateText;
    private JTextField timeText;
    private JTextField taskDescText;
    private JTextField statusText;

    public String date;
    public String time;
    public String taskDesc;
    public String status;

    public void takeTaskInputs() {
        JFrame frame = new JFrame("Create Task");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        addInputField(panel, "Enter Date:", dateText = new JTextField(20));
        addInputField(panel, "Enter Time:", timeText = new JTextField(20));
        addInputField(panel, "Enter Task Description:", taskDescText = new JTextField(20));
        addInputField(panel, "Enter Status:", statusText = new JTextField(20));

        JButton button = new JButton("Create Task");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                date = dateText.getText();
                time = timeText.getText();
                taskDesc = taskDescText.getText();
                status = statusText.getText();
                Task task = new Task(date, time, taskDesc, status);
                ReaderAndWriter.fileWriter(task);
                success.setText("Task Added successfully");
            }
        });
        panel.add(button);

        success = new JLabel("");
        panel.add(success);

        frame.add(panel);
        frame.setVisible(true);
    }
}
