package dam.dataValidation;

public class DataValidation {
    private static final String DNI_REGEX = "^\\d{7,9}[A-Z]$";
    private static final String NOMBRE_REGEX = "^[A-Za-z]+ ?[A-Za-z]+ ?[A-Za-z]+$";

    public static boolean isDniValid(String dni) {
        if (dni == null || !dni.matches(DNI_REGEX))
            return false;
        return true;
    }

    public static boolean isNameValid(String name) {
        if (name == null || !name.matches(NOMBRE_REGEX))
            return false;
        return true;
    }

    public static boolean isStringIn(String str, String[] arr) {
        for (String s : arr)
            if (s.equals(str))
                return true;
        return false;
    }

    public static boolean isStringValid(String str) {
        if (str == null)
            return false;
        if (str.trim().length() == 0)
            return false;
        return true;
    }

    public static boolean isNatural(Integer n) {
        return n != null && n > 0;
    }

    public static boolean isNatural(Double n) {
        return n != null && n > 0;
    }

    public static boolean isValidDescription(String desc, int minLen, int maxLen) {
        if (desc == null)
            return false;
        return desc.length() >= minLen && desc.length() <= maxLen;
    }
    public static boolean isValidDescription(String desc, int minLen) {
        return isValidDescription(desc, minLen, Integer.MAX_VALUE);
    }
}
