package com.company.services;

import com.company.interfaces.IStringModifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VocabularyParser implements IStringModifier {
    private final List<String> vocabulary = Arrays.asList("with", "few", "boy");


    @Override
    public String modifyString(String str) {
        //TODO fix regex
        String[] tmp = str.split("[ ]|((?=:|;|' '))");
        List<String> listWords = new ArrayList<>(Arrays.asList(tmp));

        for (String word : vocabulary)
            listWords.removeIf(value -> value.equalsIgnoreCase(word));
        return String.join(" ", listWords);
    }
}
