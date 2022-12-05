package shoppingCartService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import shoppingCartDao.ProductDao;
import shoppingCartEntity.Product;

@Service
@Slf4j
public class DefaultProductService implements ProductService {

  @Autowired
    private ProductService productService;

  //Default product service implements everything that's brought over from product service
  // once it runs through all of the commands, it hands it off to the Dao layer.
  @Override
  public Product saveProduct(Product product) {
        return productService.save(product);
    }

    public List<Product> saveProduct(List<Product> products) {
        return productService.saveAll(products);
    }

    public List<Product> getProduct() {
        return productService.findAll();
    }

    public Product createProduct(int productID, String ProductName,  String Category, String Description,
        int CategoryID, double price, int Quantity) {
      return ProductDao.createProduct(productFK, ProductName, Category, Description, CategoryID,price,Quantity);
    }

    public Product getProductById(int productID) {
        return productService.findById(productID).orElse(null);
    }

    public Product getProductByName(String ProductName) {
        return productService.findByName(ProductName);
    }

    public String deleteProduct(int productID) {
        productService.deleteById(productID);
        return "product removed !! " + productID;
    }

    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = productService.findById(product.getProductID()).orElse(null);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setQuantityInStock(product.getQuantityInStock());
        existingProduct.setPrice(product.getPrice());
        return productService.save(existingProduct);
    }

    @Override
    public Product findByName(String name) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Object findById(int id) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public void deleteById(int id) {
      // TODO Auto-generated method stub

    }

    @Override
    public List<Product> findAll() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Product save(Product product) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Object listAllProduct() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Object getProductById(Integer id) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public void deleteProduct(Integer id) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public List<Product> getProducts() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public List<Product> saveProducts(List<Product> products) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Product getProductByProductID(int productID) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public int deleteProductID(int productID) {
      // TODO Auto-generated method stub
      return 0;
    }


}
