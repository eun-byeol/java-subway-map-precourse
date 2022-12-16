package subway.domain;

import subway.utils.ErrorMessage;

import java.util.*;

public class LineRepository {
    private static List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static boolean isExistentLine(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInLine(String stationName) {
        for (Line line : lines) {
            if (line.contains(stationName)) {
                return true;
            }
        }
        return false;
    }

    public static Line select(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NON_EXISTENT_LINE.getDescription());
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }


}
