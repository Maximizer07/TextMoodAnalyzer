package com.maximus;

import java.io.IOException;

public class TextMoodAnalyzer {
    public static void main(String[] args) {
        MoodWordList wordList = new MoodWordList();
        Props props = new Props();

        try {
            props.loadProps("src/main/resources/paths.properties");
            String positiveWordsPath = props.getProperty("positive_words_file");
            String negativeWordsPath = props.getProperty("negative_words_file");
            wordList.loadWords(positiveWordsPath, negativeWordsPath);
        } catch (IOException e) {
            System.out.println("Файл с путями файлов не найден: " + e.getMessage());
        }

        String textPath = props.getProperty("text_file");
        if (textPath != null) {
            try {
                String content = FileReader.readTextFromFile(textPath);
                int moodScore = MoodScorer.calculateMoodScore(content, wordList.getPositiveWords(),
                        wordList.getNegativeWords()
                );
                System.out.println("Значение настроения текста: " + moodScore);
            } catch (IOException e) {
                System.out.println("Ошибка чтения текстового файла. Проверьте правильность пути: " + e.getMessage());
            }
        } else {
            System.out.println("Ошибка чтения файла. Проверьте правильность пути: " + textPath);
        }
    }
}
