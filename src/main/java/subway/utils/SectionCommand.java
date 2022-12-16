package subway.utils;

import java.util.Arrays;

public enum SectionCommand {
    ADD_SECTION("1", "구간 등록"),
    DELETE_SECTION("2", "구간 삭제"),
    GO_BACK("B", "돌아가기");

    private String code;
    private String description;

    SectionCommand(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static SectionCommand selectSectionCommandByCode(String code) {
        return Arrays.stream(SectionCommand.values())
                .filter(command -> command.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.COMMAND_NOT_VALID_OPTION.getDescription()));
    }
}
