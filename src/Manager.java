import java.util.HashMap;
import java.util.List;

public class Manager {
    HashMap<Integer, Task> allTask = new HashMap<>();
    HashMap<Integer, Task> allSubTask = new HashMap<>();
    HashMap<Integer, Epic> allEpics = new HashMap<>();

    private Integer id = 0;
    private Integer generateId(){
        this.id++;
        return this.id;
    }
    public Task createNewTask(Task task) {
        task.id = generateId();
        allTask.put(task.id, task);
        return task;
    }

//    public Task createNewSubTask() {
//        Subtask task = new Subtask();
//        task.id = generateId();
//        allSubTask.put(task.id, task);
//        return task;
//    }

    public Epic createNewEpic(Epic task) {
        task.id = generateId();
        allEpics.put(task.id, task);
        return task;
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

}
