import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    public Account getAccount(int accountId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Account.class, accountId);
    }

    public void updateAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.update(account);
    }
}
