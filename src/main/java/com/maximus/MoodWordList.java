package com.maximus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoodWordList {
    private List<String> positiveWords;
    private List<String> negativeWords;

    public MoodWordList() {
        positiveWords = new ArrayList<>();
        negativeWords = new ArrayList<>();
    }

    public List<String> getPositiveWords() {
        return Collections.unmodifiableList(positiveWords);
    }

    public List<String> getNegativeWords() {
        return Collections.unmodifiableList(negativeWords);
    }

    public void setPositiveWords(List<String> positiveWords) {
        this.positiveWords = positiveWords;
    }

    public void setNegativeWords(List<String> negativeWords) {
        this.negativeWords = negativeWords;
    }

    public void loadWords(String positiveWordsPath, String negativeWordsPath) {
        if (!(Files.exists(Path.of(positiveWordsPath)) && Files.exists(Path.of(negativeWordsPath)))) {
            System.out.println("Ошибка загрузки файла слов (Проверьте правильность путей). Используются стандартные");
            positiveWordsPath = "src/main/resources/positive_words.txt";
            negativeWordsPath = "src/main/resources/negative_words.txt";
        }
        try {
            List<String> positiveLines = FileReader.readWordsFromFile(positiveWordsPath);
            setPositiveWords(positiveLines);

            List<String> negativeLines = FileReader.readWordsFromFile(negativeWordsPath);
            setNegativeWords(negativeLines);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public void addPositiveWord(String newPositiveWord) {
        positiveWords.add(newPositiveWord);
    }

    public void addNegativeWord(String newNegativeWord) {
        negativeWords.add(newNegativeWord);
    }
}