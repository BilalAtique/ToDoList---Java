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
}