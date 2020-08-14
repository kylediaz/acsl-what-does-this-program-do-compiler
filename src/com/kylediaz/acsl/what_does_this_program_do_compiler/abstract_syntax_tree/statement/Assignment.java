package com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.statement;

import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.Identifier;
import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.Visitor;
import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.expression.Expression;

public class Assignment extends Statement {

    private final Identifier identifier;
    private final Expression value;

    public Assignment(Identifier identifier, Expression value) {
        this.identifier = identifier;
        this.value = value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Identifier getSymbol() {
        return identifier;
    }

    public Expression getValue() {
        return value;
    }

}
