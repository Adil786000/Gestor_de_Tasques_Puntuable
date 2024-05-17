public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Task Management System!");
        System.out.println("Enter the name of the file to store tasks:");
        String filename = System.console().readLine();
        TaskManagement taskManagement = new TaskManagement(filename);

        while (true) {
            System.out.println("Enter one of the following options:");
            System.out.println("1. Add task");
            System.out.println("2. Modify task");
            System.out.println("3. Delete task");
            System.out.println("4. List tasks");
            System.out.println("5. Quit");

            int option = Integer.parseInt(System.console().readLine());

            switch (option) {
                case 1:
                    System.out.println("Enter task title:");
                    String title = System.console().readLine();
                    System.out.println("Enter task description:");
                    String description = System.console().readLine();
                    System.out.println("Enter task deadline:");
                    String deadline = System.console().readLine();
                    System.out.println("Enter task status:");
                    String status = System.console().readLine();
                    Task task = new Task(title, description, deadline, status);
                    taskManagement.addTask(task);
                    break;
                case 2:
                    System.out.println("Enter task title to modify:");
                    title = System.console().readLine();
                    for (Task t : taskManagement.tasks) {
                        if (t.getTitle().equals(title)) {
                            System.out.println("Enter new task title:");
                            t.setTitle(System.console().readLine());
                            System.out.println("Enter new task description:");
                            t.setDescription(System.console().readLine());
                            System.out.println("Enter new task deadline:");
                            t.setDeadline(System.console().readLine());
                            System.out.println("Enter new task status:");
                            t.setStatus(System.console().readLine());
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter task title to delete:");
                    title = System.console().readLine();
                    for (Task t : taskManagement.tasks) {
                        if (t.getTitle().equals(title)) {
                            taskManagement.deleteTask(t);
                            break;
                        }
                    }
                    break;
                case 4:
                    taskManagement.listTasks();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}