package MVC.DAO;

import MVC.Entity.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class clienteDAOClase implements clienteDAO{

    @Override
    @Transactional
    public void insertarClientes(Cliente elCliente) {
        try {
            Session miSesion=sessionFactory.openSession();
            //Insertar el cliente
            //miSesion.save(elCliente);
            Transaction tx = miSesion.beginTransaction();
            miSesion.saveOrUpdate(elCliente);
            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public List<Cliente> getClientes() {
        //Obtenser Session
        Session miSesion=sessionFactory.openSession();
        //Crear Consulta
        Query<Cliente> miQuery=miSesion.createQuery("from Cliente",Cliente.class);
         //ejecutar query
        List<Cliente> clientes=miQuery.getResultList();

        return clientes;
    }

    @Override
    @Transactional
    public Cliente getCliente(long id) {
        Session miSesion=sessionFactory.openSession();
        //Obterner informacion del cliente selecionado
        Cliente elCliente=miSesion.get(Cliente.class,id);
        return elCliente;
    }

    @Override
    @Transactional
    public void eliminarCliente(long id) {
        Session miSesion=sessionFactory.openSession();
        Transaction tx = miSesion.beginTransaction();
        //Borrar el cliente de la base de datos usando su id correspondiente
        Query consulta=miSesion.createQuery("delete from Cliente where id=:idDelCliente");
        consulta.setParameter("idDelCliente",id);
        consulta.executeUpdate();
        tx.commit();
    }


    @Autowired
    private SessionFactory sessionFactory;
}
