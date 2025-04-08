import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankingService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionDao transactionDao;

    @Transactional
    public void transferMoney(int senderAccountId, int receiverAccountId, double amount) {
        Account sender = accountDao.getAccount(senderAccountId);
        Account receiver = accountDao.getAccount(receiverAccountId);

        if (sender.getBalance() >= amount) {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);

            accountDao.updateAccount(sender);
            accountDao.updateAccount(receiver);

            Transaction transaction = new Transaction();
            transaction.setSenderAccountId(senderAccountId);
            transaction.setReceiverAccountId(receiverAccountId);
            transaction.setAmount(amount);

            transactionDao.saveTransaction(transaction);
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }
}
