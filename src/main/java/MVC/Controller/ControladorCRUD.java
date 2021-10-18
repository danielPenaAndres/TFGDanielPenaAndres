package MVC.Controller;

import MVC.Alumno;
import MVC.DAO.clienteDAO;
import MVC.Entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ControladorCRUD {

    @RequestMapping("/lista")
    public String muestraFormulario(Model modelo){
        //Obtener los clientes desde el DAO
        List<Cliente> losClientes=ClienteDAO.getClientes();
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
        ClienteDAO.insertarClientes(elCliente);
        return "redirect:/cliente/lista";
    }
    @GetMapping("muestraFormularioActualizar")
    public String muestraFormularioActualizar(@RequestParam("clienteId") int id,Model modelo){
        //Obtener cliente
        Cliente elCliente=ClienteDAO.getCliente(id);
        //Obtener el cliente como atributo del modelo
        modelo.addAttribute("cliente",elCliente);
        //enviar al formulario
        return "formularioCliente";
    }
    @GetMapping("eliminar")
    public String eliminarCliente(@RequestParam("clienteId") int id){
        //Eliminar cliente
        ClienteDAO.eliminarCliente(id);
        //Reddirecionnar a lista clientes
        return "redirect:/cliente/lista";
    }

    @Autowired
    private clienteDAO ClienteDAO;
}