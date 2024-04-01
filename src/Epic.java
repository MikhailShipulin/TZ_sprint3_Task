import java.util.ArrayList;

class Epic extends Task {
    public ArrayList<Integer> subTaskList = new ArrayList<>();
    public Epic(String name, String description) {
        super(name, description);
    }

    public ArrayList<Integer> getSubTaskList() {
        return subTaskList;
    }

    public void addSubtaskList(Integer idSubtask) {
        subTaskList.add(idSubtask);
    }

    @Override
    public String toString() {
        return "Epic{" +
                ", epicId=" + super.getId() +
                "name=" + super.getName() +
                ", description=" + super.getDescription() +
                ", status=" + super.getStatus() +
                ", subTaskList=" + getSubTaskList() +
                '}';
    }


//    List<Integer> subtask;
//
//    public void removeSubtask(Integer subtaskId) {
//        subtask.remove(subtaskId);
//    }
}
