package ucsal.codehub.lista_de_tarefas_designadas.model.services;

import ucsal.codehub.lista_de_tarefas_designadas.model.entities.Person;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.iml.PersonServiceIml;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceFactory {

    public static PersonServiceIml createPersonService() {
        List<Person> people =  new ArrayList<Person>();
        return new PersonServiceIml(people);
    }


}
