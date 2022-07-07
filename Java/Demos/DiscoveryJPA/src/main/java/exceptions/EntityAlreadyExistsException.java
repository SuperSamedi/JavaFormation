package exceptions;

public class EntityAlreadyExistsException extends  RuntimeException {
    private final Object id;
    private final Class<?> clazz;

    public EntityAlreadyExistsException(Object id, Class<?> clazz) {
        super("Element already exists with id {" + id + "}");
        this.id = id;
        this.clazz = clazz;
    }
}
