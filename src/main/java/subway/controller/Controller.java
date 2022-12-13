package subway.controller;

import subway.utils.CommandType;

public class Controller {
    public boolean run(CommandType command) {
        if (CommandType.STATION_MANAGEMENT.equals(command)) {

        }
        if (CommandType.LINE_MANAGEMENT.equals(command)) {

        }
        if (CommandType.SECTION_MANAGEMENT.equals(command)) {

        }
        if (CommandType.PRINT_MAP.equals(command)) {

        }
        if (CommandType.QUIT.equals(command)) {
            return false;
        }
        return true;
    }
}
