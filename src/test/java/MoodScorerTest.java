import com.maximus.MoodScorer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MoodScorerTest {

    @Test
    public void calculateMoodScore() {
        List<String> positives = List.of("успех", "легкость", "восторг");
        List<String> negatives = List.of("грусть", "тоска");

        String content = "Успех и легкость это восторг, а грусть и тоска - плохо";
        int score = MoodScorer.calculateMoodScore(content, positives, negatives);
        assertEquals(1, score);
    }
}
