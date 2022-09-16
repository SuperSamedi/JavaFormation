package brussels.digitalcity.maxdolmans.models.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true, doNotUseGetters = true) // Uses the parent's data also for the comparaison
@ToString(callSuper = true)
@Accessors(chain = true, fluent = true, prefix = {"first"}) // Expérimental. For making chains / builder. Only generates chaining on attribute beginning with "first".
@SuperBuilder // Expérimental. Permits to use the builder on a child.
public class Cat extends Animal{
}
