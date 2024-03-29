package ladder.exception;

public enum ExceptionMessage {

    INVALID_LADDER_POSITION("사다리 위치는 0이상의 정수입니다."),
    INVALID_NUMBER_OF_PERSON("참여 인원은 2명 이상이어야 합니다."),
    INVALID_POSITION("유효하지 않은 위치입니다."),
    INVALID_DRAW_POSITION("사다리 라인을 그릴 수 없는 위치입니다."),
    INVALID_NATURAL_NUMBER("자연수가 아닙니다.");

    private final String message;


    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
