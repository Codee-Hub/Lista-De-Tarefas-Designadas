package ucsal.codehub.lista_de_tarefas_designadas;

import ucsal.codehub.lista_de_tarefas_designadas.model.entities.AssignedTask;
import ucsal.codehub.lista_de_tarefas_designadas.model.entities.Person;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.AssignedTaskFactory;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.AssignedTaskService;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.PersonServiceFactory;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.iml.AssignedTaskServiceIml;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.iml.PersonServiceIml;

public class Teste {
    public static void main(String[] args) {
        AssignedTaskServiceIml taskService = AssignedTaskFactory.createAssignedTask();
        PersonServiceIml personService = PersonServiceFactory.createPersonService();

        personService.addPerson(new Person("John"));
        personService.addPerson(new Person("Marta"));
        personService.addPerson(new Person("lucas"));
        personService.getPersons().forEach(System.out::println);

        taskService.addAssignedTask(new AssignedTask("lavar carro", personService.getPersonById(0)));
        taskService.addAssignedTask(new AssignedTask("lavar casa", personService.getPersonById(1)));
        taskService.addAssignedTask(new AssignedTask("comer", personService.getPersonById(1)));
        taskService.addAssignedTask(new AssignedTask("lavar praça", personService.getPersonById(2)));

        taskService.getAllAssignedTasks().forEach(System.out::println);
        System.out.println();
        taskService.updateAssignedTask(new AssignedTask("comer melancia", personService.getPersonById(2), 2));
        taskService.getAllAssignedTasks().forEach(System.out::println);
        System.out.println();
        taskService.deleteAssignedTaskById(0);
        taskService.getAllAssignedTasks().forEach(System.out::println);
        System.out.println();
        System.out.println(taskService.getAssignedTaskById(3));
        System.out.println();
        taskService.concludeAssignedTask(3);
        taskService.getPedingAssignedTasks().forEach(System.out::println);
        System.out.println();
        taskService.getAllAssignedTasks().forEach(System.out::println);
        System.out.println();





    }
}
