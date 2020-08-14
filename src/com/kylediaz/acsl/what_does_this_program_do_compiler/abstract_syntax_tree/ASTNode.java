package com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree;

public abstract class ASTNode {

    public abstract <T> T accept(Visitor<T> visitor);

}
