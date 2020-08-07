package com.kylediaz.acsl.what_does_this_program_do_compiler.lexer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Operators {

    // I'm sorry for this :)
    private final static Map<String, TokenType> STRING_TOKEN_TYPE_MAP = new HashMap<>();
    static {
        STRING_TOKEN_TYPE_MAP.put("=", TokenType.ASSIGN);
        STRING_TOKEN_TYPE_MAP.put("!", TokenType.NOT_OPERATOR);
        STRING_TOKEN_TYPE_MAP.put("*", TokenType.MULTIPLY);
        STRING_TOKEN_TYPE_MAP.put("/", TokenType.DIVIDE);
        STRING_TOKEN_TYPE_MAP.put("%", TokenType.MODULUS);
        STRING_TOKEN_TYPE_MAP.put("+", TokenType.PLUS);
        STRING_TOKEN_TYPE_MAP.put("-", TokenType.MINUS);
        STRING_TOKEN_TYPE_MAP.put(">", TokenType.GREATER_THAN);
        STRING_TOKEN_TYPE_MAP.put("<", TokenType.LESS_THAN);
        STRING_TOKEN_TYPE_MAP.put(">=", TokenType.GREATER_THAN_OR_EQUAL_TO);
        STRING_TOKEN_TYPE_MAP.put("<=", TokenType.LESS_THAN_OR_EQUAL_TO);
        STRING_TOKEN_TYPE_MAP.put("!=", TokenType.NOT_EQUAL_TO);
        STRING_TOKEN_TYPE_MAP.put("==", TokenType.EQUAL_TO);
        STRING_TOKEN_TYPE_MAP.put("&&", TokenType.AND_OPERATOR);
        STRING_TOKEN_TYPE_MAP.put("||", TokenType.OR_OPERATOR);
    }

    /**
     * @param operator string representation of operator e.g. "+", "==", "&&"
     * @return TokenType equivalent, null if none exists
     */
    public static TokenType matchOperatorStringToTokenType(String operator) {
        return STRING_TOKEN_TYPE_MAP.get(operator);
    }

    public static Set<String> operatorStrings() {
        return STRING_TOKEN_TYPE_MAP.keySet();
    }
    public static Set<TokenType> operatorTokenTypes() {
        return Set.copyOf(STRING_TOKEN_TYPE_MAP.values());
    }

    private final static Set<Character> VALID_CHARS = Set.of('=','!','*','/','%','+','-','<','>','&','|');
    public static Set<Character> validChars() {
        return VALID_CHARS;
    }

}
