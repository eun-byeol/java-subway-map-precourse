package subway.domain;

import subway.utils.ErrorMessage;

import java.util.*;

public class StationRepository {
    private static LinkedList<Station> stations = new LinkedList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static boolean isExistentStation(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static Station select(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NON_EXISTENT_STATION.getDescription());
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        validateInLine(name);
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static void validateInLine(String name) {
        if (LineRepository.isInLine(name)) {
            throw new IllegalArgumentException(ErrorMessage.STATION_REGISTERED_IN_LINE.getDescription());
        }
    }
}
