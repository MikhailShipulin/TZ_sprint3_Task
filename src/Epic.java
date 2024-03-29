import java.util.List;

class Epic extends Task {
    public Epic(String nameTask) {
        super(nameTask);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", nameTask='" + nameTask + '\'' +
                '}';
    }

//    List<Integer> subtask;
//
//    public void removeSubtask(Integer subtaskId) {
//        subtask.remove(subtaskId);
//    }
}
