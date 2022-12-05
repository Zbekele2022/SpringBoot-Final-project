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
public class OrderDetails {

private int orderDetailsID;
private int productID;
private int quantityOrdered;
private double priceEach;
private int orderID;
public static Object builder() {
  // TODO Auto-generated method stub
  return null;
}

}

