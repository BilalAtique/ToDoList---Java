import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ReaderAndWriter {
    public static void fileWriter(Task task) {
        try {
            String taskStr = task.getDate() + "," + task.getTime() + "," + task.getTaskDesc() + "," + task.getStatus()
                    + "\n";
            FileWriter writer = new FileWriter("Tasks-List.csv", true);
            writer.write(taskStr);
            writer.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public static String fileReader() {
        String fileContent = "";
        try {
            FileReader reader = new FileReader("Tasks-List.csv");
            int i;
            while ((i = reader.read()) != -1)
                fileContent += (char) i;
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return fileContent;
        }
    }
    public static ArrayList stringToList(String fileContent) {
        ArrayList<Task> tasksList = new ArrayList<>();
        String[] taskProperties;
        String[] lines = fileContent.split("[\\r\\n]+");
        for (int i = 0; i < lines.length; i++) {
            taskProperties = lines[i].split(",");
            Task task = new Task(taskProperties[0], taskProperties[1], taskProperties[2], taskProperties[3]);
            tasksList.add(task);
        }
        return tasksList;
    }
}