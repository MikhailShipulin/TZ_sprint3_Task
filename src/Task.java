public class Task {
    //Название, кратко описывающее суть задачи (например, «Переезд»).
    protected Integer id;
    static Integer totalId = 0;
    public String nameTask;

    public Task(String nameTask) {
        this.id = totalId;
        totalId++;
        this.nameTask = nameTask;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", nameTask='" + nameTask + '\'' +
                '}';
    }
}
