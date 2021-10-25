package AOP.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loginConAspectos {
   // @Pointcut("execution(public * insertapaciente*(..))")
    @Pointcut("execution(* AOP.DAO.*.*(..))")
    private void parapacientes(){}


    //Pointcut getters
    @Pointcut("execution(* AOP.DAO.*.get*(..))")
    private void paraGetters(){};


    //Pointcut setters
    @Pointcut("execution(* AOP.DAO.*.set*(..))")
    private void paraSetters(){};


    //Pointcut combinacion
    @Pointcut("parapacientes()&&!(paraSetters())")
    private void paraCombinacion(){};


    //@Before("parapacientes()")
    @Before("paraCombinacion()")
    public void antesInsertarpaciente(){
        System.out.println("el usuario esta logeado");
        System.out.println("El login es correcto");
    }
    //@Before("parapacientes()")
    public void requisitospaciente(){
        System.out.println("El paciente cumple los requisitos para ser insertado en la BBDD");
    }
    //@Before("parapacientes()")
    public void requisitosTabla(){
        System.out.println("Hay menos de 3000 registros, Puedes insertar el nuevo paciente");
    }
}
