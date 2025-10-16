package juniar.nicolas.expensetracker.repository;

import juniar.nicolas.expensetracker.entity.Transaction;
import juniar.nicolas.expensetracker.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveTransaction() {
        // Ambil user pertama (pastikan sudah ada minimal 1 user di tabel)
        User user = userRepository.findByUsername("nicolas").orElseThrow();

        Transaction trx = Transaction.builder()
                .title("Beli kopi")
                .amount(25000.0)
                .category("Makanan")
                .type("expense")
                .date(LocalDateTime.now())
                .user(user)
                .build();

        transactionRepository.save(trx);
        System.out.println("Transaction saved: " + trx);
    }
}
