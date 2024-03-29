package ladder;

import ladder.position.LadderPosition;
import ladder.position.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderPositionTest {

    @Test
    void 위치_가져오기() {
        LadderPosition ladderPosition = LadderPosition.of(Position.of(0), Position.of(0));
        assertEquals(0, ladderPosition.getColPosition());
        assertEquals(0, ladderPosition.getRowPosition());
        assertEquals(Position.of(0), ladderPosition.getRow());
        assertEquals(Position.of(0), ladderPosition.getCol());
    }

}