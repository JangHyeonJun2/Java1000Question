package 자바1000제;

import java.util.Comparator;

public class ClassTotalComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getClassNo() > o2.getClassNo())
            return 1;
        else if (o1.getClassNo() == o2.getClassNo())
            return o2.getTotal() - o1.getTotal();
        else
            return -11;
    }
}
