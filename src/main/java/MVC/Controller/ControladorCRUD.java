package MVC.Controller;

import MVC.Alumno;
import MVC.DAO.pacienteDAO;
import MVC.Entity.paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/paciente")
public class ControladorCRUD {

    @RequestMapping("/lista")
    public String muestraFormulario(Model modelo){
        //Obtener los pacientes desde el DAO
        List<paciente> lospacientes=pacienteDAO.getpacientes();
        //Agregar pacientes desde al modelo
        modelo.addAttribute("pacientes",lospacientes);
        return "lista-pacientes";
    }

    @RequestMapping("/muestraFormularioAgregar")
    public String muestraFormularioAgregar(Model modelo){
        //Bind de datos
        paciente elpaciente=new paciente();
        modelo.addAttribute("paciente",elpaciente);
        return "formulariopaciente";
    }

    @PostMapping("insertarpaciente")
    public String insertarpaciente(@ModelAttribute("paciente") paciente elpaciente){
        pacienteDAO.insertarpacientes(elpaciente);
        return "redirect:/paciente/lista";
    }
    @GetMapping("muestraFormularioActualizar")
    public String muestraFormularioActualizar(@RequestParam("pacienteId") long id,Model modelo){
        //Obtener paciente
        paciente elpaciente=pacienteDAO.getpaciente(id);
        //Obtener el paciente como atributo del modelo
        modelo.addAttribute("paciente",elpaciente);
        //enviar al formulario
        return "formulariopaciente";
    }
    @GetMapping("eliminar")
    public String eliminarpaciente(@RequestParam("pacienteId") long id){
        //Eliminar paciente
        pacienteDAO.eliminarpaciente(id);
        //Reddirecionnar a lista pacientes
        return "redirect:/paciente/lista";
    }

    @Autowired
    private pacienteDAO pacienteDAO;
}