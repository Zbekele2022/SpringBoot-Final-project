package shoppingCartEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

private int ProductID;
private String ProductName;
private String Catagory;
private String Description;
private int CategoryID;
private double Price;
private int QuantityInStock;
public static Object builder() {
  // TODO Auto-generated method stub
  return null;
}
public Object getProductFK() {
  // TODO Auto-generated method stub
  return null;
}

}





