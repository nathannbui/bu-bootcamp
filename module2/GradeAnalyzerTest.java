import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

public class GradeAnalyzerTest {

    @Test
    void calculateAverage_returnsZero_whenListIsEmpty() {
        ArrayList<Integer> scores = new ArrayList<>();
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsCorrectAverage_forTypicalScores() {
        ArrayList<Integer> scores =
                new ArrayList<>(Arrays.asList(80, 90, 100));
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsSingleValue_whenListHasOneItem() {
        ArrayList<Integer> scores =
                new ArrayList<>(Arrays.asList(75));
        assertEquals(75.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsDouble_notInteger() {
        ArrayList<Integer> scores =
                new ArrayList<>(Arrays.asList(1, 2));
        assertEquals(1.5, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_handlesAllSameValues() {
        ArrayList<Integer> scores =
                new ArrayList<>(Arrays.asList(88, 88, 88));
        assertEquals(88.0, GradeAnalyzer.calculateAverage(scores));
    }
        @Test
    void calculateAverage_returnsCorrectAverage_forTenScores() {
        ArrayList<Integer> scores = new ArrayList<>(
                Arrays.asList(61, 65, 70, 75, 80, 85, 90, 95, 99, 100));
        assertEquals(82.0, GradeAnalyzer.calculateAverage(scores));
    }
}