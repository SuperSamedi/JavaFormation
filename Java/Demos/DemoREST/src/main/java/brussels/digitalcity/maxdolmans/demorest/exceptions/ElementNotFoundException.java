package brussels.digitalcity.maxdolmans.demorest.exceptions;

public class ElementNotFoundException extends RuntimeException{

    private final Class<?> clazz;
    private final Object forId;

    public ElementNotFoundException(Class<?> clazz, Object forId) {
        super("Error - Can't find entity {" + clazz.getSimpleName() + "} at id {" + forId + "}.");
        this.clazz = clazz;
        this.forId = forId;
    }

    public ElementNotFoundException(String message, Class<?> clazz, Object forId) {
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
