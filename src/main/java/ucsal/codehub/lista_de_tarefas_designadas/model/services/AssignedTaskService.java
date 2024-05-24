package ucsal.codehub.lista_de_tarefas_designadas.model.services;

import ucsal.codehub.lista_de_tarefas_designadas.model.entities.AssignedTask;

import java.util.List;

public interface AssignedTaskService {

    void addAssignedTask(AssignedTask assignedTask);
    void deleteAssignedTaskById(int id);
    void updateAssignedTask(AssignedTask assignedTask);
    AssignedTask getAssignedTaskById(int id);
    List<AssignedTask> getAllAssignedTasks();
    List<AssignedTask> getAssignedTasksByPersonId(int personId);
    List<AssignedTask> getPedingAssignedTasks();
}
