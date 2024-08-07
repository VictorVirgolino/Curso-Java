package com.accenture.aluno.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name= "Victor Arruda Câmara Virgolino",
                        email= "victorvirgolino@gmail.com",
                        url= "https://github.com/VictorVirgolino"
                ),
                description = "Swagger para aplicação Aluno",
                title = "Swagger - Aluno",
                version = "1.0.0",
                license = @License(
                        name = "Licença teste",
                        url = "https://teste.com"
                ),
                termsOfService = "Termos de Serviço"
        ),
        servers = {
                @Server(
                        description = "Localhost",
                        url = "http://localhost:8080"
                )
        }
)
public class SwaggerConfig {

}