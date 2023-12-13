import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    static class Task {
        String description;
        boolean isCompleted;

        Task(String description) {
            this.description = description;
            this.isCompleted = false;
        }
    }

    static class ToDoList {
        ArrayList<Task> tasks = new ArrayList<>();

        void addTask(String description) {
            Task newTask = new Task(description);
            tasks.add(newTask);
            System.out.println("Task added: " + description);
        }

        void viewTasks() {
            if (tasks.isEmpty()) {
                System.out.println("No tasks in the to-do list.");
            } else {
                System.out.println("To-Do List:");
                for (int i = 0; i < tasks.size(); i++) {
                    Task task = tasks.get(i);
                    System.out.println((i + 1) + ". " + task.description + " - " + (task.isCompleted ? "Completed" : "Not Completed"));
                }
            }
        }

        void markAsCompleted(int index) {
            if (index >= 0 && index < tasks.size()) {
                Task task = tasks.get(index);
                task.isCompleted = true;
                System.out.println("Task marked as completed: " + task.description);
            } else {
                System.out.println("Invalid task index.");
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== To-Do List App =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    scanner.nextLine(); // consume the newline character
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    toDoList.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter the index of the task to mark as completed: ");
                    int index = scanner.nextInt();
                    toDoList.markAsCompleted(index - 1); // Adjust index to 0-based
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
