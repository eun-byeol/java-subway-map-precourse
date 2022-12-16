package subway.utils;

public enum ViewMessage {
    MAIN_COMMAND_SCREEN("## 메인 화면\n" +
            "1. 역 관리\n" +
            "2. 노선 관리\n" +
            "3. 구간 관리\n" +
            "4. 지하철 노선도 출력\n" +
            "Q. 종료"),
    INPUT_DETAILED_COMMAND("\n## 원하는 기능을 선택하세요."),
    STATION_COMMAND_SCREEN("\n## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기"),
    INPUT_STATION_TO_REGISTER("\n## 등록할 역 이름을 입력하세요."),
    STATION_LIST("\n## 역 목록"),
    INPUT_STATION_TO_DELETE("\n## 삭제할 역 이름을 입력하세요."),
    LINE_COMMAND_SCREEN("\n## 노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기"),
    INPUT_LINE_TO_REGISTER("\n## 등록할 노선 이름을 입력하세요."),
    INPUT_ASCENDING_STATION("\n## 등록할 노선의 상행 종점역 이름을 입력하세요."),
    INPUT_DESCENDING_STATION("\n## 등록할 노선의 하행 종점역 이름을 입력하세요."),
    INPUT_LINE_TO_DELETE("\n## 삭제할 노선 이름을 입력하세요."),
    LINE_LIST("\n## 노선 목록"),
    SECTION_COMMAND_SCREEN("\n## 구간 관리 화면\n" +
            "1. 구간 등록\n" +
            "2. 구간 삭제\n" +
            "B. 돌아가기"),
    INPUT_LINE_TO_REGISTER_SECTION("\n## 노선을 입력하세요."),
    INPUT_STATION_TO_REGISTER_SECTION("\n## 역이름을 입력하세요."),
    INPUT_ORDER_TO_REGISTER_SECTION("\n## 순서를 입력하세요."),
    INPUT_LINE_TO_DELETE_SECTION("\n## 삭제할 구간의 노선을 입력하세요."),
    INPUT_STATION_TO_DELETE_SECTION("\n## 삭제할 구간의 역을 입력하세요."),
    SUBWAY_MAP("\n## 지하철 노선도");

    private String description;

    ViewMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
