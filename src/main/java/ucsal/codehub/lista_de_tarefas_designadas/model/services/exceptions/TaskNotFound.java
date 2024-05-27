package ucsal.codehub.lista_de_tarefas_designadas.model.services.exceptions;

public class TaskNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TaskNotFound (String msg) {
        super(msg);
    }
}


