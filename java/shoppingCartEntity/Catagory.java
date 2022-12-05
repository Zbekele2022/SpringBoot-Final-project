package shoppingCartEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Catagory {

  private int CatagoryID;
  private String CatagoryName;
  private int ProductId;


}
