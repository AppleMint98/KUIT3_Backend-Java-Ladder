package ladder.core;

import ladder.position.Position;

public class Node {
    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public static Node of(Direction direction){
        return new Node(direction);
    }

    // move 메서드
    public Position move(Position position) {
        if (isRight()) {
            return position.next();
        }
        if (isLeft()) {
            return position.prev();
        }
        return position;
    }

    public int getDirectionValue() {
        return direction.getValue();
    }

    public boolean isRight() {
        return direction == Direction.RIGHT;
    }

    public boolean isLeft() {
        return direction == Direction.LEFT;
    }

    public void appendSymbol(StringBuilder sb) {
        sb.append(this.direction.getValue());
    }
}
