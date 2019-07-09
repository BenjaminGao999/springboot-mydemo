package com.example.base.java.demobasejava.generics_wildcard_error;

import java.util.List;

/**
 * @author benjamin
 * created at 2019/7/7
 */
public class WildcardFixed {

    void foo(List<?> i) {
        fooHelper(i);
    }


    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }

}

