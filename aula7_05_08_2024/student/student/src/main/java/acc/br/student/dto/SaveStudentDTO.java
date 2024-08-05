package acc.br.student.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SaveStudentDTO {

    @NotBlank(message = "O campo id não pode ser vazio.")
    private String id;

    @NotBlank(message = "O campo id não pode ser vazio.")
    private String age;

    @NotBlank(message = "O campo id não pode ser vazio.")
    private String name;

    @NotBlank(message = "O campo id não pode ser vazio.")
    @Email
    private String email;
}
