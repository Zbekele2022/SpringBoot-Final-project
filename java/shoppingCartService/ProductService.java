package shoppingCartService;

import java.util.List;
import shoppingCartEntity.Product;



public interface ProductService {

  public static List<Product> fetchAllProductByCustomer(int customerFK) {
    // TODO Auto-generated method stub
    return null;
  }

  public static Product updateProduct(int productPK, Product updatedProduct) {
    // TODO Auto-generated method stub
    return null;
  }

  public static Product createProduct(int productId, String productName, String description,
      int categoryId, double price, int quantity, int customerFK) {
    // TODO Auto-generated method stub
    return null;
  }

  Product findByName(String name);

  Object findById(int id);

  void deleteById(int id);

  List<Product> findAll();

  List<Product> saveAll(List<Product> products);

  Object listAllProduct();

  Object getProductById(Integer id);

  void deleteProduct(Integer id);

  Product saveProduct(Product product);

  List<Product> getProducts();

  List<Product> saveProducts(List<Product> products);

  Product updateProduct(Product product);

  Product getProductByProductID(int productID);

  int deleteProductID(int productID);

  Product save(Product product);

  Product getProductByProductName(String productName);



}
