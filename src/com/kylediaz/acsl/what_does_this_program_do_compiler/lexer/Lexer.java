package com.kylediaz.acsl.what_does_this_program_do_compiler.lexer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lexer {

    private final String text;

    public Lexer(String text) {
        this.text = text;
    }

    List<Token> tokens;
    public List<Token> getTokens() {
        if (tokens == null)
            generateTokens();
        return tokens;
    }

    private void generateTokens() {
        TokenParser parser = new TokenParser(text);
        LinkedList<Token> tempList = new LinkedList<>();
        Token newToken;
        do {
            newToken = parser.getNextToken();
            tempList.add(newToken);
        } while (newToken.getType() != TokenType.END_OF_FILE);
        tokens = new ArrayList<Token>(tempList);
    }

}
