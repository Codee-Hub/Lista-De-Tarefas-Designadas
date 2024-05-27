package ucsal.codehub.lista_de_tarefas_designadas.model.services.iml;

import ucsal.codehub.lista_de_tarefas_designadas.model.entities.AssignedTask;
import ucsal.codehub.lista_de_tarefas_designadas.model.enums.AssignedTaskStatus;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.AssignedTaskService;
import ucsal.codehub.lista_de_tarefas_designadas.model.services.exceptions.TaskNotFound;

import java.util.List;
import java.util.stream.Collectors;

public class AssignedTaskServiceIml implements AssignedTaskService<AssignedTask> {

    List<AssignedTask> tasks;

    public AssignedTaskServiceIml() {}

    public AssignedTaskServiceIml(List<AssignedTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void addAssignedTask(AssignedTask assignedTask) {
        try {
            tasks.add(assignedTask);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAssignedTaskById(int id) {
        try {
            tasks.remove(tasks.stream().filter(task -> task.getId() == id).findFirst().orElseThrow(() -> new TaskNotFound("Task not found")));
        } catch (TaskNotFound e){
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAssignedTask(AssignedTask assignedTask) {
        try {
            tasks.stream().filter(task -> task.getId() == assignedTask.getId()).findFirst().ifPresentOrElse(task -> updateTask(task,assignedTask), () -> {throw new TaskNotFound("Task not found");});
        } catch (TaskNotFound e){
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTask(AssignedTask task, AssignedTask newTask) {
        task.setName(newTask.getName());
        task.setPerson(newTask.getPerson());
    }

    @Override
    public AssignedTask getAssignedTaskById(int id) {
        try {
            return tasks.stream().filter(task -> task.getId() == id).findFirst().orElseThrow(() -> new TaskNotFound("Task not found"));
        } catch (TaskNotFound e){
            e.printStackTrace();
            return null;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AssignedTask> getAllAssignedTasks() {
        try {
            if(tasks.isEmpty()) throw new TaskNotFound("Task not found");
            return tasks;
        } catch (TaskNotFound e){
            e.printStackTrace();
            return null;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AssignedTask> getAssignedTasksByPersonId(int personId) {
        try {
            return tasks.stream().filter(task -> task.getPerson().getId() == personId).collect(Collectors.toList());
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AssignedTask> getPedingAssignedTasks() {
        try {
            return tasks.stream().filter(task -> task.getStatus() == AssignedTaskStatus.PENDING).collect(Collectors.toList());
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void concludeAssignedTask(int id) {
        try {
            tasks.stream().filter(task -> task.getId() == id).findFirst().ifPresentOrElse(task -> task.setStatus(AssignedTaskStatus.CONCLUDED), () -> {throw new TaskNotFound("Task not found");});
        } catch (TaskNotFound e){
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
