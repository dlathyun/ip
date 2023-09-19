package duke.command;

import duke.exception.KoraException;
import duke.storage.Storage;
import duke.task.Task;
import duke.list.TaskList;

public class DeleteCommand extends Command {
    private int taskIndex;
    private String commandMessage = "";
    public DeleteCommand(String[] details) {
        taskIndex = Integer.valueOf(details[0].replace("delete ", ""));
    }


    @Override
    public String getCommandMessage() {
        return commandMessage;
    }

    @Override
    public void execute(TaskList taskList, Storage storage) throws KoraException {
        Task currentTask = taskList.getTask(taskIndex);
        String taskDetails = currentTask.toString();
        taskList.removeTask(taskIndex);
        storage.saveTask(currentTask);
        commandMessage = "Okay. I have removed this task" + "\n"
                + taskDetails + "\n" + String.format("Now you have %d tasks!", taskList.getLength());
    }
}
