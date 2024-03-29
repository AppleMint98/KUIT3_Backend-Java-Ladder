package ladder;

import ladder.core.LadderRunner;
import ladder.core.LadderSize;
import ladder.creator.CustomLadderCreator;
import ladder.creator.LadderCreator;
import ladder.position.LadderPosition;
import ladder.position.Position;
import ladder.utils.NaturalNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LadderRunnerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreSystemOutStream() {
        System.setOut(originalOut);
    }

    @Test
    public void 사다리_표현_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(4);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderCreator ladderCreator = new CustomLadderCreator(ladderSize);
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());

        Position currentRow = Position.of(2);
        Position currentCol = Position.of(1);
        LadderPosition currentPosition = LadderPosition.of(currentRow, currentCol);

        //when
        String ladderRepresentation = ladderRunner.generate(currentPosition);

        //then
        String expected =
                "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0* 0 0 \n" +
                        "0 0 0 0 \n";
        assertEquals(expected, ladderRepresentation);
    }

    @Test
    public void 사다리_출력_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(4);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderCreator ladderCreator = new CustomLadderCreator(ladderSize);
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());

        Position currentRow = Position.of(2);
        Position currentCol = Position.of(1);
        LadderPosition currentPosition = LadderPosition.of(currentRow, currentCol);
        String label = "Test Label";

        //when
        ladderRunner.printLadder(currentPosition, label);

        //then
        String expectedOutput =
                "Test Label\n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0* 0 0 \n" +
                        "0 0 0 0 \n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

}