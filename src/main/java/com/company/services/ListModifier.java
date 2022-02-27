package com.company.services;

import com.company.interfaces.IListModifier;
import com.company.interfaces.IStringModifier;
import com.company.model.Rule;
import com.vdurmont.emoji.EmojiParser;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ListModifier implements IListModifier {

    @Override
    public List<String> modifyList(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            String res = EmojiParser.parseToUnicode(input.get(i));
            input.set(i, EmojiParser.removeAllEmojis(res));
        }
        return input;
    }


    @Override
    public List<String> modifyList(List<String> input, Rule rules) {
        IStringModifier stringModifier = null;
        List<Class<?>> filters = rules.getListOfFilters();
        for (Class<?> clss : filters) {
            try {
                stringModifier = (IStringModifier) clss.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (int i = 0; i < input.size(); i++) {
                String res = input.get(i);
                res = stringModifier.modifyString(res);
                input.set(i, res);
            }
        }
        return input;
    }




}


