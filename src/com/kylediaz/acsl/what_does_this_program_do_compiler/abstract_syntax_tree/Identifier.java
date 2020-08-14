package com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree;

import com.kylediaz.acsl.what_does_this_program_do_compiler.lexer.Token;

public class Identifier extends ASTNode {

    private final Token symbol;

    public Identifier(Token symbol) {
        this.symbol = symbol;
    }

    public Token getSymbol() {
        return symbol;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

}
