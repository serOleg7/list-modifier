package com.company.enums;

public enum Type {
    EMOJI("com.company.services.MyEmojiParser"), VOCABULARY("com.company.services.VocabularyParser");

    private final String value;

    Type(String value) {
        this.value = value;
    }

    public Class<?> getClassByType() {
        try {
            return Class.forName(value);
        } catch (ClassNotFoundException e) {
            System.out.println("Class: " + value + " not found");
        }
        return null;
    }
}
