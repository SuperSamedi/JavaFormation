package brussels.digitalcity.maxdolmans.models.entities;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.NonFinal;

import java.time.LocalDate;
import java.util.List;

@ToString
//@Getter @Setter
@EqualsAndHashCode(of = {"name", "species", "dateOfBirth"})
@NoArgsConstructor(onConstructor_ = {@Deprecated()}, force = true, staticName = "newInstance", access = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor // Generates a constructor with all the required attriutes (finals, @NonNulls,)
public class Animal {

//    public final int nb_instance; // knows it will have a value due to the 'force = true' configuration of the @NoArgsConstructor (default value of 0 in this case)

    public final static Animal instance = Animal.newInstance();

    @Getter @Setter
    @ToString.Exclude
    private Long id;

    @Getter @Setter
    private String name;

    @Getter(onMethod_ = {
            @Deprecated(since = "2000-12-06")
    })
    @Setter
    @Builder.Default // uses this default value in a builder if not specified in the build.
    private String species = "doggy";

    @Getter @Setter( onParam_ = { @NonNull, @NonFinal } )
    private LocalDate dateOfBirth;

    @Getter(lazy = true) // gets the info only when needed /used?
    private final String heavyTraitment = this.heavyFunction();

    // ???
    private transient String moodOfTheDay; // Pas créé en mémoire si pas utilisé

    @Singular
    private List<String> cries; // Attention au liste avec getter et setter générésl

    @Builder
    public Animal(String name) {
        this.name = name;
    }

    private String heavyFunction() {
        try {
            Thread.sleep(3000);
        }
        catch (Exception e) {

        }
        return "Hello there...";
    }

}
