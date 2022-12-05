package shoppingCartController;

import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import shoppingCartEntity.Product;

@Validated
@RequestMapping("/ShoppingCart/")
@OpenAPIDefinition(info = @Info(title = "product"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface ProductController {

  List<Product> fetchAllProductByCustomer(int customerFK);

  List<Product> fetchAllProduct();

  Product updateProduct(int ProductPK, Product updatedProduct);

  <ProductName> List<Product> fetchProduct(ProductName name);

  Product createProduct(int ProductId, String ProductName, String Description, int CategoryId,
      double price, int Quantity, int customerFK);

  <ProductName> List<Product> fetchProduct(String ProductName);



}
