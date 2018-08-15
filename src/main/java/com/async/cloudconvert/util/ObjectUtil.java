package com.async.cloudconvert.util;

/**
 * @author Ankit Singh
 */
public final class ObjectUtil {
    public static final char EXTENSION_SEPARATOR = '.';
    private static final int NOT_FOUND = -1;
    private static final char WINDOWS_SEPARATOR = '\\';
    private static final char UNIX_SEPARATOR = '/';

    private ObjectUtil() {
        throw new AssertionError("No com.async.cloudconvert.util.ObjectUtil instances for you!");
    }

    public static void requireNonEmpty(CharSequence value, String message) {
        if (value == null || value.length() == 0)
            throw new IllegalArgumentException(message);

    }

    public static String getExtension(final String filename) {
        if (filename == null) {
            return null;
        }
        final int index = indexOfExtension(filename);
        if (index == NOT_FOUND) {
            return "";
        } else {
            return filename.substring(index + 1);
        }
    }

    public static int indexOfExtension(final String filename) {
        if (filename == null) {
            return NOT_FOUND;
        }
        final int extensionPos = filename.lastIndexOf(EXTENSION_SEPARATOR);
        final int lastSeparator = indexOfLastSeparator(filename);
        return lastSeparator > extensionPos ? NOT_FOUND : extensionPos;
    }

    public static int indexOfLastSeparator(final String filename) {
        if (filename == null) {
            return NOT_FOUND;
        }
        final int lastUnixPos = filename.lastIndexOf(UNIX_SEPARATOR);
        final int lastWindowsPos = filename.lastIndexOf(WINDOWS_SEPARATOR);
        return Math.max(lastUnixPos, lastWindowsPos);
    }

}
