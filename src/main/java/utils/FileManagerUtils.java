package utils;

public final class FileManagerUtils {

    private FileManagerUtils() {
    }

    public static String getFrameworkPath(){
        return System.getProperty("user.dir");
    }
}
