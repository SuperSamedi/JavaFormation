package brussels.digitalcity.tu;

import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.RepetitionInfo;
//import org.junit.jupiter.api.TestInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class TestInfoDemoTests {

    private Logger logger = Logger.getLogger(TestInfoDemoTests.class.getName());

//    private static final List<Integer> integers = Arrays.asList(1, 2, 5, 8);

    @BeforeEach
    void beforeEachTest(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        logger.info(String.format(
                "Repeat %d / %d pour %s",
                repetitionInfo.getCurrentRepetition(),
                repetitionInfo.getTotalRepetitions(),
                testInfo.getTestMethod().get().getName()
        ));
    }

    @RepeatedTest(100)
    void repeatTest() {}
}
