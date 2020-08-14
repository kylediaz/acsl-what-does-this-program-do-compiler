package com.kylediaz.acsl.what_does_this_program_do_compiler.lexer;

public class Token {

    private final TokenType type;
    private final Object value;

    // TODO: Change to factory pattern to cache tokens like EOF and EOS
    public Token(TokenType type, Object value) {
        this.type = type;
        this.value = value;
    }
    public Token(TokenType type) {
        this(type, null);
    }

    public TokenType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Token(%s, %s)", type, value == null ? "N/A" : value);
    }

}
