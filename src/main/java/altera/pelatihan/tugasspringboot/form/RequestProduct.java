package altera.pelatihan.tugasspringboot.form;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RequestProduct {

    @NotBlank(message = "name is not required")
    @NotNull(message = "name is not null")
    private String name;
    @Min(value = 1, message = "harga harus lebih besar dari 1")
    private Integer harga;
}
