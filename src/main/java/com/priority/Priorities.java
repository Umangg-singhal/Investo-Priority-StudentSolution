package com.priority;


import com.student.Student;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Priorities {

   public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>(events.size(), studentComparator);

        for (String event : events) {
            String[] parts = event.split(" ");

            if ("ENTER".equals(parts[0]))
                queue.add(new Student(Integer.parseInt(parts[3]), parts[1], Double.parseDouble(parts[2])));
            else if ("SERVED".equals(parts[0]))
                if (!queue.isEmpty())
                    queue.remove();
        }

        List<Student> students = new ArrayList<>(queue.size());

        while (!queue.isEmpty())
            students.add(queue.remove());

        return students;
    }

    private static final Comparator<Student> studentComparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            int comparedReturnValue = Double.compare(student2.getCgpa(), student1.getCgpa());
            comparedReturnValue = comparedReturnValue == 0 ? student1.getName().compareTo(student2.getName()) : comparedReturnValue;
            return comparedReturnValue == 0 ? Integer.compare(student1.getId(), student2.getId()) : comparedReturnValue;
        }
    };

}
