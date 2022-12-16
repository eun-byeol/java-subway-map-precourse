package subway.view;

import subway.domain.Line;
import subway.domain.Station;
import subway.utils.OutputMessage;
import subway.utils.ViewMessage;

import java.util.List;

public class OutputView {
    public void printStationList(List<Station> stations) {
        System.out.print(ViewMessage.STATION_LIST.getDescription());
        for (Station station : stations) {
            System.out.print(OutputMessage.INFO_LIST.getDescription() + station.getName());
        }
        System.out.println();
    }

    public void printLineList(List<Line> Lines) {
        System.out.print(ViewMessage.LINE_LIST.getDescription());
        for (Line line : Lines) {
            System.out.print(OutputMessage.INFO_LIST.getDescription() + line.getName());
        }
        System.out.println();
    }

    public void printSubwayMap(List<Line> Lines) {
        System.out.print(ViewMessage.SUBWAY_MAP.getDescription());
        for (Line line : Lines) {
            System.out.print(OutputMessage.INFO_LIST.getDescription() + line.getName());
            System.out.print(OutputMessage.INFO_DIVIDING_LINE.getDescription());
            for (Station station : line.getStations()) {
                System.out.print(OutputMessage.INFO_LIST.getDescription() + station.getName());
            }
            System.out.println();
        }
        if (Lines.isEmpty()) {
            System.out.println();
        }
    }
}
