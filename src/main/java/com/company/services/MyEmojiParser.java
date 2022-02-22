package com.company.services;

import com.company.interfaces.IStringModifier;
import com.vdurmont.emoji.EmojiParser;

public class MyEmojiParser implements IStringModifier {

    @Override
    public String modifyString(String str) {
        String res = EmojiParser.parseToUnicode(str);
        return EmojiParser.removeAllEmojis(res);
    }
}
