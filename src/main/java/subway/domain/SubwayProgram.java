package subway.domain;

import subway.utils.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class SubwayProgram {

    public SubwayProgram() {
        initialStationRepository();
        initialLineRepository();
    }

    private void initialStationRepository() {
        List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String station : stationNames) {
            addStation(station);
        }
    }

    private void initialLineRepository() {
        addLine("2호선", "교대역", "역삼역");
        addLine("3호선", "교대역", "매봉역");
        addLine("신분당선", "강남역", "양재시민의숲역");
        addStationInLine("2호선", "강남역", "2");
        addStationInLine("3호선", "양재역", "2");
        addStationInLine("3호선", "남부터미널역", "2");
        addStationInLine("신분당선", "양재역", "2");
    }

    public void addStation(String name) {
        StationRepository.addStation(new Station(name));
    }

    public void deleteStation(String name) {
        if (!StationRepository.deleteStation(name)) {
            throw new IllegalArgumentException(ErrorMessage.NON_EXISTENT_STATION.getDescription());
        }
    }

    public void addLine(String LineName, String ascendingTerminusStation, String descendingTerminusStation) {
        Station ascendingStation = returnStation(ascendingTerminusStation);
        Station descendingStation = returnStation(descendingTerminusStation);
        Line newLine = new Line(
                LineName,
                ascendingStation,
                descendingStation
        );
        LineRepository.addLine(newLine);
        addStationIfNotExist(ascendingTerminusStation);
        addStationIfNotExist(descendingTerminusStation);
    }

    public Station returnStation(String stationName) {
        try {
            return StationRepository.select(stationName);
        } catch (IllegalArgumentException e) {
            return new Station(stationName);
        }
    }

    private void addStationIfNotExist(String name) {
        if (!StationRepository.isExistentStation(name)) {
            addStation(name);
        }
    }

    public void deleteLine(String name) {
        if (!LineRepository.deleteLineByName(name)) {
            throw new IllegalArgumentException(ErrorMessage.NON_EXISTENT_LINE.getDescription());
        }
    }

    public void addStationInLine(String lineName, String stationName, String positionName) {
        Line line = LineRepository.select(lineName);
        Station station = returnStation(stationName);
        Position position = new Position(positionName);

        if (line.contains(stationName)) {
            throw new IllegalArgumentException(ErrorMessage.EXISTENT_STATION_IN_LINE.getDescription());
        }
        line.addStationToPosition(station, position);
        addStationIfNotExist(stationName);
    }

    public void deleteStationInLine(String lineName, String stationName) {
        Line line = LineRepository.select(lineName);
        Station station = StationRepository.select(stationName);

        line.deleteStationInLine(station);
    }
}
