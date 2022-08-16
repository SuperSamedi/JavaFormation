package brussels.digitalcity.maxdolmans.models.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor
public class DeckCreateForm {

    @NotBlank
    @Size(max = 255)
    private String name;

}
