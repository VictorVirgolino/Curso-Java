package acc.br;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.core.Application;

@OpenAPIDefinition(//
        tags = { //
                @Tag(name = "tutorial", description = "Exemplo de estudo."), //
                @Tag(name = "products", description = "manipulação de produtos.")//
        }, //
        info = @Info(//
                title = "Cadastro de produtos", //
                version = "1.0.0", //
                contact = @Contact(//
                        name = "Fale com o Aleatório", //
                        url = "")), //
        servers = { //
                @Server(url = "http://localhost:8080")//
        }) //
public class Descricao extends Application {

}