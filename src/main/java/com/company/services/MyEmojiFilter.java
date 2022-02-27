package com.company.services;

import com.company.annotations.Filter;
import com.company.interfaces.IStringModifier;
import com.vdurmont.emoji.EmojiParser;

@Filter
public class MyEmojiFilter implements IStringModifier {

    @Override
    public String modifyString(String str) {
        String res = EmojiParser.parseToUnicode(str);
        return EmojiParser.removeAllEmojis(res);
    }
}
