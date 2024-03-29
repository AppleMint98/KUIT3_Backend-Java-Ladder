package ladder.creator;

import ladder.core.LadderSize;
import ladder.core.Row;
import ladder.creator.utils.NumberGenerator;
import ladder.creator.utils.RandomNumberGenerator;
import ladder.position.LadderPosition;
import ladder.position.Position;

import java.util.HashSet;

public class RandomLadderCreator implements LadderCreator {

    private final LadderSize ladderSize;
    private final CustomLadderCreator ladderCreator;
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public RandomLadderCreator(CustomLadderCreator ladderCreator) {

        this.ladderCreator = ladderCreator;
        this.ladderSize = ladderCreator.getLadderSize();
        drawLines();
    }

    private void drawLines() {
        HashSet<Integer> numbers = new HashSet<>();

        while (numbers.size() < numberOfLine()) {
            addNumber(numbers);
        }
    }

    private int numberOfLine() {
        return (int) (ladderSize.getNumberOfNodes() * 0.3);
    }

    private void addNumber(HashSet<Integer> numbers) {
        int number = numberGenerator.getNumber(0, ladderSize.getNumberOfNodes() - 1);
        LadderPosition linePosition = numberToLadderPosition(number);

        if (ladderCreator.getRows()[linePosition.getRowPosition()].isDrawable(linePosition.getCol())) {
            numbers.add(number);
            ladderCreator.drawLine(linePosition);
        }
    }

    private LadderPosition numberToLadderPosition(int number) {
        Position row = Position.of(number / ladderSize.getWidth());
        Position col = Position.of(number % ladderSize.getWidth());

        return LadderPosition.of(row, col);
    }


    @Override
    public void drawLine(LadderPosition ladderPosition) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Row[] getRows() {
        return ladderCreator.getRows();
    }
}
