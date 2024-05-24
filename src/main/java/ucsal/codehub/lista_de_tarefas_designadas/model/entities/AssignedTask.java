package ucsal.codehub.lista_de_tarefas_designadas.model.entities;

public class AssignedTask {
    private Integer idCount = 0;

    protected String name;
    protected Integer id;
    protected Person person;

    public AssignedTask() {}

    public AssignedTask(String name, Person person) {
        this.name = name;
        this.person = person;
        this.id = getNewId();
    }

    public AssignedTask(String name, Person person , Integer id) {
        this.name = name;
        this.person = person;
        this.id = id;
    }

    private Integer getNewId(){
        return ++idCount;
    }
}
