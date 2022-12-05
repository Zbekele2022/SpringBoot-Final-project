package shoppingCartController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import shoppingCartEntity.Product;
import shoppingCartService.ProductService;

@Slf4j
@Controller
public class DefaultProductController  implements ProductController {

  //Default Product Controller implements everything from the Product Controller interface.
  //From here, it hands it off to the service layer.
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/productByProductID/{ProductID}")
    public Product findProductByProductID(@PathVariable int ProductID) {
        return productService.getProductByProductID(ProductID);
    }

    @GetMapping("/product/{ProductName}")
    public Product findProductByProductName(@PathVariable String ProductName) {
        return productService.getProductByProductName(ProductName);
    }

    private Object ProductName(String productName) {
      // TODO Auto-generated method stub
      return null;
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{ProductID}")
    public int deleteProductID(@PathVariable int ProductID) {
        return productService.deleteProductID(ProductID);
    }

    @Override
    public List<Product> fetchAllProductByCustomer(int customerFK) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public List<Product> fetchAllProduct() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Product updateProduct(int ProductPK, Product updatedProduct) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public <ProductName> List<Product> fetchProduct(ProductName name) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Product createProduct(int ProductId, String ProductName, String Description,
        int CategoryId, double price, int Quantity, int customerFK) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public <ProductName> List<Product> fetchProduct(String ProductName) {
      // TODO Auto-generated method stub
      return null;
    }
}











