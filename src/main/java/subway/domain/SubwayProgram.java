package subway.domain;

public class SubwayProgram {

    public SubwayProgram() {
        InitialSetting.initialStationRepository();
        InitialSetting.initialLineRepository();
    }

    public void addStation(String name) {
        StationRepository.addStation(new Station(name));
    }
}
