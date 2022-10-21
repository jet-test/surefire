package one.trifle.trigger.utils;

public class TriggerUtils {
    private static final String EMPTY_STRING = "";
    public static String join(String separator, String... elements) {
        if (elements.length == 0) return EMPTY_STRING;
        final StringBuilder result = new StringBuilder();
        for (String element : elements) {
            result.append(element)
                    .append(separator);
        }
        result.delete(result.length() - separator.length(), result.length());
        return result.toString();
    }
}
