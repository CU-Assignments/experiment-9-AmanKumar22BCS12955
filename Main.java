public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        // Create and save a new student
        Student student = new Student();
        student.setId(1);
        student.setName("John Doe");
        student.setAge(22);
        studentDao.saveStudent(student);

        // Retrieve the student by ID
        Student retrievedStudent = studentDao.getStudent(1);
        System.out.println("Retrieved Student: " + retrievedStudent.getName());

        // Update the student's age
        retrievedStudent.setAge(23);
        studentDao.updateStudent(retrievedStudent);

        // Delete the student
        studentDao.deleteStudent(1);
    }
}
