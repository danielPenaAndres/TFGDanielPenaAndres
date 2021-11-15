package MVC.Controller;

import MVC.Alumno;
import MVC.DAO.clienteDAO;
import MVC.Entity.Cliente;
import MVC.repo.IClienteRepo;
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

    @Autowired
    private IClienteRepo repo;

    @RequestMapping("/lista")
    public String muestraFormulario(Model modelo){
        //Obtener los clientes desde el DAO
        List<Cliente> losClientes=repo.findAll();
        //Agregar clientes desde al modelo
        modelo.addAttribute("clientes",losClientes);
        return "lista-clientes";
    }

    @RequestMapping("/muestraFormularioAgregar")
    public String muestraFormularioAgregar(Model modelo){
        //Bind de datos
        Cliente elCliente=new Cliente();
        modelo.addAttribute("cliente",elCliente);
        return "formularioCliente";
    }

    @PostMapping("insertarCliente")
    public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente){
        repo.save(elCliente);
        return "redirect:/paciente/lista";
    }
    @GetMapping("muestraFormularioActualizar")
    public String muestraFormularioActualizar(@RequestParam("clienteId") long id,Model modelo){
        //Obtener cliente
        int miId=(int)id;
        Cliente elCliente=repo.getById(miId);
        //Obtener el cliente como atributo del modelo
        modelo.addAttribute("cliente",elCliente);
        //enviar al formulario
        return "formularioCliente";
    }
    @GetMapping("eliminar")
    public String eliminarCliente(@RequestParam("clienteId") long id){
        //Eliminar cliente
        int miId=(int)id;
        repo.deleteById(miId);
        //Reddirecionnar a lista clientes
        return "redirect:/paciente/lista";
    }

    @Autowired
    private clienteDAO ClienteDAO;
}