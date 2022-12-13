package subway.utils;

public enum ErrorMessage {
    DUPLICATE_NAME("중복된 이름이 존재합니다."),
    NAME_SIZE_OVER_TWO("이름은 2글자 이상이어야 합니다."),
    NON_EXISTENT_STATION("등록되지 않은 역입니다."),
    STATION_REGISTERED_IN_LINE("노선에 등록된 역은 삭제할 수 없습니다."),
    NON_EXISTENT_LINE("등록되지 않은 노선입니다."),
    EXISTENT_STATION_IN_LINE("이미 등록된 구간입니다."),
    POSITION_NOT_INTEGER("순서는 정수여야 합니다."),
    POSITION_HAS_TO_POSITIVE_NUMBER("순서는 1보다 작을 수 없습니다."),
    POSITION_IS_NOT_VALID_RANGE("순서는 해당 노선의 크기 + 1보다 클 수 없습니다.");

    private String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return "[ERROR] " + description;
    }
}
