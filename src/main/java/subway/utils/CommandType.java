package subway.utils;

import java.util.Arrays;

public enum CommandType {
    STATION_MANAGEMENT("1", "역 관리"),
    LINE_MANAGEMENT("2", "노선 관리"),
    SECTION_MANAGEMENT("3", "구간 관리"),
    PRINT_MAP("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");

    private String code;
    private String description;

    CommandType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static CommandType selectCommandTypeByCode(String code) {
        return Arrays.stream(CommandType.values())
                .filter(command -> command.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.COMMAND_NOT_VALID_OPTION.getDescription()));
    }
}
