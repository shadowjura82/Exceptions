public class Main {
    public static void main(String[] args) {
        setCredentials("login", "pass", "pass");
    }

    public static void setCredentials(String login, String password, String confirmPassword) {
        Validator validator = new Validator(login, password, confirmPassword);
        validator.credentialsValidation();
    }
}