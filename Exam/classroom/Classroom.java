package classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Classroom {

    private int capacity;
    private List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }


    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.capacity > this.students.size()) {
            if (this.students.contains(student)) {
                return "Student is already in the classroom";
            }
            this.students.add(student);
            return String.format("Added student %s %s",
                    student.getFirstName(), student.getLastName());
        }
        return "No seats in the classroom";
    }

    public String getSubjectInfo(String subject) {
        if (!this.students.isEmpty()) {

            StringBuilder sb = new StringBuilder();
            List<Student> filtered = this.students.stream().filter(s -> s.getBestSubject().equals(subject))
                    .collect(Collectors.toList());
            if (!filtered.isEmpty()) {
                sb.append(String.format("Subject: %s%nStudents:%n", subject));
                for (Student student : filtered) {
                    sb.append(String.format("%s %s%n", student.getFirstName(), student.getLastName()));
                }
                return sb.toString().trim();
            }
        }
        return "No students enrolled for the subject";
    }

    public Student getStudent(String firstName, String lastName) {
        Student toFind = null;
        for (Student student : students) {
            if (student.getFirstName().equals(firstName)
                    && student.getLastName().equals(lastName)) {
                toFind = student;
            }
        }
        return toFind;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Classroom size: %d%n", this.students.size()));
        for (Student student : students) {
            sb.append(String.format("   ==Student: First Name= %s , " +
                            "Last Name= %s , Best Subject= %s%n", student.getFirstName()
                    , student.getLastName(), student.getBestSubject()));
        }

        return sb.toString().trim();
    }

    public String dismissStudent(Student student) {
        boolean isRemoved = this.students.removeIf(s -> s == student);
        if (isRemoved) {
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
        return "Student not found";
    }
}
