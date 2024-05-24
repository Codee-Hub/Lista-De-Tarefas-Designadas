package ucsal.codehub.lista_de_tarefas_designadas.model.services.iml;

import ucsal.codehub.lista_de_tarefas_designadas.model.entities.Person;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.PersonService;

import java.util.List;
import java.util.stream.Collectors;

public class PersonServiceIml implements PersonService {

    List<Person> people;

    public PersonServiceIml() {}

    public PersonServiceIml(List<Person> people) {
        this.people = people;
    }

    @Override
    public void addPerson(Person person) {
        people.add(person);
    }

    @Override
    public void removePersonById(int id) {
        people = people.stream().filter(person -> person.getId() != id).collect(Collectors.toList());
    }

    @Override
    public void updatePerson(Person person) {
    removePersonById(person.getId());
    addPerson(person);
    }

    @Override
    public Person getPersonById(int id) {
        return people.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Person> getPersons() {
        return people;
    }
}
