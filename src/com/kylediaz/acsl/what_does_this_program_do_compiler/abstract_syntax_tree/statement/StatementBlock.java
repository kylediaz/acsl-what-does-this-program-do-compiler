package com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.statement;

import com.kylediaz.acsl.what_does_this_program_do_compiler.abstract_syntax_tree.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StatementBlock<T extends Statement> extends Statement implements Iterable<T> {

    private final List<T> statementList = new ArrayList<>();

    public StatementBlock(T... statements) {
        statementList.addAll(List.of(statements));
    }

    public void addStatement(T statement) {
        statementList.add(statement);
    }

    @Override
    public Object accept(Visitor visitor) {
        for (Statement statement : statementList)
            statement.accept(visitor);
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return statementList.iterator();
    }

}
