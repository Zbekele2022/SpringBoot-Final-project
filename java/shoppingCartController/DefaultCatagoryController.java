package shoppingCartController;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import shoppingCartEntity.Catagory;
import shoppingCartService.CatagoryService;

//Annotation
@RestController
//Class
public class DefaultCatagoryController  implements CatagoryController {

   @Autowired
   private CatagoryService catagoryService;

   // Save operation
   @PostMapping("/catagorys")

   public Catagory saveCatagory(
       @Valid @RequestBody Catagory catagory)
   {
       return catagoryService.saveCatagory(catagory);
   }

   // Read operation
   @GetMapping("/catagory")

   public List<Catagory> fetchCatagoryList()
   {
       return catagoryService.fetchCatagoryList();
   }

   // Update operation
   @PutMapping("/catagory/{id}")
   public Catagory
   updateCatagory(@RequestBody Catagory catagory,
       @PathVariable("id") Long catagoryId) {
       return catagoryService.updateCatagory(catagory, catagoryId);
   }

   // Delete operation
   @DeleteMapping("/catagorys/{id}")

   public String deleteCatagoryById(@PathVariable("id")Long catagoryId)
   {
       catagoryService.deleteCatagoryById(catagoryId);
       return "Deleted Successfully";
   }

  @Override
  public Catagory saveCatagory(int CatagoryID, String CatagoryName, int productFK) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Catagory> fetchCatagoryList(int CatagoryID) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Catagory updateCatagory(int CatagoryID, int productPK, Catagory updatedItem) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteCatagoryByID(int CatagoryID, String CatagoryName, int ProductFK) {
    // TODO Auto-generated method stub

  }
}







