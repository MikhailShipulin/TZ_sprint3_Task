import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Введите название задачи");
                String name = scanner.next();

                System.out.println("Выберите тип задачи");
                System.out.println("1 - ПРОСТАЯ ЗАДАЧА");
                System.out.println("2 - ЭПИК ЗАДАЧА");
                int button = scanner.nextInt();
                if (button == 1) {
                    Task name1 = new Task(name);
                    Task firstTask = manager.createNewTask(name1);
                } else if (button == 2) {
                    Epic name2 = new Epic(name);
                    Epic secondTask = manager.createNewEpic(name2);
                }
            } else if (command == 2) {
                System.out.println(manager.allTask);
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }
    public static void printMenu() {
        System.out.println("Добро пожаловать в программу ТРЕКЕР ЗАДАЧ ");
        System.out.println("1 - Добавить задачу");
        System.out.println("2 - Вывести список задач");

        System.out.println("0 - Выход");
    }
}


