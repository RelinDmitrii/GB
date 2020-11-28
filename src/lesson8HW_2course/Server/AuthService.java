package lesson8HW_2course.Server;

public interface AuthService {
    /**
     *
     * @return - nickname если пользователь есть, null если пользователья нет
     */
    String getNicknameByLoginAndPassword(String login, String password);

}
