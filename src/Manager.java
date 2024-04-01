import java.util.HashMap;

public class Manager {
    private final HashMap<Integer, Task> allTask = new HashMap<>();
    private final HashMap<Integer, Subtask> allSubTask = new HashMap<>();
    private final HashMap<Integer, Epic> allEpics = new HashMap<>();
    private Integer taskId = 0;


    public Task createNewTask(Task task) {
        if(task != null){
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
    public  void createNewSubtask(Subtask subtask){
        if (!allEpics.containsKey(subtask.getEpicId())) {   //Проверяем в списке эпиков отсутствие подзадачи
            return;
        }
        Integer idSubtask = createId();
        allSubTask.put(idSubtask, subtask);                 //Добавляем зададачу в Хеш-таблицу
        subtask.setId(idSubtask);                           //Устанавливаем ID
        Epic epic = allEpics.get(subtask.getEpicId());
        epic.addSubtaskList(subtask.getId());               //Добавляем эпику подзадачу
    }



//    public List<Task> getAllTask(){
//        return
//    }
//
//    public void deleteAllTask(Task task){
//
//    }
//
//    public List<Epic> getAllEpics(){
//
//        return allEpics;
//    }
    private int createId() {
        return taskId++;
    }

    public HashMap<Integer, Task> getAllTask() {
        return allTask;
    }

    public HashMap<Integer, Epic> getAllEpics() {
        return allEpics;
    }
}
