package subway.controller;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.SubwayProgram;
import subway.utils.*;
import subway.view.InputView;
import subway.view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    SubwayProgram subwayProgram = new SubwayProgram();
    public boolean run(CommandType command) {
        if (CommandType.STATION_MANAGEMENT.equals(command)) {
            manageStation();
            return true;
        }
        if (CommandType.LINE_MANAGEMENT.equals(command)) {
            manageLine();
            return true;
        }
        if (CommandType.SECTION_MANAGEMENT.equals(command)) {
            manageSection();
            return true;
        }
        if (CommandType.PRINT_MAP.equals(command)) {
            outputView.printSubwayMap(LineRepository.lines());
            return true;
        }
        return false;
    }

    public StationCommand inputStationCommand() {
        while (true) {
            try {
                return StationCommand.selectStationCommandByCode(inputView.inputStationCommand());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void manageStation() {
        StationCommand stationCommand = inputStationCommand();
        if (StationCommand.ADD_STATION.equals(stationCommand)) {
            inputStationToRegister();
            System.out.println(OutputMessage.STATION_ADD_SUCCESS.getDescription());
            return;
        }
        if (StationCommand.DELETE_STATION.equals(stationCommand)) {
            inputStationToDelete();
            System.out.println(OutputMessage.STATION_DELETE_SUCCESS.getDescription());
            return;
        }
        if (StationCommand.SEARCH_STATION.equals(stationCommand)) {
            outputView.printStationList(StationRepository.stations());
        }
    }

    public void inputStationToRegister() {
        while (true) {
            try {
                subwayProgram.addStation(inputView.inputStationToRegister());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputStationToDelete() {
        while (true) {
            try {
                subwayProgram.deleteStation(inputView.inputStationToDelete());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public LineCommand inputLineCommand() {
        while (true) {
            try {
                return LineCommand.selectLineCommandByCode(inputView.inputLineCommand());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void manageLine() {
        LineCommand lineCommand = inputLineCommand();
        if (LineCommand.ADD_LINE.equals(lineCommand)) {
            inputLineToRegister();
            System.out.println(OutputMessage.LINE_ADD_SUCCESS.getDescription());
            return;
        }
        if (LineCommand.DELETE_LINE.equals(lineCommand)) {
            inputLineToDelete();
            System.out.println(OutputMessage.LINE_DELETE_SUCCESS.getDescription());
            return;
        }
        if (LineCommand.SEARCH_LINE.equals(lineCommand)) {
            outputView.printLineList(LineRepository.lines());
        }
    }

    public void inputLineToRegister() {
        while (true) {
            try {
                String line = inputView.inputLineToRegister();
                String ascending = inputView.inputAscendingStation();
                String descending = inputView.inputDescendingStation();
                subwayProgram.addLine(line, ascending, descending);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputLineToDelete() {
        while (true) {
            try {
                subwayProgram.deleteLine(inputView.inputLineToDelete());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public SectionCommand inputSectionCommand() {
        while (true) {
            try {
                return SectionCommand.selectSectionCommandByCode(inputView.inputSectionCommand());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void manageSection() {
        SectionCommand sectionCommand = inputSectionCommand();
        if (SectionCommand.ADD_SECTION.equals(sectionCommand)) {
            inputSectionToRegister();
            System.out.println(OutputMessage.SECTION_ADD_SUCCESS.getDescription());
            return;
        }
        if (SectionCommand.DELETE_SECTION.equals(sectionCommand)) {
            inputSectionToDelete();
            System.out.println(OutputMessage.SECTION_DELETE_SUCCESS.getDescription());
        }
    }

    public void inputSectionToRegister() {
        while (true) {
            try {
                String line = inputView.inputLineToRegisterSection();
                String station = inputView.inputStationToRegisterSection();
                String order = inputView.inputOrderToRegisterSection();
                subwayProgram.addStationInLine(line, station, order);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputSectionToDelete() {
        while (true) {
            try {
                String line = inputView.inputLineToDeleteSection();
                String station = inputView.inputStationToDeleteSection();
                subwayProgram.deleteStationInLine(line, station);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
