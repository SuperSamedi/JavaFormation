package brussels.digitalcity.maxdolmans.exceptions;

public class ElementNotFoundException extends RuntimeException {

    private final Class<?> clazz;
    private final Object forId;

    public ElementNotFoundException(Class<?> clazz, Object forId) {
        super("Error - Could not find an entity {" + clazz.getSimpleName() + "} at id {" + forId + "}.");
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
