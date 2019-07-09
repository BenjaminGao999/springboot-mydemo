//package com.example.base.java.demobasejava.generics_wildcard_error;
//
///**
// * @author benjamin
// * created at 2019/7/7
// */
//
//import java.util.List;
//
//public class WildcardError {
//    //javac ./WildcardError.java -J-Duser.language=en
//
//    //javac ./WildcardError.java -J-Duser.language=en -Xdiags:verbose
//
//    //the compiler is not able to confirm the type of object that is being inserted into the list, and an error is produced
//    // compiler无法确定 ? 的 type
//
//    void foo(List<?> i) {
//        i.set(0, i.get(0));
//    }
//
//
//}
//
