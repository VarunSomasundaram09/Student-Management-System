import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
public class StudentManager {
    private ArrayList<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }
    public void addStudent(Student student) {
        studentList.add(student);
    }
    public void viewStudents() {
        for (Student student : studentList) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Age: " + student.getAge() + ", Course: " + student.getCourse());
        }
    }
    public Student searchStudent(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    public Student updateStudent(int id, int newAge, String newCourse) {
        Student student = searchStudent(id);
        if (student != null) {
            student.setAge(newAge);
            student.setCourse(newCourse);
            return student;
        }
        return null;
    }
    public boolean deleteStudent(int id) {
        Student student = searchStudent(id);
        if (student != null) {
            studentList.remove(student);
            return true;
        }
        return false;
    }
    public void saveToFile(){
        try{
            FileWriter writer = new FileWriter("students.txt");
            for (Student student : studentList) {
writer.write(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getCourse() + "\n");            }
            writer.close();
            System.out.println("Saved Successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    public void loadFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String course = parts[3];
                    Student student = new Student(id, name, age, course);
                    studentList.add(student);
                }
            }
            reader.close();
            System.out.println("Loaded Successfully.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}
