package subway.domain;

import subway.utils.ErrorMessage;

public class Position {
    private final int position;

    public Position(String position) {
        int number = validateInteger(position);
        validatePositiveNumber(number);
        this.position = number;
    }

    private int validateInteger(String position) {
        try {
            return Integer.parseInt(position);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.POSITION_NOT_INTEGER.getDescription());
        }
    }

    private void validatePositiveNumber(int position) {
        if (position < 1) {
            throw new IllegalArgumentException(ErrorMessage.POSITION_HAS_TO_POSITIVE_NUMBER.getDescription());
        }
    }

    public int getPosition() {
        return position;
    }
}
