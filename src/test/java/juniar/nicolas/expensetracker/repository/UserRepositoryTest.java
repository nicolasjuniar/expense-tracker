package juniar.nicolas.expensetracker.repository;

import juniar.nicolas.expensetracker.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        User user = User.builder()
                .username("nicolas")
                .password("12345")
                .build();

        userRepository.save(user);
        System.out.println("User saved: " + user);
    }
}