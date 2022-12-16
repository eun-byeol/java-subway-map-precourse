package subway.domain;

import subway.utils.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    private LinkedList<Station> stations;
    private static final int MIN_LENGTH_OF_NAME = 2;
    private static final int MIN_LENGTH_OF_SIZE = 2;

    public Line(String name, Station ascending, Station descending) {
        validateNameSize(name);
        validateDuplicateName(name);
        this.name = name;
        stations = new LinkedList<>(Arrays.asList(ascending, descending));
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    private void validateNameSize(String name) {
        if (name.length() < MIN_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(ErrorMessage.NAME_SIZE_OVER_TWO.getDescription());
        }
    }

    private void validateDuplicateName(String name) {
        if (LineRepository.isExistentLine(name)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LINE_NAME.getDescription());
        }
    }

    public boolean contains(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addStationToPosition(Station station, Position position) {
        try {
            stations.add(position.getPosition() - 1, station);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ErrorMessage.POSITION_IS_NOT_VALID_RANGE.getDescription());
        }
    }

    public void deleteStationInLine(Station station) {
        validateLineSize();
        if (!stations.remove(station)) {
            throw new IllegalArgumentException(ErrorMessage.NON_EXISTENT_STATION_IN_LINE.getDescription());
        }
    }

    private void validateLineSize() {
        if (stations.size() <= MIN_LENGTH_OF_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LINE_SIZE_HAS_TO_OVER_TWO.getDescription());
        }
    }
}
