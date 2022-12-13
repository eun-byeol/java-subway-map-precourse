package subway.domain;

import subway.utils.ErrorMessage;

public class SubwayProgram {

    public SubwayProgram() {
        InitialSetting.initialStationRepository();
        InitialSetting.initialLineRepository();
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
        Line newLine = new Line(
                LineName,
                new Station(ascendingTerminusStation),
                new Station(descendingTerminusStation)
        );
        LineRepository.addLine(newLine);
        addStationIfNotExist(ascendingTerminusStation);
        addStationIfNotExist(descendingTerminusStation);
    }

    private void addStationIfNotExist(String name) {
        if (StationRepository.isExistentStation(name)) {
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
        Station station = new Station(stationName);
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
