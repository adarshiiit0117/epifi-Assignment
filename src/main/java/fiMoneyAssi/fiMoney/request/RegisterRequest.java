package fiMoneyAssi.fiMoney.request;

import fiMoneyAssi.fiMoney.model.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
}
