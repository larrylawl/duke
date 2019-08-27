import duke.ui.UI;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.parser.Parser;
import duke.commands.Command;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Duke {
    private TaskList tasks;
    private UI ui;
    private Storage storage;

    public Duke(String filePath) {
        ui = new UI();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (FileNotFoundException | ParseException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Driver method.
     */
    public void run() {
        Command command;
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        ui.showWelcomeMessage();

        while (!exit) {
            try {
                command = Parser.parse(sc.nextLine());
                command.execute(tasks, ui, storage);
                exit = command.isExit();
            } catch (Exception e) {
                ui.showMessage(e.getMessage());
            }
        }
        sc.close();
    }

    /**
     * Main method.
     */
    public static void main(String[] args) {
//        Duke d = new Duke();
        new Duke("../data/duke.txt").run();
    }
}
