package dam.dataValidation;

/**
 * Class with multiple methods to validate information.
 * <br>
 * This way, just by calling a method from this class, the whole validation of the field can be done.
 */
public class DataValidation {

    /**
     * Regex expression to verify DNIs.
     */
    private static final String DNI_REGEX = "^\\d{7,9}[A-Z]$";

    /**
     * Regex expression to verify a phone.
     */
    private static final String PHONE_REGEX = "^(\\+\\d{2,3})? ?\\d{3} ?(\\d{3} ?\\d{3}|\\d{2} ?\\d{2} ?\\d{2})$";

    /**
     * Regex expression to verify an email.
     */
    private static final String MAIL_REGEX = "^[a-z][a-z1-9._-]*@[a-z]+\\.[a-z]{1,3}$";

    /**
     * Regex expression to verify a valid human name.
     */
    private static final String NOMBRE_REGEX = "^[A-Za-z]+( ?[A-Za-z]+( ?[A-Za-z]+)?)?$";


    // Personal information

    /**
     * Verifies that the given DNI is valid.
     * @param dni DNI to verify.
     * @return Result of the analysis.
     */
    public static boolean isDniValid(String dni) {
        return dni != null && dni.matches(DNI_REGEX);
    }

    /**
     * Verifies that the given phone is valid.
     * @param phone Phone to verify.
     * @return Result of the analysis.
     */
    public static boolean isPhoneValid(String phone) {
        return phone == null && phone.matches(PHONE_REGEX);
    }

    /**
     * Verifies that the given email is valid.
     * @param mail Email to verify.
     * @return Result of the analysis.
     */
    public static boolean isMailValid(String mail) {
        return mail == null && mail.matches(MAIL_REGEX);
    }

    /**
     * Verifies that the given name is valid.
     * @param name Name to verify.
     * @return Result of the analysis.
     */
    public static boolean isNameValid(String name) {
        return name != null && name.matches(NOMBRE_REGEX);
    }


    // String

    /**
     * Verifies if the given string is contain inside the given array.
     * @param str String to search.
     * @param arr Array to search into.
     * @return true is found, else false.
     */
    public static boolean isStringIn(String str, String[] arr) {
        for (String s : arr)
            if (s.equals(str))
                return true;
        return false;
    }

    /**
     * Verifies if the given string is not empty.
     * @param str String to verify.
     * @return Result of the analysis.
     */
    public static boolean isStringValid(String str) {
        return str != null && str.trim().length() != 0;
    }

    /**
     * Verifies if the string is valid and if it's inside the length constraints.
     * @param str String to verify.
     * @param minLen Minimum length to match.
     * @param maxLen Maximum length to match.
     * @return Result of the analysis.
     */
    public static boolean isStringValid(String str, int minLen, int maxLen) {
        return isStringValid(str) && str.length() >= minLen && str.length() <= maxLen;
    }

    /**
     * Verifies if the string is valid and if it's inside the length constraints.
     * @param str String to verify.
     * @param minLen Minimum length to match.
     * @return Result of the analysis.
     */
    public static boolean isStringValid(String str, int minLen) {
        return isStringValid(str, minLen, Integer.MAX_VALUE);
    }

    // Numbers

    /**
     * Verifies the given integer is a natural > 0.
     * @param n Natural to verify.
     * @return Result of the analysis.
     */
    public static boolean isNatural(Integer n) {
        return n != null && n > 0;
    }

    /**
     * Verifies the given double is > 0.
     * @param n Double to verify.
     * @return Result of the analysis.
     */
    public static boolean isPositive(Double n) {
        return n != null && n > 0;
    }
}
