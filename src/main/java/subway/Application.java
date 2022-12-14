package subway;

import subway.controller.Controller;
import subway.utils.CommandType;
import subway.view.InputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        boolean isStop = false;

        while(!isStop) {
            CommandType command = scannerCommand();
            if (!controller.run(command)) {
                isStop = true;
            }
            System.out.println();
        }
    }

    public static CommandType scannerCommand() {
        InputView inputView = new InputView();
        while (true) {
            try {
                return CommandType.selectCommandTypeByCode(inputView.inputMainCommand());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }
}
