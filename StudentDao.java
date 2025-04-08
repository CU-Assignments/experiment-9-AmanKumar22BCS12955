import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

    public void saveStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public Student getStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    public void updateStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }

    public void deleteStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.delete(student);
        }
        transaction.commit();
        session.close();
    }
}
