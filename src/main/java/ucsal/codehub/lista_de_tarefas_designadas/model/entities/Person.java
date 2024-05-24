package ucsal.codehub.lista_de_tarefas_designadas.model.entities;

public class Person {
    private static Integer idCount = 0;

    protected String name;
    protected Integer id;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
        this.id = getNewId();
    }

    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    private Integer getNewId(){
        return idCount++;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
