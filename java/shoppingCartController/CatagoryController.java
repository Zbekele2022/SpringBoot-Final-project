package shoppingCartController;

import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import shoppingCartEntity.Catagory;

@Validated
@RequestMapping("/ShoppingCart/")
@OpenAPIDefinition(info = @Info(title = "Catagory"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

//Catagory controller interface
public interface CatagoryController {


   // Save operation
   Catagory saveCatagory(int CatagoryID, String CatagoryName, int productFK);

   // Read operation
   List<Catagory> fetchCatagoryList(int CatagoryID);

   // Update operation
   Catagory updateCatagory(int CatagoryID,int productPK, Catagory updatedItem);

   // Delete operation
   void deleteCatagoryByID(int CatagoryID, String CatagoryName, int ProductFK);
}










