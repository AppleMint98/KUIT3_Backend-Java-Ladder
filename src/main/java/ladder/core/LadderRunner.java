package ladder.core;

import ladder.position.LadderPosition;
import ladder.position.Position;

public class LadderRunner {
    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for(int i = 0; i < rows.length; i++) {
            printLadder(LadderPosition.of(Position.of(i), position), "Before");
            position = rows[i].nextPosition(position);
            printLadder(LadderPosition.of(Position.of(i), position), "After");
        }
        return position.getValue();
    }

    public void printLadder(LadderPosition currentPosition, String label) {
        System.out.println(label);
        String ladder = generate(currentPosition);
        System.out.println(ladder);
    }

    public String generate(LadderPosition currentPosition) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            rows[i].generateRow(sb, Position.of(i), currentPosition);
        }
        return sb.toString();
    }
}
