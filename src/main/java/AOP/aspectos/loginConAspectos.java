package AOP.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loginConAspectos {
   // @Pointcut("execution(public * insertaCliente*(..))")
    @Pointcut("execution(* AOP.DAO.*.*(..))")
    private void paraClientes(){}


    //Pointcut getters
    @Pointcut("execution(* AOP.DAO.*.get*(..))")
    private void paraGetters(){};


    //Pointcut setters
    @Pointcut("execution(* AOP.DAO.*.set*(..))")
    private void paraSetters(){};


    //Pointcut combinacion
    @Pointcut("paraClientes()&&!(paraSetters())")
    private void paraCombinacion(){};


    //@Before("paraClientes()")
    @Before("paraCombinacion()")
    public void antesInsertarCliente(){
        System.out.println("el usuario esta logeado");
        System.out.println("El login es correcto");
    }
    //@Before("paraClientes()")
    public void requisitosCliente(){
        System.out.println("El cliente cumple los requisitos para ser insertado en la BBDD");
    }
    //@Before("paraClientes()")
    public void requisitosTabla(){
        System.out.println("Hay menos de 3000 registros, Puedes insertar el nuevo cliente");
    }
}
