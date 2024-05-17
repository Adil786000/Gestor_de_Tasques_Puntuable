import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

class TaskManagement {
	private String fileName;
  
    public TaskManagement(String fileName) {
		this.filename = fileName;
		loadTasksFromfile();
    }

    public void addTask(String taskName, String priority) {
		
		tasks.put(task.getId(), task);
		saveTasksToFile();
	 
    }

    public void modifyTask(int taskId, String taskName) {
		Task task = tasks.get(taskId);
		if (task != null) {
			task.setName(taskName);
			saveTasksToFile();
		}

    }

    public void deleteTask(int taskId) {
   	 tasks.remove(taskId);
	 saveTasksToFile();

    }
    public void printAllTasks() {
        // ...
        saveTasksToFile();
    }

	   public void printTasksByPriority(String priority) {
        // ...
    }

    private void loadTaskFromfile() {
		try (BufferedReader reader = new BufferedReader(new
		FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
			Task task = new Task(fields[0]);
                task.setPriority(fields[1]);
                // ...
                tasks.put(task.getId(), task);
            }
        } catch (Exception e) {
            System.out.println("Error loading tasks from file: " + e.getMessage());
        }
    }