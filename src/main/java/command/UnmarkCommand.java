package command;

import task.Task;
import task.TaskList;

public class UnmarkCommand extends Command {

    String commandMessage = "";
    private int taskIndex;
    public UnmarkCommand(String[] details) {
        taskIndex = Integer.parseInt(details[0].replace("unmark ", ""));
    }

    @Override
    public String getCommandMessage() {

        return commandMessage;
    }

    @Override
    public void execute(TaskList taskList) {
        Task currentTask = taskList.getTask(taskIndex);
        currentTask.setUnmarked();
        commandMessage = "Wow you are not done!" + "\n" + currentTask.toString();
    }


}
