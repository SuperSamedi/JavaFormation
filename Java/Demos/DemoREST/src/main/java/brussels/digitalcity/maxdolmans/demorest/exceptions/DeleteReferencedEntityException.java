package brussels.digitalcity.maxdolmans.demorest.exceptions;

public class DeleteReferencedEntityException extends RuntimeException {
    private final Class<?> clazz;
    private final Object forId;

    public DeleteReferencedEntityException(Class<?> clazz, Object forId) {
        super("Error - Deletion impossible. Entity {" + clazz.getSimpleName() + "} at id {" + forId + "} is still referenced by other entities. Remove the references before trying to delete.");
        this.clazz = clazz;
        this.forId = forId;
    }

    public DeleteReferencedEntityException(String message, Class<?> clazz, Object forId) {
        super(message);
        this.clazz = clazz;
        this.forId = forId;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public Object getForId() {
        return forId;
    }
}
