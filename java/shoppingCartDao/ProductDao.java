package shoppingCartDao;

import java.util.List;
import shoppingCartEntity.Product;


public interface ProductDao {

  static Product createProduct(int productFK, String productName, String category,
      String description, int categoryID, double price, int quantity) {
    // TODO Auto-generated method stub
    return null;
  }

  List<Product> fetchAllProduct();

  List<Product> fetchAllProductByProduct(int productFK);

  Product updateProduct(int productPK, Product updatedProduct);

}
