import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Manager {
    private final HashMap<Integer, Task> allTask = new HashMap<>();
    private final HashMap<Integer, Subtask> allSubTask = new HashMap<>();
    private final HashMap<Integer, Epic> allEpics = new HashMap<>();
    private Integer taskId = 0;


    public Task createNewTask(Task task) {
        if (task != null) {
            Integer idTask = createId();
            allTask.put(idTask, task);
            task.setId(idTask);
        }
        return task;
    }

    public Epic createNewEpic(Epic epic) {
        Integer idEpic = createId();
        allEpics.put(idEpic, epic);
        epic.setId(idEpic);
        return epic;
    }

    public void createNewSubtask(Subtask subtask) {
        if (!allEpics.containsKey(subtask.getEpicId())) {   //Проверяем в списке эпиков отсутствие подзадачи
            return;
        }
        Integer idSubtask = createId();
        allSubTask.put(idSubtask, subtask);                 //Добавляем зададачу в Хеш-таблицу
        subtask.setId(idSubtask);                           //Устанавливаем ID
        Epic epic = allEpics.get(subtask.getEpicId());
        epic.addSubtaskList(subtask.getId());               //Добавляем эпику подзадачу
        epicStatus(epic);
    }

    //Все методы TASK:
    public List<Task> getAllTasks() {
        return new ArrayList<>(allTask.values());           //Получение списка всех задач
    }
    public Task getTaskById(int taskId) {                   //Получение задачи по номеру ID
        return allTask.get(taskId);
    }
    public boolean updateTask(Task task, Task oldTask) {     //Обновление объекта TASK
        if (!allTask.containsKey(oldTask.getId())) {
            return false;
        }
        allTask.replace(oldTask.getId(), task);
        return true;
    }
    public void deleteTask(Task task) {                     //Удаление задачи по ID
        allTask.remove(task.getId());
    }
    public void deleteAllTask() {                           //Удаление всех задач
        allTask.clear();
    }

    //Все методы EPIC
    public List<Epic> getAllEpics() {
        return new ArrayList<>(allEpics.values());          //Получение списка всех эпиков
    }
    public Epic getEpickById(int taskId) {                  //Получение эпика по номеру ID
        return allEpics.get(taskId);
    }
    public boolean updateEpic (Epic epic, Epic oldEpic) {     //Обновление объекта EPIC
        if (!allEpics.containsKey(oldEpic.getId())) {
            return false;
        }
        allEpics.replace(oldEpic.getId(), epic);
        return true;
    }
    public void deleteEpic(Epic epic){                      //Удаляем эпик со всеми позадачами
        if (epic.getSubTaskList().isEmpty()) {
            return;
        }
        for (Integer subtasckId: epic.getSubTaskList()) {
            allSubTask.remove(subtasckId);
        }
    }
    public void deleteAllEpics(){                            //Удаляем все эпики
        allSubTask.clear();
        allEpics.clear();
    }
    //Все методы SUBTASK
    public List<Subtask> getAllSubtasks(){                  //Получение списка всех подзадач
        return new ArrayList<>(allSubTask.values());
    }
    public Subtask getSubtaskById(int taskId){              //Получение подзадачи по ID
        return allSubTask.get(taskId);
    }
    public boolean updateSubtask (Subtask subtask, Subtask oldSubtask) {    //Обновление объекта SUBTASK
        if(!allSubTask.containsKey(oldSubtask.getId())) {
            return false;
        }
        allSubTask.replace(oldSubtask.getId(), subtask);
        epicStatus(allEpics.get(subtask.getEpicId()));
        return true;
    }
    public void deleteSubtask(Subtask subtask){
        allSubTask.remove(subtask.getId());
        if (allEpics.containsKey(subtask.getEpicId())) {
            Epic epic = allEpics.get(subtask.getEpicId());
            epic.getSubTaskList().remove((Integer) subtask.getId());
            epicStatus(epic);
        }
    }
    public void deleteAllSubtask() {
        allSubTask.clear();
        for (Epic epic : allEpics.values()) {
            epic.getSubTaskList().clear();
        }
    }
    public List<Subtask> getAllSubtaskListIFromEpic(int epicId) {       //Получение списка всех подзадач эпика
        ArrayList<Integer> subtaskIds = allEpics.get(epicId).getSubTaskList();
        ArrayList<Subtask> subtasks = new ArrayList<>();
        for(Integer subtaskId: subtaskIds) {
            subtasks.add(allSubTask.get(subtaskId));
        }
        return subtasks;
    }
    public void epicStatus (Epic epic) {                                //Управление статусами для эпиков
        HashSet<Status> status = new HashSet<>();
        if (epic.getSubTaskList().isEmpty()){
            epic.setStatus(Status.NEW);
        } else {
            for (int subtaskId: epic.getSubTaskList()) {
                status.add(allSubTask.get(subtaskId).getStatus());
            }
            if (status.size() == 1 && status.contains(Status.DONE)){
                epic.setStatus(Status.DONE);
            } else if (status.size() == 1 && status.contains(Status.NEW)){
                epic.setStatus(Status.NEW);
            } else {
                epic.setStatus(Status.IN_PROGRESS);
            }
        }
    }
    private int createId() {                                //Увеличение ID на 1
        return taskId++;
    }



}
