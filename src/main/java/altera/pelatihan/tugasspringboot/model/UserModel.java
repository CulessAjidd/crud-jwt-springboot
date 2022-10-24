package altera.pelatihan.tugasspringboot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@Document(collection = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Integer age;
    private String role;
}
