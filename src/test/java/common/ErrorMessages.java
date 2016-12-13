package common;

public interface ErrorMessages {

    static String createMessage(final String element, String message) {
        return String.format("[%s %s!]", element, message);
    }

    default String forWrong(final String element) {
        return createMessage(element, "is (are) wrong");
    }
}
