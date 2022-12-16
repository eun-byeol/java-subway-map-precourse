package subway.view;

import subway.utils.ViewMessage;

import java.util.Scanner;

public class InputView {
    final Scanner scanner = new Scanner(System.in);

    public String inputMainCommand() {
        System.out.println(ViewMessage.MAIN_COMMAND_SCREEN.getDescription());
        return inputDetailedCommand();
    }

    public String inputDetailedCommand() {
        System.out.println(ViewMessage.INPUT_DETAILED_COMMAND.getDescription());
        return scanner.next();
    }

    public String inputStationCommand() {
        System.out.println(ViewMessage.STATION_COMMAND_SCREEN.getDescription());
        return inputDetailedCommand();
    }

    public String inputStationToRegister() {
        System.out.println(ViewMessage.INPUT_STATION_TO_REGISTER.getDescription());
        return scanner.next();
    }

    public String inputStationToDelete() {
        System.out.println(ViewMessage.INPUT_STATION_TO_DELETE.getDescription());
        return scanner.next();
    }

    public String inputLineCommand() {
        System.out.println(ViewMessage.LINE_COMMAND_SCREEN.getDescription());
        return inputDetailedCommand();
    }

    public String inputLineToRegister() {
        System.out.println(ViewMessage.INPUT_LINE_TO_REGISTER.getDescription());
        return scanner.next();
    }

    public String inputAscendingStation() {
        System.out.println(ViewMessage.INPUT_ASCENDING_STATION.getDescription());
        return scanner.next();
    }

    public String inputDescendingStation() {
        System.out.println(ViewMessage.INPUT_DESCENDING_STATION.getDescription());
        return scanner.next();
    }

    public String inputLineToDelete() {
        System.out.println(ViewMessage.INPUT_LINE_TO_DELETE.getDescription());
        return scanner.next();
    }

    public String inputSectionCommand() {
        System.out.println(ViewMessage.SECTION_COMMAND_SCREEN.getDescription());
        return inputDetailedCommand();
    }

    public String inputLineToRegisterSection() {
        System.out.println(ViewMessage.INPUT_LINE_TO_REGISTER_SECTION.getDescription());
        return scanner.next();
    }

    public String inputStationToRegisterSection() {
        System.out.println(ViewMessage.INPUT_STATION_TO_REGISTER_SECTION.getDescription());
        return scanner.next();
    }

    public String inputOrderToRegisterSection() {
        System.out.println(ViewMessage.INPUT_ORDER_TO_REGISTER_SECTION.getDescription());
        return scanner.next();
    }

    public String inputLineToDeleteSection() {
        System.out.println(ViewMessage.INPUT_LINE_TO_DELETE_SECTION.getDescription());
        return scanner.next();
    }

    public String inputStationToDeleteSection() {
        System.out.println(ViewMessage.INPUT_STATION_TO_DELETE_SECTION.getDescription());
        return scanner.next();
    }
}
