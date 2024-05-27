package ucsal.codehub.lista_de_tarefas_designadas.model.services;

import ucsal.codehub.lista_de_tarefas_designadas.model.entities.Person;

import java.util.List;

public interface PersonService {
    void addPerson(Person person);
    void removePersonById(int id);
    void updatePerson(Person person);
    Person getPersonById(int id);
    List<Person> getPersons();
    void updateData(Person person, Person newPerson);
}
