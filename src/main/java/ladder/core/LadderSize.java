package ladder.core;

import ladder.utils.NaturalNumber;

public class LadderSize {
    private final NaturalNumber height;
    private final NaturalNumber width;

    public LadderSize(NaturalNumber height, NaturalNumber width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height.getNum();
    }

    public int getWidth() {
        return width.getNum();
    }
    public static LadderSize of(NaturalNumber height, NaturalNumber width) {
        return new LadderSize(height, width);
    }
    public int getNumberOfNodes() {
        return height.getNum() * width.getNum();
    }
}
