import java.util.regex.Pattern;

public class AuthenticationValidator {
    private static final Pattern regex = Pattern.compile("^[A-Za-z0-9_]{0,20}$");
    public static void checkAuthentication(String login,
                                           String password,
                                           String confirmPassword) throws WrongLoginException {
        checkLogin(login);
        checkPassword(password);
        equalsPassword(password, confirmPassword);
    }
    private static void checkLogin(String login) throws WrongLoginException{
        if (!login.matches(regex.pattern())) {
            {
                throw new WrongLoginException("Login содержит в себе только латинские буквы," +
                        " цифры и знак подчеркивания" +
                        " и должен быть не более 20 символов");
            }
        }
    }
    private static void checkPassword (String password)  throws WrongPasswordException{
        if (!password.matches((regex.pattern()))) {
            {
                throw new WrongPasswordException("password содержит в себе только латинские буквы," +
                        " цифры и знак подчеркивания" +
                        " и должен быть не более 20 символов");
            }
        }
    }
    private static void equalsPassword(String password, String confirmPassword)
            throws WrongPasswordException {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}