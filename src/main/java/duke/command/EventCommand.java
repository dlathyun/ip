package duke.command;

import duke.exception.KoraException;
import duke.list.TaskList;
import duke.storage.Storage;
import duke.task.Event;
import duke.task.Task;

/**
 * Subclass of Command class. Creates event task and executes it.
 */
public class EventCommand extends Command {
    private final String taskDetails;
    private final String startTimeDetails;
    private final String endTimeDetails;
    private Task currentTask;
    private String commandMessage = "";


    public EventCommand(String[] details) throws KoraException {
        if (details.length != 3) {
            throw new KoraException("Event needs to have a due date!");
        }
        taskDetails = details[0].replace("event ", "");
        String startTime = details[1].replace("from ", "");
        String endTime = details[2].replace("to ", "");
        //timeDetails = "from: " + startTime + "to: " + endTime;
        startTimeDetails = startTime;
        endTimeDetails = endTime;
    }

    @Override
    public String getCommandMessage() {
        return commandMessage;
    }

    @Override
    public void execute(TaskList taskList, Storage storage) throws KoraException {
        currentTask = new Event(taskDetails, startTimeDetails, endTimeDetails);
        taskList.addTask(currentTask);
        storage.saveTask(currentTask);
        commandMessage = "Okay! I have added this task" + "\n"
                + currentTask.toString() + "\n"
                + String.format("Now you have %d tasks!", taskList.getLength());
    }
}
