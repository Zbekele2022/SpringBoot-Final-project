package shoppingCartController;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/ShoppingCart/")
@OpenAPIDefinition(info = @Info(title = "Catagory"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public class RepositoryException {

}
