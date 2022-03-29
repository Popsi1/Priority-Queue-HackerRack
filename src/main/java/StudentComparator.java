import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getCgpa() > o2.getCgpa())
            return -1;
        else if (o1.getCgpa() == o2.getCgpa()) {
            if (o1.getName().equals(o2.getName())) {
                return Integer.compare(o1.getId(), o2.getId());
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }
        return 1;
    }
}
