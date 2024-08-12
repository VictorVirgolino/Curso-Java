package acc.br.model;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Pessoa extends PanacheEntity {

    public String nome;
    public int idade;

    // Construtor padrão
    public Pessoa() {}

    // Construtor com parâmetros
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método de exemplo para encontrar uma pessoa pelo nome
    public static Pessoa findByName(String nome) {
        return find("nome", nome).firstResult();
    }

    // Método de exemplo para listar todas as pessoas acima de uma certa idade
    public static List<Pessoa> findOlderThan(int idade) {
        return list("idade > 21", idade);
    }
}
