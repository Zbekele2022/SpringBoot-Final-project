package shoppingCartController;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ch.qos.logback.core.status.Status;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import shoppingCartEntity.Order;

@Validated
@RestController
@RequestMapping("/ShoppingCart")
@OpenAPIDefinition(info =@Info(title ="Order"), servers = {
    @Server(url = "http://localhost:8080", description = "local server.")})

public interface OrderController {

  //Begins by telling

      //@formatter:off
      @Operation(
          summary = "Returns a Order  By order number",
          description = "Returns a list of customer all first and last name",
          responses = {
              @ApiResponse(
                  responseCode = "200",
                  description = "An Order  is returned",
                  content = @Content(
                      mediaType = "application/json",
                      schema = @Schema(implementation = Order.class))),
         @ApiResponse(
                 responseCode = "400",
                 description = "The request parameters are invalid",
                 content = @Content(mediaType = "application/json")),
         @ApiResponse(
                 responseCode = "404",
                 description = "No Order  were found with the input criteria",
                 content = @Content(mediaType = "application/json")),
         @ApiResponse(
               responseCode = "500",
               description = "An unplanned error occurred.",
               content = @Content(mediaType = "application/json"))
     }
     )
     @GetMapping("/all")
     @ResponseStatus(code = HttpStatus.OK)
     List<Order> fetchAllOrder ();


//     parameters = {
//         @Parameter(name = "Status",
//             allowEmptyValue = false,
//             required = false,
//             description = "The Status (i.e., 'Awaiting_Arrival')")
    // }

 //this is for gets not deletes, postmapping, deletemapping etc for the methods
 @GetMapping
 @ResponseStatus(code = HttpStatus.OK)
 List<Order> fetchOrderAllOrders(@RequestParam(required = false)
     Status status);

         //@formatter:on


         //all
         //@formatter:off
         @Operation(
               summary = "Returns all Order ",
               description = "Returns a List of Order ",
               responses = {
           @ApiResponse(
               responseCode = "200",
               description = "A List of all Order  is returned",
               content = @Content(
               mediaType = "application/json",
               schema = @Schema(implementation = Order.class))),
           @ApiResponse(
               responseCode = "400",
               description = "The request parameters are invalid",
               content = @Content(mediaType = "application/json")),
           @ApiResponse(
               responseCode = "404",
               description = "No Order  were found with the input criteria",
               content = @Content(mediaType = "application/json")),
           @ApiResponse(
               responseCode = "500",
               description = "An unplanned error occurred.",
               content = @Content(mediaType = "application/json"))
               }
             )
         //this is for gets not deletes, postmapping, deletemapping etc for the methods
         @GetMapping("/all")
         @ResponseStatus(code = HttpStatus.OK)
         List<Order> fetchAllOrders();
           //@formatter:on


         //POST
         //Create Method Orders
         //@formatter:off
         @Operation(
               summary = "Returns a new Order ",
               description = "Returns a Order  given a first and last name",
               responses = {
           @ApiResponse(
               responseCode = "201",
               description = "A new Order  has been created",
               content = @Content(
                   mediaType = "application/json",
                   schema = @Schema(implementation = Order.class))),
           @ApiResponse(
               responseCode = "400",
               description = "The request parameters are invalid",
               content = @Content(mediaType = "application/json")),
           @ApiResponse(
               responseCode = "404",
               description = "No Order  component was not found with the input criteria",
               content = @Content(mediaType = "application/json")),//maybe reword
           @ApiResponse(
               responseCode = "500",
               description = "An unplanned error occurred.",
               content = @Content(mediaType = "application/json"))
               },
           parameters = {
               @Parameter(name = "orderFK",
                   allowEmptyValue = false,
                   required = false,
                   description = "The order id (i.e., '1,2,3')"),
               @Parameter(name = "description",
                   allowEmptyValue = false,
                   required = false,
                   description = "The description (i.e., 'Reason they came there')"),
               @Parameter(name = "status",
                 allowEmptyValue = false,
                 required = false,
                 description = "A status (i.e., 'AWAITING_ARRIVAL etc')"),
               @Parameter(name = "estimatedCost",
                 allowEmptyValue = false,
                 required = false,
                 description = "estimatedCost (i.e., '135')"),
               @Parameter(name = "actualCost",
                 allowEmptyValue = true, //Will not make it null this will be fixed with further development
                 required = true,
                 description = "actual Cost can be null (i.e., '152')")
   }

       )
     @PostMapping("/Create")
     @ResponseStatus(code = HttpStatus.CREATED)
     Order createOrder(int customerFK, String description, Status status,
         BigDecimal estimatedCost, BigDecimal actualCost);
         //@formatter:on



         //Deletes Customer
         //deleteCustomer
         //@formatter:off
         @Operation(
             summary = "Deletes an Order ",
             description = "Deletes an Customer given an id",
             responses = {
       @ApiResponse(
             responseCode = "200",
             description = "Order  was deleted",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = Order.class))),
       @ApiResponse(
             responseCode = "400",
             description = "The request parameters are invalid",
             content = @Content(mediaType = "application/json")),
       @ApiResponse(
             responseCode = "404",
             description = "No Order  were found with the input criteria",
             content = @Content(mediaType = "application/json")),
       @ApiResponse(
             responseCode = "500",
             description = "An unplanned error occurred.",
             content = @Content(mediaType = "application/json"))
   },
        parameters = {
            @Parameter(name = "orderPK",
                allowEmptyValue = true,
                required = true,
                description = "orderPK (i.e., 3)"),
             }
             )
         //this is for gets not deletes, post mapping, delet emapping etc for the methods
         @DeleteMapping("/orderPK")
         @ResponseStatus(code = HttpStatus.OK)
         void deleteOrder(int deleteId);

         //@formatter:on


         //PUT Update
         //updateOrder
         //@formatter:off
         @Operation(
             summary = "Returns an updated Order",
             description = "Returns Order to update given an id",
             responses = {
     @ApiResponse(
           responseCode = "200",
           description = "An updated Order is returned",
           content = @Content(
             mediaType = "application/json",
             schema = @Schema(implementation = Order.class))),
     @ApiResponse(
           responseCode = "400",
           description = "The request parameters are invalid",
           content = @Content(mediaType = "application/json")),
     @ApiResponse(
           responseCode = "404",
           description = "No Orders were found with the input criteria",
           content = @Content(mediaType = "application/json")),
     @ApiResponse(
           responseCode = "500",
           description = "An unplanned error occurred.",
           content = @Content(mediaType = "application/json"))
          },
      parameters = {
          @Parameter(name = "orderPK",
              allowEmptyValue = true,
              required = true,
              description = "The Order's Id within our database")
             }
             )

         @PutMapping
         @ResponseStatus(code = HttpStatus.OK)
         Order updateOrder(
             int orderPK,
             @Valid @RequestBody Order updatedOrder);

         List<Order> fetchOrder(int orderFK);

         //@formatter:on

      }
