import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class Main {

  public static void main(String[] args) {
    JFrame frame = new JFrame("TODO APP");
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton createTaskBtn = new JButton("Create Task");
    createTaskBtn.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          new TaskInput().takeTaskInputs();
        }
      }
    );

    JButton showTasksListBtn = new JButton("Show Tasks");
    showTasksListBtn.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          showTasksList();
        }
      }
    );

    JPanel mainPanel = new JPanel(new BorderLayout());
    frame.add(mainPanel);

    frame.setVisible(true);
  }

  private static void showTasksList() {
    JFrame tasksFrame = new JFrame("Task List");
    tasksFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    tasksFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    ArrayList<Task> tasksList = ReaderAndWriter.stringToList(
      ReaderAndWriter.fileReader()
    );

    String[] columnNames = { "Date", "Time", "Task Description", "Status" };

    Object[][] data = new Object[tasksList.size()][4];

    for (int i = 0; i < tasksList.size(); i++) {
      Task task = tasksList.get(i);
      data[i][0] = task.getDate();
      data[i][1] = task.getTime();
      data[i][2] = task.getTaskDesc();
      data[i][3] = task.getStatus();
    }

    JTable table = new JTable(data, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);

    tasksFrame.add(new JLabel("Task List"), BorderLayout.NORTH);
    tasksFrame.add(scrollPane, BorderLayout.CENTER);

    tasksFrame.setVisible(true);
  }
}
