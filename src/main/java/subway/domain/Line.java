package subway.domain;

import subway.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Line {
    private String name;
    private LinkedList<Station> stations;
    private static final int MIN_LENGTH_OF_NAME = 2;

    public Line(String name, Station ascending, Station descending) {
        validateNameSize(name);
        validateDuplicateName(name);
        this.name = name;
        stations = new LinkedList<>(Arrays.asList(ascending, descending));
    }

    public String getName() {
        return name;
    }

    private void validateNameSize(String name) {
        if (name.length() < MIN_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(ErrorMessage.NAME_SIZE_OVER_TWO.getDescription());
        }
    }

    private void validateDuplicateName(String name) {
        if (LineRepository.isExistentLine(name)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getDescription());
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
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ErrorMessage.POSITION_IS_NOT_VALID_RANGE.getDescription());
        }
    }
}
