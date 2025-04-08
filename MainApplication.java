import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get Student Bean from Spring context
        Student student = context.getBean(Student.class);
        System.out.println(student);

        context.close();
    }
}
