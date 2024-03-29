package ladder.position;

import static ladder.exception.ExceptionMessage.INVALID_LADDER_POSITION;
import static ladder.exception.ExceptionMessage.INVALID_POSITION;
public class Position {

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public int getValue() {
        return position;
    }


    public Position prev() {
        return new Position(position - 1);
    }

    public Position next() {return new Position(position + 1); }

    private static void validatePosition(int position) {
        if (!isPosition(position)) {
            throw new IllegalArgumentException(INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }

    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Position that)) return false;

        return position == that.position;
    }
}
