package ladder.creator;

import ladder.core.LadderSize;
import ladder.core.Row;
import ladder.position.LadderPosition;
import ladder.utils.NaturalNumber;

public class CustomLadderCreator implements LadderCreator{

    private final Row[] rows;
    private final LadderSize ladderSize;

    public CustomLadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
        rows = new Row[ladderSize.getHeight()];
        for (int i = 0; i < ladderSize.getHeight(); i++) {
            rows[i] = new Row(NaturalNumber.of(ladderSize.getWidth()));
        }
    }

    public LadderSize getLadderSize() {
        return ladderSize;
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {
        rows[ladderPosition.getRowPosition()].drawLine(ladderPosition.getCol());
    }

}
