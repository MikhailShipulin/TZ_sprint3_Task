class Subtask extends Task{
     private Integer epicId;

    public Subtask(String name, String description, Integer epicId) {
        super(name, description);
        this.epicId = epicId;
    }

    public Integer getEpicId() {
        return epicId;
    }

    public void setEpicId(Integer epicId) {
        this.epicId = epicId;
    }
    @Override
    public String toString() {
        return "Subtask{" +
                "epicId=" + epicId +
                "name=" + super.getName() +
                ", description=" + super.getDescription() +
                ", status=" + super.getStatus() +
                ", subtaskId=" + super.getId() +
                '}';
    }
}
