package MVC.DAO;

import MVC.Entity.Cliente;

import java.util.List;

public interface clienteDAO {
    public void insertarClientes(Cliente elCliente);

    public List<Cliente> getClientes();


    public Cliente getCliente(int id);

    public void eliminarCliente(int id);
}
