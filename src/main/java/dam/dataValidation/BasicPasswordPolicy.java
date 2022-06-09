package dam.dataValidation;

import java.util.function.Predicate;

/**
 * Basic password policy with some rules.
 *
 * @author jkutkut
 */
public class BasicPasswordPolicy extends PasswordPolicy {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 20;

    private static final String SPECIAL_CHARACTERS = "&+_*";

    private static final Predicate<String> FT_NN = (s) -> s != null;
    private static final Predicate<String> FT_MIN_L = (s) -> s.length() >= MIN_LENGTH;
    private static final Predicate<String> FT_MAX_L = (s) -> s.length() <= MAX_LENGTH;

    public BasicPasswordPolicy() {
        super();
        addDefaultTests();
    }

    private void addDefaultTests() {
        addTest(FT_NN, "La contraseña no puede ser nula.");
        addTest(FT_MIN_L, "La contraseña tiene que tener al menos " + MIN_LENGTH + " caracteres.");
        addTest(FT_MAX_L, "La contraseña tiene que tener como mucho " + MAX_LENGTH + " caracteres.");

        addContainsAtLeast(SPECIAL_CHARACTERS, "La contraseña tiene que tener al menos un caracter especial (" + SPECIAL_CHARACTERS + ").");
        addContainsAtLeast(NUMBERS, "La contraseña tiene que tener al menos un número.");
        addContainsAtLeast(LOWER_LETTERS, "La contraseña tiene que contener una minúscula.");
        addContainsAtLeast(UPPER_LETTERS, "La contraseña tiene que contener una mayúscula.");

        String errorDis = "¿Enserio? ¿Una constraseña en 2022 así?";
        addDistinctString("1234", errorDis);
        addDistinctString("password", errorDis);
        addDistinctString("constaseña", errorDis);
        addDistinctString("hola", errorDis);
        addDistinctString("user", errorDis);
        addDistinctString("root", errorDis);
        addDistinctString("admin", errorDis);
    }
}
