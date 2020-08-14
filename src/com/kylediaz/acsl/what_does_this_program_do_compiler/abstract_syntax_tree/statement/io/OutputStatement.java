package com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.statement.io;

import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.Visitor;
import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.expression.Expression;
import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.statement.Statement;

public class OutputStatement extends Statement {

    private final Expression outputValue;

    public OutputStatement(Expression outputValue) {
        this.outputValue = outputValue;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getOutputValue() {
        return outputValue;
    }

}
