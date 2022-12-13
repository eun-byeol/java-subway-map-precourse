package subway.domain;

import java.util.Arrays;
import java.util.List;

public class InitialSetting {
    public static void initialStationRepository() {
        List<String> stationNames = Arrays.asList("교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역");
        for (String name : stationNames) {
            StationRepository.addStation(new Station(name));
        }
    }
    public static void initialLineRepository() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }
}
