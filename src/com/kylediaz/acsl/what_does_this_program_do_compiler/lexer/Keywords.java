package com.kylediaz.acsl.what_does_this_program_do_compiler.lexer;

import java.util.Set;

final class Keywords {

    private final static Set<String> KEYWORDS = Set.of("input", "output",
            "if", "then", "end",
            "for", "to", "step", "next",
            "while");

    public static Set<String> values() {
        return KEYWORDS;
    }

}
