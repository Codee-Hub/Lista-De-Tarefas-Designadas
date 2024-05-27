package ucsal.codehub.lista_de_tarefas_designadas.model.services.iml;

import ucsal.codehub.lista_de_tarefas_designadas.model.entities.Person;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.PersonService;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.exceptions.PersonNotFound;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class PersonServiceIml implements PersonService<Person> {

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
            people.remove(people.stream().filter(person -> person.getId() == id).findFirst().orElseThrow(() -> new PersonNotFound("Person not found")));
        } catch (PersonNotFound e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePerson(Person newPerson) {
        try {
            people.stream().filter(person -> person.getId() == newPerson.getId()).findFirst().ifPresentOrElse(person -> updateData(person, newPerson), () -> { throw new PersonNotFound("Person not found"); });
        } catch (PersonNotFound e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void updateData(Person person, Person newPerson){
        person.setName(newPerson.getName());
    }

    @Override
    public Person getPersonById(int id) {
        try {
           return people.stream().filter(person -> person.getId() == id).findFirst().orElseThrow(() -> new PersonNotFound("Person not found"));
        } catch (PersonNotFound e) {
            e.printStackTrace();
            return null;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Person> getPersons() {
        try {
            if(people.isEmpty()) throw new PersonNotFound("Person not found");
            return people;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
