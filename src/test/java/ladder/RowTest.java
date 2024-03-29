package ladder;

import ladder.core.Row;
import ladder.position.LadderPosition;
import ladder.position.Position;
import ladder.utils.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void 참여자_한_명_사다리_이동() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(1);
        Row row = new Row(numberOfPerson);

        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);


        //then
        assertEquals(0,row.nextPosition(position).getValue());
    }

    @Test
    void 참여자_두_명_사다리_열간_이동() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        int resultPosition = row.nextPosition(position).getValue();
        //then
        assertEquals(1,resultPosition);


        //when
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);
        resultPosition = row.nextPosition(position).getValue();
        //then
        assertEquals(0, resultPosition);
    }

    @Test
    void 참여자_세_명_사다리_열간_이동() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        int resultPosition = row.nextPosition(position).getValue();
        //then
        assertEquals(1,resultPosition);


        //when
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);
        resultPosition = row.nextPosition(position).getValue();
        //then
        assertEquals(0, resultPosition);

        //when
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);
        resultPosition = row.nextPosition(position).getValue();
        //then
        assertEquals(2, resultPosition);
    }

    @Test
    void 사다리_사람수_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Row(NaturalNumber.of(0)));
    }

    @Test
    void 사다리_위치_최대값_초과_예외_처리() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //when
        int position = 3;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(Position.of(position)));
    }

    @Test
    void 사다리_위치_최소값_미만_예외_처리() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //when
        int position = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(Position.of(position)));
    }

    @Test
    void 사다리_라인_그리기_위치_초과_예외() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //when
        int lineStartPosition = 2;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));
    }

    @Test
    void 사다리_라인_그리기_위치_미만_예외() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //when
        int lineStartPosition = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));
    }

    @Test
    void 라인_그리기_좌측_라인_중복_예외() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //when
        int lineStartPosition = 1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));

    }

    @Test
    void 라인_그리기_우측_라인_중복_예외() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //when
        int lineStartPosition = 0;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));

    }

    @Test
    void 라인_그리기_중복_예외() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //when
        int lineStartPosition = 1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(lineStartPosition)));
    }

    @Test
    void 선_없는_행_생성_확인() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        StringBuilder sb = new StringBuilder();

        //given
        row.generateRow(sb, Position.of(0), LadderPosition.of(Position.of(1), Position.of(1)));

        //then
        assertEquals("0 0 0 \n", sb.toString());
    }

    @Test
    void 선_있는_행_생성_확인() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));
        StringBuilder sb = new StringBuilder();

        //given
        row.generateRow(sb, Position.of(0), LadderPosition.of(Position.of(1), Position.of(1)));

        //then
        assertEquals("1 -1 0 \n", sb.toString());
    }

    @Test
    void 현재_위치_행_생성_확인() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));
        StringBuilder sb = new StringBuilder();

        //given
        row.generateRow(sb, Position.of(0), LadderPosition.of(Position.of(0), Position.of(0)));

        //then
        assertEquals("1* -1 0 \n", sb.toString());
    }

}