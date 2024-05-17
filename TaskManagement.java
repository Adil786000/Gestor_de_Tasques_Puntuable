import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskManagement {
    private List<Task> tasks;
    private String filename;

    public TaskManagement(String filename) {
        this.filename = filename;
        this.tasks = new ArrayList<>();
        loadTasksFromFile();
    }

    public void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Task task = new Task(parts[0], parts[1], parts[2], parts[3]);
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks from file: " + e.getMessage());
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveTasksToFile();
    }

    public void modifyTask(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTitle().equals(task.getTitle())) {
                tasks.set(i, task);
                saveTasksToFile();
                return;
            }
        }
        System.out.println("Task not found");
    }

    public void deleteTask(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTitle().equals(task.getTitle())) {
                tasks.remove(i);
                saveTasksToFile();
                return;
            }
        }
        System.out.println("Task not found");
    }

    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task.getTitle() + " - " + task.getDescription() + " - " + task.getDeadline() + " - " + task.getStatus());
        }
    }

    public void saveTasksToFile() {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Task task : tasks) {
                writer.write(task.getTitle() + "," + task.getDescription() + "," + task.getDeadline() + "," + task.getStatus() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks to file: " + e.getMessage());
        }
    }
}