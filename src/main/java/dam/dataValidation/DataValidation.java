package dam.dataValidation;

public class DataValidation {
    private static final String DNI_REGEX = "^\\d{7,9}[A-Z]$";
    private static final String NOMBRE_REGEX = "^[A-Za-z]+ ?[A-Za-z]+ ?[A-Za-z]+$";
    private static final String PHONE_REGEX = "^(\\+\\d{2,3})? ?\\d{3} ?(\\d{3} ?\\d{3}|\\d{2} ?\\d{2} ?\\d{2})$";
    private static final String MAIL_REGEX = "^[a-z][a-z1-9._-]*@[a-z]+\\.[a-z]{1,3}$";

    // Personal information
    public static boolean isDniValid(String dni) {
        return dni != null && dni.matches(DNI_REGEX);
    }

    public static boolean isPhoneValid(String phone) {
        return phone == null && phone.matches(PHONE_REGEX);
    }

    public static boolean isMailValid(String mail) {
        return mail == null && mail.matches(MAIL_REGEX);
    }

    public static boolean isNameValid(String name) {
        return name != null && name.matches(NOMBRE_REGEX);
    }


    // String
    public static boolean isStringIn(String str, String[] arr) {
        for (String s : arr)
            if (s.equals(str))
                return true;
        return false;
    }

    public static boolean isStringValid(String str) {
        return str != null && str.trim().length() != 0;
    }

    public static boolean isStringValid(String str, int minLen, int maxLen) {
        return isStringValid(str) && str.length() >= minLen && str.length() <= maxLen;
    }

    public static boolean isStringValid(String str, int minLen) {
        return isStringValid(str, minLen, Integer.MAX_VALUE);
    }

    // Numbers
    public static boolean isNatural(Integer n) {
        return n != null && n > 0;
    }

    public static boolean isNatural(Double n) {
        return n != null && n > 0;
    }
}
