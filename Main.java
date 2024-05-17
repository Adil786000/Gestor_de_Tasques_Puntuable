import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManagement taskManagement = new TaskManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar tarea");
            System.out.println("2. Ver tareas");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese título: ");
                    String title = scanner.next();
                    System.out.print("Ingrese descripción: ");
                    String description = scanner.next();
                    System.out.print("Ingrese fecha límite: ");
                    String deadline = scanner.next();
                    taskManagement.addTask(title, description, deadline);
                    break;
                case 2:
                    for (Task t : taskManagement.getTasksList()) {
                        System.out.println("Título: " + t.getTitle());
                        System.out.println("Descripción: " + t.getDescription());
                        System.out.println("Fecha límite: " + t.getDeadline());
                        System.out.println("Estado: " + t.getStatus());
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtalo de nuevo.");
            }
        }
    }

    public static class TaskManagement {
        private List<Task> tasks = new ArrayList<>();

        public void addTask(String title, String description, String deadline) {
            Task task = new Task();
            task.setTitle(title);
            task.setDescription(description);
            task.setDeadline(deadline);
            tasks.add(task);
        }

        public List<Task> getTasksList() {
            return tasks;
        }

        public void getTasks() {
            for (Task t : tasks) {
                System.out.println("Título: " + t.getTitle());
                System.out.println("Descripción: " + t.getDescription());
                System.out.println("Fecha límite: " + t.getDeadline());
                System.out.println("Estado: " + t.getStatus());
            }
        }
    }

    public static class Task {
        private String title;
        private String description;
        private String deadline;
        private String status;

        public Task() {}

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDeadline(String deadline) {
            this.deadline = deadline;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getDeadline() {
            return deadline;
        }

        public String getStatus() {
            return status;
        }
    }
}