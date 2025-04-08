import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BankingService bankingService = context.getBean(BankingService.class);
        
        // Attempting a successful transaction
        try {
            bankingService.transferMoney(1, 2, 500);
            System.out.println("Transaction Successful!");
        } catch (RuntimeException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }
        
        context.close();
    }
}
