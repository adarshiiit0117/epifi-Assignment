package fiMoneyAssi.fiMoney.response;

import lombok.Data;

@Data
public class AuthResponse {
    private String accessToken;
    private boolean status;
    private String message;
}
