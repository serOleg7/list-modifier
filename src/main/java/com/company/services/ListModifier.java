package com.company.services;

import com.company.enums.Type;
import com.company.interfaces.IListModifier;
import com.company.interfaces.IStringModifier;
import com.company.model.Rule;
import com.vdurmont.emoji.EmojiParser;

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
        IStringModifier stringModifier;
        List<Type> list = rules.getListOfTypes();
        for (int i = 0; i < input.size(); i++) {
            String res = input.get(i);
            for (Type type : list) {
                Class<?> clss = type.getClassByType();
                if (clss != null) {
                    try {
                        stringModifier = (IStringModifier) clss.getDeclaredConstructor().newInstance();
                        res = stringModifier.modifyString(res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            input.set(i, res);
        }
        return input;
    }


}


