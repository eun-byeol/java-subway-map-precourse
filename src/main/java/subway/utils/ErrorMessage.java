package subway.utils;

public enum ErrorMessage {
    DUPLICATE_NAME("중복된 이름이 존재합니다."),
    NAME_SIZE_OVER_TWO("이름은 2글자 이상이어야 합니다."),
    NON_EXISTENT_STATION("등록되지 않은 역입니다."),
    STATION_REGISTERED_IN_LINE("노선에 등록된 역은 삭제할 수 없습니다.");

    private String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return "[ERROR] " + description;
    }
}