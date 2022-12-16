package subway.utils;

import java.util.Arrays;

public enum StationCommand {
    ADD_STATION("1", "역 등록"),
    DELETE_STATION("2", "역 삭제"),
    SEARCH_STATION("3", "역 조회"),
    GO_BACK("B", "돌아가기");

    private String code;
    private String description;

    StationCommand(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static StationCommand selectStationCommandByCode(String code) {
        return Arrays.stream(StationCommand.values())
                .filter(command -> command.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.COMMAND_NOT_VALID_OPTION.getDescription()));
    }
}
