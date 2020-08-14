package com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.expression;

import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.Visitor;
import com.kylediaz.acsl.what_does_this_program_do_compiler.lexer.Token;

public class UnaryOperator extends Expression {

    private final Token operator;
    private final Expression expression;

    public UnaryOperator(Token operator, Expression expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public Token getOperator() {
        return operator;
    }
    public Expression getExpression() {
        return expression;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

}
