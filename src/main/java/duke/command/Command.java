package duke.command;

import duke.exception.KoraException;
import duke.list.CommandList;
import duke.storage.Storage;
import duke.list.TaskList;

/**
 * Command class executes and sets messages for different types of commands.
 */
public abstract class Command {
    private static String line = "------------------------------";

    /**
     * Class constructor of Command.
     */
    public Command() {
    }

    /**
     * Prints output of the command in nice format.
     * @param output Message after command is executed.
     */
    public void printOutput(String output) {
        System.out.println(line + "\n" + output + "\n" + line);
    }

    /**
     * Returns message for the command.
     * @return String message of command.
     */
    public abstract String getCommandMessage();

    /**
     * Executes the command according to the type of command.
     * @param taskList List with tasks.
     * @param storage Storage where tasks are stored.
     * @throws KoraException From its child class.
     */
    public abstract void execute(TaskList taskList, Storage storage) throws KoraException;

    /**
     * Returns false for all the commands except ByeCommand.
     * @return Boolean.
     */
    public boolean isExit() {
        return false;
    }
    public boolean isSetCommand() {
        return false;
    }

    public void executeSet(CommandList commandList, Storage storage) throws KoraException {
        return;
    }

    public boolean isFileCommand() {
        return false;
    }

    public String getFilePath() {
        return "";
    }
}
