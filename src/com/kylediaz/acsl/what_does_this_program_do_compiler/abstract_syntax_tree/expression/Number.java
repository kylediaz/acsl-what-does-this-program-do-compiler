package com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.expression;

import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.Visitor;
import com.kylediaz.acsl.what_does_this_program_do_compiler.lexer.Token;
import com.kylediaz.acsl.what_does_this_program_do_compiler.lexer.TokenType;

public class Number extends Expression {

    private final Token token;

    public Number(Token numberToken) {
        this.token = numberToken;
    }
    public Number(int value) {
        this(new Token(TokenType.LITERAL, Integer.toString(value)));
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

}
