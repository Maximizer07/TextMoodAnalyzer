package com.maximus;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoodScorer {
    private MoodScorer() {
        throw new IllegalStateException("Utility class");
    }

    public static int calculateMoodScore(String content, List<String> positiveWords, List<String> negativeWords) {
        int score = 0;
        score += countWords(content, positiveWords, true);
        score += countWords(content, negativeWords, false);
        return score;
    }

    private static int countWords(String content, List<String> words, boolean isPositive) {
        content = content.toLowerCase();

        List<String> lowerCaseWords = words.stream().map(String::toLowerCase).toList();
        String patternString = "(" + String.join("|", lowerCaseWords) + ")";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        int count = 0;
        while (matcher.find()) {
            count += isPositive ? 1 : -1;
        }
        return count;
    }
}
