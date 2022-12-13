package subway.domain;

import subway.utils.ErrorMessage;

import java.util.List;

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
}
