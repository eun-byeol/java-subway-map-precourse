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
}
