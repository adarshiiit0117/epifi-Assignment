package fiMoneyAssi.fiMoney.service;

import fiMoneyAssi.fiMoney.model.User;
import fiMoneyAssi.fiMoney.model.Role;
import fiMoneyAssi.fiMoney.repository.UserRepository;
import fiMoneyAssi.fiMoney.request.RegisterRequest;
import fiMoneyAssi.fiMoney.request.LoginRequest;
import fiMoneyAssi.fiMoney.response.AuthResponse;
import fiMoneyAssi.fiMoney.config.JwtUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    public ResponseEntity<String> registerUser(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.status(409).body("Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() == null ? Role.USER : request.getRole());

        userRepository.save(user);
        return ResponseEntity.status(201).body("User registered successfully");
    }


    public AuthResponse login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());
        AuthResponse response = new AuthResponse();

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                String token = jwtUtil.generateToken(user.getUsername(), user.getRole().name());
                response.setAccessToken(token);
                response.setStatus(true);
                response.setMessage("Login successful");
                return response;
            }
        }

        response.setStatus(false);
        response.setMessage("Invalid username or password");
        return response;
    }
}
