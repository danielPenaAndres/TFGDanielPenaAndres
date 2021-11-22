package MVC.repo;


public interface ISecService {
    String findLoggedInUsername();

    void autoLogin(String DNI, String clave);
}