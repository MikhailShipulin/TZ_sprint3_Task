import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        System.out.println("\nПользователь создает первую задачу");
        Task task1 = new Task("Task1", "Description Task1");
        manager.createNewTask(task1);
        System.out.println("Добалена задача: " + task1);

        System.out.println("\nПользователь создает вторую задачу");
        Task task2 = new Task("Task2", "Description Task2");
        manager.createNewTask(task2);
        System.out.println("Добалена задача: " + task2);

        System.out.println("\nПользователь создает первый эпик");
        Epic epic1 = new Epic("Epic1", "Descrпiption Epic1");
        manager.createNewEpic(epic1);
        System.out.println("Добавлен эпик " + epic1);

        System.out.println("\nПользователь создает первую подзадачу первого эпика");
        Subtask subtask11 = new Subtask("Subtask11", "Descrпiption Subtask11", epic1.getId());
        manager.createNewSubtask(subtask11);
        System.out.println("Добавлена подзадача: " + subtask11);

        System.out.println("\nПользователь создает вторую подзадачу первого эпика");
        Subtask subtask12 = new Subtask("Subtask12", "Descrпiption Subtask12", epic1.getId());
        manager.createNewSubtask(subtask12);
        System.out.println("Добавлена подзадача: " + subtask12);

        System.out.println("\nПользователь создает второй эпик");
        Epic epic2 = new Epic("Epic2", "Descrпiption Epic2");
        manager.createNewEpic(epic2);
        System.out.println("Добавлен эпик " + epic2);

        System.out.println("\nПользователь создает первую подзадачу второго эпика");
        Subtask subtask21 = new Subtask("Subtask21", "Descrпiption Subtask21", epic2.getId());
        manager.createNewSubtask(subtask21);
        System.out.println("Добавлена подзадача: " + subtask21);

        System.out.println("\nПрограмма выводит список всех задач \n" + manager.getAllTasks());
        System.out.println("\nПрограмма выводит список всех эпиков \n" + manager.getAllEpics());
        System.out.println("\nПрограмма выводит список всех подзадач \n" + manager.getAllSubtasks());

        task1.setStatus(Status.IN_PROGRESS);
        System.out.println("\nСтатус " + task1.getName() + " изменен на " + task1.getStatus());
        task2.setStatus(Status.IN_PROGRESS);
        System.out.println("Статус " + task2.getName() + " изменен на " + task2.getStatus());
        subtask11.setStatus(Status.IN_PROGRESS);
        System.out.println("Статус " + subtask11.getName() + " изменен на " + subtask11.getStatus());
        subtask12.setStatus(Status.IN_PROGRESS);
        System.out.println("Статус " + subtask12.getName() + " изменен на " + subtask12.getStatus());
        subtask21.setStatus(Status.IN_PROGRESS);
        System.out.println("Статус " + subtask21.getName() + " изменен на " + subtask21.getStatus());

        System.out.println("\nПрограмма выводит список всех подзадач \n" + manager.getAllSubtasks());

        subtask11.setStatus(Status.DONE);
        manager.updateSubtask(subtask11, subtask11); // После изменения статуса Subtask, обновляем статус эпика
        System.out.println("Статус " + subtask11.getName() + " изменен на " + subtask11.getStatus());
        subtask21.setStatus(Status.DONE);
        manager.updateSubtask(subtask21, subtask21);
        System.out.println("Статус " + subtask21.getName() + " изменен на " + subtask21.getStatus());

        System.out.println("\nПрограмма выводит список всех подзадач \n" + manager.getAllSubtasks());

        System.out.println("\n Статус " + epic1.getName() + " расчитан и соответствует " + epic1.getStatus());
        System.out.println("\n Статус " + epic2.getName() + " расчитан и соответствует " + epic2.getStatus());

        System.out.println("\nПограмма удаляет " + subtask12.getName() + " из " + epic1.getName());
        manager.deleteSubtask(subtask12);

        System.out.println("\nПрограмма выводит список всех подзадач \n" + manager.getAllSubtasks());

        System.out.println("\nПограмма удаляет " + epic2.getName());
        manager.deleteEpic(epic2);

        System.out.println("\nПрограмма выводит список всех эпиков \n" + manager.getAllEpics());

        System.out.println("\nПрограмма программа удаляет все задачи, подзадачи, эпики \n");
        manager.deleteAllTask();
        manager.deleteAllSubtask();
        manager.deleteAllEpics();

        System.out.println("\nПрограмма выводит список всех задач \n" + manager.getAllTasks());
        System.out.println("\nПрограмма выводит список всех эпиков \n" + manager.getAllEpics());
        System.out.println("\nПрограмма выводит список всех подзадач \n" + manager.getAllSubtasks());






    }
}

