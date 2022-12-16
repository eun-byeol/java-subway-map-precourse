package subway.utils;

public enum OutputMessage {
    STATION_ADD_SUCCESS("지하철 역이 등록되었습니다."),
    INFO_LIST(""),
    STATION_DELETE_SUCCESS("지하철 역이 삭제되었습니다."),
    LINE_ADD_SUCCESS("지하철 노선이 등록되었습니다."),
    LINE_DELETE_SUCCESS("지하철 노선이 삭제되었습니다."),
    SECTION_ADD_SUCCESS("구간이 등록되었습니다."),
    SECTION_DELETE_SUCCESS("구간이 삭제되었습니다."),
    INFO_DIVIDING_LINE("---");

    private String description;

    OutputMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return "\n[INFO] " + description;
    }
}
