package subway.domain;

import subway.utils.ErrorMessage;

public class Station {
    private String name;
    private static final int MIN_LENGTH_OF_NAME = 2;

    public Station(String name) {
        validateNameSize(name);
        validateDuplicateName(name);
        this.name = name;
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
        if (StationRepository.isExistentStation(name)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getDescription());
        }
    }
}
