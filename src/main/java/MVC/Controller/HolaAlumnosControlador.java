package MVC.Controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/principal")
public class HolaAlumnosControlador {
    //PropocionaFormulario
    @RequestMapping("/muestraFormulario")
    public String muestraFormulario(){
        return "HolaAlumnosFormulario";
    }
    @RequestMapping("/procesarFormulario")
    public String procesarFormulario(){
    return "HolaAlumnosSpring";
    }
    @RequestMapping("/procesarFormulario2")
    //public String otroProcesoFormulario(HttpServletRequest request, Model modelo){
    public String otroProcesoFormulario(@RequestParam ("nombreAlumno") String nombre, Model modelo){
        //String nombre=request.getParameter("nombreAlumno");
        nombre+=" es el mejor alumno";
        String mensajeFinal="Quien es el mejor alumno? "+nombre;
        // agregar info al modelo
        modelo.addAttribute("mensajeClaro",mensajeFinal);
        return "HolaAlumnosSpring";
    }

    @InitBinder
    public void miBinder(WebDataBinder binder){
        StringTrimmerEditor recortaEspacios=new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class,recortaEspacios);
    }
}
