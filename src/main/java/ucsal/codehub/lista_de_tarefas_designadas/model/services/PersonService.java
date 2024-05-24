package ucsal.codehub.lista_de_tarefas_designadas.model.services;

import ucsal.codehub.lista_de_tarefas_designadas.model.entities.Person;

import java.util.List;

public interface PersonService {
    void addPerson(Person person);
    void removePerson(Person person);
    void updatePerson(Person person);
    Person getPersonById(int id);
    List<Person> getPersons();
}
