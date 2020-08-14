package com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.statement.control;

import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.Visitor;
import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.expression.Expression;
import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.statement.Statement;

public class WhileStatement extends Statement {

    private final Expression condition;
    private final Statement body;

    public WhileStatement(Expression condition, Statement body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getCondition() {
        return condition;
    }
    public Statement getBody() {
        return body;
    }

}
