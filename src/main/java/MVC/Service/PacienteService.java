package MVC.Service;

import MVC.Entity.Paciente;
import MVC.repo.IPacienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private IPacienteRepo repo;

    public Page<Paciente> listAll(int pageNumber,String DNI){
         Pageable pageable=PageRequest.of(pageNumber - 1,10);
        if (DNI!=null){
            return repo.findAll(DNI,pageable);
        }

        return repo.findAll(pageable);
    }

    public List<Paciente> listAll(String DNI){
        if (DNI!=null){
            return repo.findAll(DNI);
        }

        return repo.findAll();
    }
}
