package MVC.validacionesPersonalizadas;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = cPostalMadridValidacion.class)//futura clase que contendra la logica de la validacion
@Target( { ElementType.METHOD, ElementType.FIELD})//destino de nuestra validacion a metodos o campos
@Retention(RetentionPolicy.RUNTIME) //chekea la validacion en tiempo de ejecucion
public @interface cPostalMadrid {
//definir menwsaje por defecto
public String value() default "28";
//definir el msj de error
public String message() default "El codigo postal de debe empezar por 28";
//definir los grupos
Class<?>[] groups() default {};
//definir el payload
Class<? extends Payload>[] payload() default {};
}
