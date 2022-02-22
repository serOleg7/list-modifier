package com.company.model;

import com.company.enums.Type;

import java.util.List;

public class Rule {
    private final List<Type> types;

    public Rule(List<Type> types) {
        this.types = types;
    }

    public List<Type> getListOfTypes() {
        return types;
    }

}
