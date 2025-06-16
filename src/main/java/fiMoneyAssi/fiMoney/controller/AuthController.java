package fiMoneyAssi.fiMoney.controller;

import fiMoneyAssi.fiMoney.request.LoginRequest;
import fiMoneyAssi.fiMoney.request.RegisterRequest;
import fiMoneyAssi.fiMoney.response.AuthResponse;
import fiMoneyAssi.fiMoney.service.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return authService.registerUser(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
