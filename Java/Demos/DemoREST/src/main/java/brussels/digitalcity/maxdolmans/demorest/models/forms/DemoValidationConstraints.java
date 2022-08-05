package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class DemoValidationConstraints {

    @Min(50)
    @Max(100)
    @Negative
    @NegativeOrZero
    private int integer;

    @NotNull // sur tout type Object
    private Integer nullableInt;

    @NotBlank // = @NotEmpty + @NotNull + at least one non-whitespace
    @NotEmpty
    @NotNull
    @Null
    @Pattern(regexp = "[0-9]{2,4}\\/[0-9]{2,3}\\.[0-9]{2}\\.[0-9]{2}") // Regex pour numéro tel. 0498/65.61.49 // 063/42.47.86 // 02/279.22.11
    private String numTel;

    @Past
    @PastOrPresent
    @Future
    private LocalDateTime time;

    @AssertFalse
    private boolean bool;

    @NotEmpty
    @Size(min = 1, max = 10)
    private List<Object> list;
}
