package 자바1000제;

import java.util.Comparator;

public class ClassStudentNoComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getClassNo() > o1.getClassNo())
            return-1;
        else if (o1.getClassNo() == o2.getClassNo()){
            return o1.getStudentNo() - o2.getStudentNo();
        }else
            return 0;
    }
}
