import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Priority {
    public List<Student> getStudents (List<String> events) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(events.size(), new StudentComparator());
        for (String event : events) {
            if (event.contains("ENTER")) {
                String[] arr = event.split(" ");
                Student student = new Student(Integer.parseInt(arr[3]), arr[1], Double.parseDouble(arr[2]));
                priorityQueue.add(student);
            } else {
                if (priorityQueue.size() > 0)
                    priorityQueue.poll();
            }
        }
        List<Student> students = new ArrayList<>();
        while (!priorityQueue.isEmpty())
            students.add(priorityQueue.poll());
        return students;
    }

    public static void main(String[] args) {
        Priority priority = new Priority();
        List<Student> students = priority.getStudents(Arrays.asList("ENTER John 3.75 50","ENTER Mark 3.8 24","ENTER Shafaet 3.7 35", "SERVED",
        "SERVED","ENTER Samiha 3.85 36","SERVED","ENTER Ashley 3.9 42","ENTER Maria 3.6 46","ENTER Anik 3.95 49","ENTER Dan 3.95 50","SERVED"));
        System.out.println(students);
    }
}
