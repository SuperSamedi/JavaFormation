package brussels.digitalcity.maxdolmans.utils;

public class StringHelper {

    /**
     * Trims the dirty string and replace all multi white spaces with a single space char.
     * @param dirty The dirty string that needs cleaning.
     * @return The cleaned version of the string.
     */
    public static String clean(String dirty) {

        if (dirty == null || dirty.isEmpty() || dirty.isBlank()) {
            return null;
        }

        return dirty.trim().replaceAll("\\s{2,}", " ");
    }

}
