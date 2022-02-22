package com.company.interfaces;

import com.company.model.Rule;

import java.util.List;

public interface IListModifier {
    List<String> modifyList(List<String> input);


    List<String> modifyList(List<String> input, Rule rules);

}
