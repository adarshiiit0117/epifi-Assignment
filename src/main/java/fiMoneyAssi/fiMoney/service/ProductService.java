package fiMoneyAssi.fiMoney.service;

import fiMoneyAssi.fiMoney.model.Product;
import fiMoneyAssi.fiMoney.repository.ProductRepository;
import fiMoneyAssi.fiMoney.request.AddProductRequest;
import fiMoneyAssi.fiMoney.request.UpdateQuantityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(AddProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setType(request.getType());
        product.setSku(request.getSku());
        product.setImageUrl(request.getImageUrl());
        product.setDescription(request.getDescription());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());

        System.out.println("💾 Saving product: " + product);

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> updateQuantity(Long id, int quantity) {
        Optional<Product> productOpt = productRepository.findById(id);
        productOpt.ifPresent(product -> {
            product.setQuantity(quantity);
            productRepository.save(product);
        });
        return productOpt;
    }
    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


}
