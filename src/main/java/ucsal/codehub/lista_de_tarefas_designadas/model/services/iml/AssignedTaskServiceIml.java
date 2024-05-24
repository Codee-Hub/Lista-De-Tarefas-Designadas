package ucsal.codehub.lista_de_tarefas_designadas.model.services.iml;

import ucsal.codehub.lista_de_tarefas_designadas.model.entities.AssignedTask;
import ucsal.codehub.lista_de_tarefas_designadas.model.enums.AssignedTaskStatus;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.AssignedTaskService;

import java.util.List;
import java.util.stream.Collectors;

public class AssignedTaskServiceIml implements AssignedTaskService {

    List<AssignedTask> tasks;

    public AssignedTaskServiceIml() {}

    public AssignedTaskServiceIml(List<AssignedTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void addAssignedTask(AssignedTask assignedTask) {
    tasks.add(assignedTask);
    }

    @Override
    public void deleteAssignedTaskById(int id) {
    tasks = tasks.stream().filter(task -> task.getId() != id).collect(Collectors.toList());
    }

    @Override
    public void updateAssignedTask(AssignedTask assignedTask) {
    deleteAssignedTaskById(assignedTask.getId());
    addAssignedTask(assignedTask);
    }

    @Override
    public AssignedTask getAssignedTaskById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<AssignedTask> getAllAssignedTasks() {
        return tasks;
    }

    @Override
    public List<AssignedTask> getAssignedTasksByPersonId(int personId) {
        return tasks.stream().filter(task -> task.getPerson().getId() == personId).collect(Collectors.toList());
    }

    @Override
    public List<AssignedTask> getPedingAssignedTasks() {
        return tasks.stream().filter(task -> task.getStatus() == AssignedTaskStatus.PENDING).collect(Collectors.toList());
    }

    @Override
    public void concludeAssignedTask(int id) {
        tasks.stream().filter(task -> task.getId() == id).findFirst().ifPresent(task -> task.setStatus(AssignedTaskStatus.CONCLUDED));
    }
}
