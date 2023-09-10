package com.prioritysolution;

import com.priority.Priorities;
import com.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrioritySolution {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Priorities priorities = new Priorities();

    public static void main(String... args) {
        int totalNumberOfEvents = Integer.parseInt(scanner.nextLine());
        List<String> events = new ArrayList<>();
        System.out.println("Text added for checking pull request in Intellij..");

        while (totalNumberOfEvents-- != 0) {
            String event = scanner.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty())
            System.out.println("EMPTY");
        else
            for (Student student : students)
                System.out.println(student.getName());
    }
}

