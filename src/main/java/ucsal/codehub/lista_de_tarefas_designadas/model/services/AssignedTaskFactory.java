package ucsal.codehub.lista_de_tarefas_designadas.model.services;

import ucsal.codehub.lista_de_tarefas_designadas.model.entities.AssignedTask;

import java.util.ArrayList;
import java.util.List;

public class AssignedTaskFactory {

    public static AssignedTaskServiceIml createAssignedTask() {
        List<AssignedTask> tasks = new ArrayList<AssignedTask>();
        AssignedTaskServiceIml assignedTask = new AssignedTaskIml(tasks);
    }
}
