package duke.parser;

import duke.command.*;

import duke.exception.KoraException;
import duke.list.CommandList;

/**
 * Parser class process user input and generates command.
 */
public class Parser {

    private CommandList commandList;
    /**
     * Class constructor of Parser.
     */
    public Parser(CommandList commandList) {
        this.commandList = commandList;
    }

    /**
     * Processes user input and returns a command based on data processed.
     * @param userInput String input from user.
     * @return Command to be executed.
     * @throws KoraException For invalid input.
     */
    public Command parse(String userInput) throws KoraException {
        assert !userInput.equals("") : "Input should not be empty.";
        String[] userInputArray = userInput.split("/");
        String commandType = getCommandType(userInputArray[0].split(" ")[0]);
        Command command;
        try {
            switch (commandType) {
                case "bye":
                    command = new ByeCommand();
                    break;
                case "list":
                    command = new ListCommand();
                    break;
                case "unmark":
                    command = new UnmarkCommand(userInputArray);
                    break;
                case "mark":
                    command = new MarkCommand(userInputArray);
                    break;
                case "deadline":
                    command = new DeadlineCommand(userInputArray);
                    break;
                case "event":
                    command = new EventCommand(userInputArray);
                    break;
                case "todo":
                    command = new ToDoCommand(userInputArray);
                    break;
                case "delete":
                    command = new DeleteCommand(userInputArray);
                    break;
                case "find":
                    command = new FindCommand(userInputArray);
                    break;
                case "set":
                    command = new SetCommand(userInput);
                    break;
                case "unset":
                    command = new UnsetCommand(userInput);
                    break;
                case "load":
                    command = new LoadFileCommand(userInput);
                    break;
                case "change":
                    command = new ChangeFileCommand(userInput);
                    break;
                default:
                    command = new InvalidCommand();
            }
        } catch (Exception e) {
            //throw new KoraException("Please give a valid command!");
            command = new InvalidCommand();
        }
        return command;
    }

    private String getCommandType(String input) {
        return commandList.getCommandType(input);
    }
}
