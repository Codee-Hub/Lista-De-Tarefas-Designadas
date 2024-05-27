package ucsal.codehub.lista_de_tarefas_designadas.model.entities;

import ucsal.codehub.lista_de_tarefas_designadas.model.enums.AssignedTaskStatus;

public class AssignedTask <T extends Person>  {
    private static Integer idCount = 0;

    protected String name;
    protected Integer id;
    protected T person;
    protected AssignedTaskStatus status;

    public AssignedTask() {}

    public AssignedTask(String name, T person) {
        this.name = name;
        this.person = person;
        this.id = getNewId();
        this.status = AssignedTaskStatus.PENDING;
    }

    public AssignedTask(String name, T person , Integer id) {
        this.name = name;
        this.person = person;
        this.id = id;
        this.status = AssignedTaskStatus.PENDING;
    }

    private Integer getNewId(){
        return idCount++;
    }

    public T getPerson() {
        return person;
    }

    public void setPerson(T person) {
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AssignedTaskStatus getStatus() {
        return status;
    }

    public void setStatus(AssignedTaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AssignedTask{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", person=" + person +
                ", status=" + status +
                '}';
    }
}
