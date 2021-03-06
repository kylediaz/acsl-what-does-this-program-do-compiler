package com.kylediaz.acsl.what_does_this_program_do_compiler.lexer;

class TokenParser {

    private String text;
    private int index;

    public TokenParser(String text) {
        this.text = text;
        this.index = 0;
    }

    public Token getNextToken() {
        if (!atEndOfText() && currentCharacterIsWhitespace())
            skipWhiteSpace();
        if (atEndOfText()) {
            return new Token(TokenType.END_OF_FILE);
        }

        Token output;

        if (currentCharacterIsDigit()) {
            output = new Token(TokenType.LITERAL, scanForInteger());
        } else if (currentCharacterIsLetter()) {
            String word = scanForWord();
            Keyword keywordParse = attemptToCastToKeyword(word);
            if (keywordParse == null) {
                output = new Token(TokenType.ID, word);
            } else {
                output = new Token(TokenType.KEYWORD, keywordParse);
            }
        } else if (text.charAt(index) == ',') {
            output = new Token(TokenType.COMMA);
            index++;
        } else if (text.charAt(index) == ':') {
            output = new Token(TokenType.COLON);
            index++;
        } else if (text.charAt(index) == '(') {
            output = new Token(TokenType.OPEN_PARENTHESIS);
            index++;
        } else if (text.charAt(index) == ')') {
            output = new Token(TokenType.CLOSE_PARENTHESIS);
            index++;
        } else {
            String symbolWord = scanForOperator();
            TokenType lookupAttempt = Operators.matchOperatorStringToTokenType(symbolWord);
            if (lookupAttempt != null) {
                output = new Token(lookupAttempt);
            } else {
                throw new LexerException("Unable to find token");
            }
        }

        return output;
    }


    private void skipWhiteSpace() {
        while (index < text.length() && currentCharacterIsWhitespace()) {
            index++;
        }
    }

    private String scanForInteger() {
        if (!currentCharacterIsDigit())
            throw new RuntimeException("Invalid location for integer");
        StringBuilder output = new StringBuilder();
        while (currentCharacterIsDigit() && !atEndOfText()) {
            output.append(text.charAt(index++));
        }
        return output.toString();
    }

    private String scanForWord() {
        if (!currentCharacterIsLetter())
            throw new RuntimeException("Invalid location for word");
        StringBuilder output = new StringBuilder();
        while ((currentCharacterIsLetter() || currentCharacterIsDigit()) && !atEndOfText())
            output.append(text.charAt(index++));
        return output.toString();
    }

    private String scanForOperator() {
        StringBuilder output = new StringBuilder();
        while ((currentCharacterIsSymbol() || currentCharacterIsWhitespace()) && !atEndOfText()) {
            if (currentCharacterIsSymbol())
                output.append(text.charAt(index));
            index++;
        }

        String outputString = output.toString();
        if (outputString.isBlank())
            throw new RuntimeException("Invalid location for operator");
        return outputString;
    }


    private Keyword attemptToCastToKeyword(String s) {
        s = s.toUpperCase();
        try {
            return Keyword.valueOf(s);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }


    private boolean currentCharacterIsWhitespace() {
        char currentChar = text.charAt(index);
        return currentChar != '\n' && Character.isWhitespace(currentChar);
    }

    private boolean currentCharacterIsDigit() {
        return !atEndOfText() && Character.isDigit(text.charAt(index));
    }

    private boolean currentCharacterIsLetter() {
        return !atEndOfText() && Character.isLetter(text.charAt(index));
    }

    private boolean currentCharacterIsSymbol() {
        return !atEndOfText() && Operators.validChars().contains(text.charAt(index));
    }

    private boolean atEndOfText() {
        return index >= text.length();
    }

}