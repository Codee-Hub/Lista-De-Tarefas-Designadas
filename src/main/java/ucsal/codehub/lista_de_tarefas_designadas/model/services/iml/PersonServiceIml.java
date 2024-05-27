package ucsal.codehub.lista_de_tarefas_designadas.model.services.iml;

import ucsal.codehub.lista_de_tarefas_designadas.model.entities.Person;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.PersonService;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.exceptions.PersonNotFound;

import java.util.InputMismatchException;
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
        try {
            people.add(person);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removePersonById(int id) {
        try {
            if(people.stream().filter(person -> person.getId() == id).findFirst().orElse(null) != null){
                people = people.stream().filter(person -> person.getId() != id).collect(Collectors.toList());
            }else {
                throw new PersonNotFound("Person not found");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePerson(Person newPerson) {
        try {
            if(people.stream().filter(person -> person.getId() == newPerson.getId()).findFirst().orElse(null) != null){
                people.stream().filter(person -> person.getId() == newPerson.getId()).findFirst().ifPresent(person -> updateData(person, newPerson));
            }else {
                throw new PersonNotFound("Person not found");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData(Person person, Person newPerson){
        person.setName(newPerson.getName());
    }

    @Override
    public Person getPersonById(int id) {
        try {
            if(people.stream().filter(person -> person.getId() == id).findFirst().orElse(null) != null){
                return people.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
            }else {
                throw new PersonNotFound("Person not found");
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Person> getPersons() {
        try {
            return people;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
