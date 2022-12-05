package shoppingCartEntity;

import java.sql.Date;
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
public class Order {

private int orderNumber;
private Date orderDate;
private Date requiredDate;
private Date shippedDate;
private String status;
private String comments;
private int customerNumber;
public static Object builder() {
  // TODO Auto-generated method stub
  return null;
}
}


