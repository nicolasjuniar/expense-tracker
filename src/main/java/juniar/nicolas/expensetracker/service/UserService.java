package juniar.nicolas.expensetracker.service;

import juniar.nicolas.expensetracker.dto.UserDTO;
import juniar.nicolas.expensetracker.entity.User;
import juniar.nicolas.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(UserDTO userDTO) {
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username sudah dipakai!");
        }

        User user = User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();

        return userRepository.save(user);
    }

    public User login(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("Username tidak ditemukan"));

        if (!user.getPassword().equals(userDTO.getPassword())) {
            throw new RuntimeException("Password salah");
        }

        return user;
    }
}
