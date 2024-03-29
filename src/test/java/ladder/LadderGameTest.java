package ladder;

import ladder.core.LadderGame;
import ladder.core.LadderGameFactory;
import ladder.core.LadderSize;
import ladder.creator.CustomLadderCreator;
import ladder.creator.LadderCreator;
import ladder.position.LadderPosition;
import ladder.position.Position;
import ladder.utils.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);

        //when
        LadderCreator ladderCreator  = new CustomLadderCreator(ladderSize);

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderCreator ladderCreator  = new CustomLadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //when
        int nthOfPerson = 3;
        Position position = Position.of(nthOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderGame.run(position));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderCreator ladderCreator  = new CustomLadderCreator(ladderSize);

        ladderCreator.drawLine(LadderPosition.of(Position.of(0), Position.of(0)));
        ladderCreator.drawLine(LadderPosition.of(Position.of(1), Position.of(1)));
        ladderCreator.drawLine(LadderPosition.of(Position.of(2), Position.of(0)));

        LadderGame ladderGame = new LadderGame(ladderCreator);


        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        int resultPosition = ladderGame.run(position);
        //then
        assertEquals(2, resultPosition);

        //when
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);
        resultPosition = ladderGame.run(position);
        //then
        assertEquals(1, resultPosition);

        //when
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);
        resultPosition = ladderGame.run(position);
        //then
        assertEquals(0, resultPosition);

    }

    @Test
    void 랜덤_사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(5);
        NaturalNumber numberOfPerson = NaturalNumber.of(30);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);

        //when
        LadderGame ladderGame = LadderGameFactory.randomLaddergame(ladderSize);

        //then
        assertNotNull(ladderGame);
    }

    @Test
    void 랜덤_사다리_라인_생성_비율_확인() {
        //Given
        NaturalNumber numberOfRow = NaturalNumber.of(5);
        NaturalNumber numberOfPerson = NaturalNumber.of(30);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderGame ladderGame = LadderGameFactory.randomLaddergame(ladderSize);
        int totalLines = numberOfRow.getNum() * numberOfPerson.getNum();
        int expectedLines = (int) (totalLines * 0.3);
        int actualLines = 0;

        for(int i = 0; i < numberOfRow.getNum(); i++) {
            for(int j = 0; j < numberOfPerson.getNum(); j++) {
                if(ladderGame.isLineDrawn(i, j)) {
                    actualLines++;
                }
            }
        }

        //then
        assertEquals(expectedLines, actualLines);
    }
}