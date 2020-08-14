package com.kylediaz.acsl.what_does_this_program_do_compiler.parser;

public class UnexpectedTokenError extends ParserException {
    public UnexpectedTokenError(String message) {
        super(message);
    }
}
