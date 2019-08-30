package com.example.javastreams.javastreamsdemo.collection;

import com.example.javastreams.javastreamsdemo.domain.Student;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author benjamin
 * created at 2019/8/29
 */
public class MapExample {

    public static void main(String[] args) {

        LinkedList<Student> linkedList = new LinkedList<>();

        for (int i = 0; i < 2; i++) {
            Student student = new Student(i, "libai", 11);

            linkedList.add(student);
        }

        Map<String, Student> map = linkedList.stream().collect(Collectors.toMap(student -> student.getName(),
                student -> student, (student, student2) -> student2));

        map.entrySet().stream().forEach(stringStudentEntry -> {
            System.out.println(stringStudentEntry.getValue().getId());
        });


    }
}
