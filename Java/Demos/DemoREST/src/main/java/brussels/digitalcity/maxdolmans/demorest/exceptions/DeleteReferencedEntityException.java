package brussels.digitalcity.maxdolmans.demorest.exceptions;

import java.util.Set;

public class DeleteReferencedEntityException extends RuntimeException {

    private final Class<?> referencedBy;
    private final Set<Object> referencers;

    public DeleteReferencedEntityException(Class<?> referencedBy, Set<Object> referencers) {
        super("Error - Deletion impossible. Entity is still referenced by at least one entity {" + referencedBy.getSimpleName() + "} at these ids: " + referencers);
        this.referencedBy = referencedBy;
        this.referencers = Set.copyOf(referencers);
    }

    public Set<Object> getReferencers() {
        return referencers;
    }

    public Class<?> getReferencedBy() {
        return referencedBy;
    }
}
