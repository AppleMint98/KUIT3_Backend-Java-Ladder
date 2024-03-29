package ladder.core;
import ladder.position.LadderPosition;
import ladder.utils.NaturalNumber;
import ladder.position.Position;

import static ladder.exception.ExceptionMessage.*;
public class Row {
    private Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.getNum()];
        for(int i = 0; i < numberOfPerson.getNum(); i++) {
            nodes[i] = Node.of(Direction.NONE);
        }
    }

    public void drawLine(Position lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);

        setDirectionAtPosition(lineStartPosition, Direction.RIGHT);
        setDirectionAtPosition(lineStartPosition.next(), Direction.LEFT);
    }

    public Position nextPosition(Position currentPosition) {

        validatePosition(currentPosition);
        Position nextPosition = nodes[currentPosition.getValue()].move(currentPosition);
        validatePosition(nextPosition);
        return nextPosition;

    }

    private void setDirectionAtPosition(Position position, Direction direction) {
        nodes[position.getValue()] = Node.of(direction);
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        if(isInvalidDrawPosition(lineStartPosition)
                || isDuplicatedDrawPosition(lineStartPosition)) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isDuplicatedDrawPosition(Position lineStartPosition) {

        return (nodes[lineStartPosition.getValue()].isRight()
                || nodes[lineStartPosition.next().getValue()].isRight()
                || nodes[lineStartPosition.getValue()].isLeft());
    }

    public boolean isDrawable(Position position) {
        return !isInvalidDrawPosition(position) && !isDuplicatedDrawPosition(position);
    }

    public boolean isLineDrawn(int j) {
        return nodes[j].isRight();
    }

    private void validatePosition(Position position) {
        if(isInvalidPosition(position)) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    private boolean isInvalidDrawPosition(Position lineStartPosition) {
        return lineStartPosition.isBiggerThan(nodes.length - 2) || lineStartPosition.isSmallerThan(0);
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1) || position.isSmallerThan(0);
    }


    public void generateRow(StringBuilder sb, Position drawingRow, LadderPosition currentPosition) {
        for(int i = 0; i < nodes.length; i++) {
            nodes[i].appendSymbol(sb);
            if(currentPosition.equals(LadderPosition.of(drawingRow, Position.of(i)))) {
                sb.append("*");
            }
            sb.append(" ");
        }
        sb.append("\n");
    }
}

