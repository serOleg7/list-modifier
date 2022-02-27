package com.company.model;

import com.company.annotations.Filter;
import org.reflections.Reflections;

import java.util.*;
import java.util.stream.Collectors;


public class Rule {
   private final List<Class<?>> filters;

    public Rule(List<String> rules) {
        filters = new Reflections("com.company.services").getTypesAnnotatedWith(Filter.class)
                .stream()
                .filter(c -> rules.contains(c.getSimpleName().split("Filter")[0]))
                .collect(Collectors.toList());

    }

    public List<Class<?>> getListOfFilters() {
        return filters;
    }


}
