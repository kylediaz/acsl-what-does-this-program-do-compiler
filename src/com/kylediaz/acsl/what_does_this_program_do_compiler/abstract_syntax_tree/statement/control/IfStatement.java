package com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.statement.control;

import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.Visitor;
import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.expression.Expression;
import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.statement.Statement;

public class IfStatement extends Statement {

    private final Expression condition;
    private final Statement thenBody;
    private final Statement elseBody;

    public IfStatement(Expression condition, Statement thenBody, Statement elseBody) {
        this.condition = condition;
        this.thenBody = thenBody;
        this.elseBody = elseBody;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getCondition() {
        return condition;
    }
    public Statement getThenBody() {
        return thenBody;
    }
    public Statement getElseBody() {
        return elseBody;
    }

}
