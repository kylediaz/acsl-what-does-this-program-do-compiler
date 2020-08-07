package com.kylediaz.acsl.what_does_this_program_do_compiler.lexer;

public enum TokenType {
    END_OF_FILE,
    END_STATEMENT,
    LITERAL,
    ID,
    KEYWORD,

    COMMA,
    COLON,

    ASSIGN,
    OPEN_PARENTHESIS,
    CLOSE_PARENTHESIS,
    NOT_OPERATOR,
    MULTIPLY,
    DIVIDE,
    MODULUS,
    PLUS,
    MINUS,
    GREATER_THAN,
    LESS_THAN,
    GREATER_THAN_OR_EQUAL_TO,
    LESS_THAN_OR_EQUAL_TO,
    NOT_EQUAL_TO,
    EQUAL_TO,
    AND_OPERATOR,
    OR_OPERATOR
}
