import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. View tasks");
            System.out.println("4. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addTask() {
        System.out.println("Enter task:");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void removeTask() {
        System.out.println("Enter task number to remove:");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            String removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task \"" + removedTask + "\" removed successfully!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
