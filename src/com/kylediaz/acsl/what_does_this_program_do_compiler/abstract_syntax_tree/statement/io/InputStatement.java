package com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.statement.io;

import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.Identifier;
import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.Visitor;
import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.statement.Statement;

public class InputStatement extends Statement {

    private final Identifier identifier;

    public InputStatement(Identifier identifier) {
        this.identifier = identifier;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Identifier getSymbol() {
        return identifier;
    }

}
