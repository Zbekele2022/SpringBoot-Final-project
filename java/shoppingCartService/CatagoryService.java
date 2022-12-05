package shoppingCartService;

import java.util.List;
import shoppingCartEntity.Catagory;
import shoppingCartEntity.Product;

public interface CatagoryService {

  Product save(Product product);

  List<Product> findAll();

  Object findById(int id);

  Product findByName(String name);

  List<Product> saveAll(List<Product> products);

  void deleteById(int id);

  List<Catagory> fetchAllCategories();

  List<Catagory> fetchACatagory();

  Catagory deleteCatagory(int catagoryID, String catagoryName, int productFK);

  Catagory createCatagory(int catagoryID, String catagoryName, int productFK);

  Catagory updateCatagory(int catagoryID, String catagoryName, int productPK);

  void deleteCatagoryById(Long catagoryId);

  Catagory updateCatagory(Catagory catagory, Long catagoryId);

  List<Catagory> fetchCatagoryList();

  Catagory saveCatagory(Catagory catagory);















}
