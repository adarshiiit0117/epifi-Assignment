package fiMoneyAssi.fiMoney.request;

import lombok.Data;

@Data
public class AddProductRequest {
    private String name;
    private String type;
    private String sku;
    private String imageUrl;
    private String description;
    private int quantity;
    private double price;
}
