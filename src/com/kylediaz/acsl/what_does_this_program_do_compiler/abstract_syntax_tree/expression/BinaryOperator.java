package com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.expression;

import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.ASTNode;
import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.Visitor;
import com.kylediaz.acsl.what_does_this_program_do_compiler.lexer.Token;

public class BinaryOperator extends Expression {

    private final ASTNode leftNode, rightNode;
    private final Token operator;


    public BinaryOperator(ASTNode leftNode, Token operator, ASTNode rightNode) {
        this.leftNode = leftNode;
        this.operator = operator;
        this.rightNode = rightNode;
    }

    public ASTNode getLeftNode() {
        return leftNode;
    }
    public ASTNode getRightNode() {
        return rightNode;
    }
    public Token getOperator() {
        return operator;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

}
