
import com.maximus.MoodWordList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoodWordListTest {

    @Test
    public void testAddPositiveWord() {
        String newPositiveWord = "хорошо";
        MoodWordList moodWordList = new MoodWordList();
        moodWordList.addPositiveWord(newPositiveWord);
        List<String> positiveWords = moodWordList.getPositiveWords();

        assertEquals(1, moodWordList.getPositiveWords().size());
        assertTrue(positiveWords.contains(newPositiveWord));
    }

    @Test
    public void testAddNegativeWord() {
        String newNegativeWord = "ужас";
        MoodWordList moodWordList = new MoodWordList();
        moodWordList.addNegativeWord(newNegativeWord);
        List<String> negativeWords = moodWordList.getNegativeWords();

        assertEquals(1, moodWordList.getNegativeWords().size());
        assertTrue(negativeWords.contains(newNegativeWord));
    }
}
