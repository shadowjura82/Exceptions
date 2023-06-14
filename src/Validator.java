public class Validator {
    private String login;
    private String password;
    private String confirmPassword;

    public Validator(String login, String password, String confirmPassword) {
        this.login = login.toLowerCase();
        this.password = password.toLowerCase();
        this.confirmPassword = confirmPassword.toLowerCase();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setLogin(String login) {
        this.login = login.toLowerCase();
    }

    public void setPassword(String password) {
        this.password = password.toLowerCase();
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword.toLowerCase();
    }

    public void credentialsValidation() {
        try {
            if (login.length() > 20) throw new WrongLoginException("Логин не должен быть больше 20 символов");
            if (password.length() > 20 || confirmPassword.length() > 20)
                throw new WrongPasswordException("Пароль не должен быть больше 20 символов");
            if (!password.equals(confirmPassword)) throw new WrongPasswordException("Пароли не совпадают");
            if (charactersValidation(login)) throw new WrongLoginException("Логин содержит недопустимые символы");
            if (charactersValidation(password))
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            if (charactersValidation(confirmPassword))
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
        } catch (WrongLoginException e) {
            System.out.println("Проблема с логином. " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("Проблема с паролем. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Что-то пошло не так :(");
        }
    }

    private boolean charactersValidation(String string) {
        String exampleString = "abcdefghijklmnopqrstuvwxyz1234567890_";
        char[] chars = string.toCharArray();
        for (char ch : chars)
            if (!exampleString.contains(String.valueOf(ch))) return true;
        return false;
    }
}
