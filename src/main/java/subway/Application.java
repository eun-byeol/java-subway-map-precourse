package subway;

import subway.controller.Controller;
import subway.utils.CommandType;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        boolean isStop = false;

        while(!isStop) {
            CommandType command = scannerCommand();
            if (!controller.run(command)) {
                isStop = true;
            }
        }
    }

    public static CommandType scannerCommand() {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String command = scanner.next();
                return CommandType.selectCommandTypeByCode(command);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
