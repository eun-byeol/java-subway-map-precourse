package subway.utils;

import java.util.Arrays;

public enum LineCommand {
    ADD_LINE("1", "노선 등록"),
    DELETE_LINE("2", "노선 삭제"),
    SEARCH_LINE("3", "노선 조회"),
    GO_BACK("B", "돌아가기");

    private String code;
    private String description;

    LineCommand(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static LineCommand selectLineCommandByCode(String code) {
        return Arrays.stream(LineCommand.values())
                .filter(command -> command.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.COMMAND_NOT_VALID_OPTION.getDescription()));
    }
}
