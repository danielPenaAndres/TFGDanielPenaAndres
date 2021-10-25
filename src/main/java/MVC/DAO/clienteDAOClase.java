package MVC.DAO;

import MVC.Entity.paciente;
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
public class pacienteDAOClase implements pacienteDAO{

    @Override
    @Transactional
    public void insertarpacientes(paciente elpaciente) {
        try {
            Session miSesion=sessionFactory.openSession();
            //Insertar el paciente
            //miSesion.save(elpaciente);
            Transaction tx = miSesion.beginTransaction();
            miSesion.saveOrUpdate(elpaciente);
            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public List<paciente> getpacientes() {
        //Obtenser Session
        Session miSesion=sessionFactory.openSession();
        //Crear Consulta
        Query<paciente> miQuery=miSesion.createQuery("from paciente",paciente.class);
         //ejecutar query
        List<paciente> pacientes=miQuery.getResultList();

        return pacientes;
    }

    @Override
    @Transactional
    public paciente getpaciente(long id) {
        Session miSesion=sessionFactory.openSession();
        //Obterner informacion del paciente selecionado
        paciente elpaciente=miSesion.get(paciente.class,id);
        return elpaciente;
    }

    @Override
    @Transactional
    public void eliminarpaciente(long id) {
        Session miSesion=sessionFactory.openSession();
        Transaction tx = miSesion.beginTransaction();
        //Borrar el paciente de la base de datos usando su id correspondiente
        Query consulta=miSesion.createQuery("delete from paciente where id=:idDelpaciente");
        consulta.setParameter("idDelpaciente",id);
        consulta.executeUpdate();
        tx.commit();
    }


    @Autowired
    private SessionFactory sessionFactory;
}
