package fiMoneyAssi.fiMoney.repository;

import fiMoneyAssi.fiMoney.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
