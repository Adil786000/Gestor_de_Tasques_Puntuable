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
    }

    public void printAllTask() {
   	 tasks.forEach((key, task) -> {
   		 System.out.print(task.getId() + " ");
   		 System.out.print(task.getName() + " ");
   		 System.out.println(task.isDone());
   	 }
   	 );
    }

    public void printTaskByPriority(String priority) {
   	 System.out.println("Tareas de prioridad: " + priority);
   	 for (Task task: lists.get(priority)) {
   		 System.out.print(task.getId() + " ");
   		 System.out.print(task.getName() + " ");
   		 System.out.println(task.isDone());
   	 }
    }
}

class Task
{
    private static int numInstances = 0;
    private int id;
    private String name;
    private boolean isDone;

    public Task(String name) {
   	 this.name = name;
   	 this.isDone = false;
   	 this.id = ++numInstances;
    }

    public void done() {
   	 this.isDone = true;
    }

    public int getId() {
   	 return this.id;
    }

    public String getName() {
   	 return this.name;
    }

    public boolean isDone() {
   	 return this.isDone;
    }
}

class Main
{
    public static void main(String[] args) {
   	 TaskManagement manager = new TaskManagement();
   	 System.out.println("Add task");
   	 manager.addTask("Aprobar Programacion", "Alta");
   	 System.out.println("Hacemos Print de todo");
   	 manager.printAllTask();
   	 System.out.println("Hacemos Print de prioridad");
   	 manager.printTaskByPriority("Alta");
   	 System.out.println("Hacemos que la tarea este done");
   	 manager.doneTask(1);
   	 System.out.println("Hacemos Print de todo");
   	 manager.printAllTask();
   	 System.out.println("Eliminamos la tarea");
   	 manager.deleteTask(1);
   	 System.out.println("Hacemos Print de todo");
   	 manager.printAllTask();
    }
}
