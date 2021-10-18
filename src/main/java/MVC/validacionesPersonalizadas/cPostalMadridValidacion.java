package MVC.validacionesPersonalizadas;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class cPostalMadridValidacion implements ConstraintValidator <cPostalMadrid, String> {

    @Override
    public void initialize(cPostalMadrid elCodigo) {
        prefijoCodigoMadrid=elCodigo.value();
    }

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext constraintValidatorContext) {
        boolean valCodigo;
        if (arg0!=null) {valCodigo=arg0.startsWith(prefijoCodigoMadrid);}
        else {return valCodigo=true;}

        return valCodigo;
    }
    private String prefijoCodigoMadrid;
}
