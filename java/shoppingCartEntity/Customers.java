package shoppingCartEntity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EntityScan
public class Customers {

//begins the process by labeling what the different variables
 //can be within the Customer table

  private int CustomerID;
  private String LastName;
  private String FirstName;
  private String Address;
  private String City;
  private String Phone;
  private int OrderID;
  public static Object builder() {
    // TODO Auto-generated method stub
    return null;
  }
 
  }




