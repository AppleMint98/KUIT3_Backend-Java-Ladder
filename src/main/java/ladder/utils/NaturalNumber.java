package ladder.utils;
import static ladder.exception.ExceptionMessage.*;
public class NaturalNumber  {

    private final int num;

    private NaturalNumber(int num) {
        validate(num);
        this.num = num;
    }
    public static NaturalNumber of(int num) {
        return new NaturalNumber(num);
    }

    public int getNum() {
        return num;
    }

    private void validate(int num) {
        if (!isNaturalNumber(num)) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER.getMessage());
        }
    }
    private boolean isNaturalNumber(int num) {
        return num >= 1;
    }
}
