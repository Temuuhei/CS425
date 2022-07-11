package erigstrar.eregistrarwebapp.service.impl;

import erigstrar.eregistrarwebapp.model.User;
import erigstrar.eregistrarwebapp.repository.UserRepository;
import erigstrar.eregistrarwebapp.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
    }

    @Override
    public User saveUser(User user) {
        // Encrypt the password using BCrypt
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }


}

