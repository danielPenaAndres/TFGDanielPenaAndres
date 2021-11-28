package MVC.Service;

import MVC.Entity.Paciente;
import MVC.Entity.Episodio;
import MVC.repo.IPacienteRepo;
import MVC.repo.IEpisodioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodioService {
    @Autowired
    private IEpisodioRepo repo;

    public Page<Episodio> listAll(int pageNumber, String servicio){
         Pageable pageable=PageRequest.of(pageNumber - 1,5);

        if (servicio!=null){
            return repo.findAll(servicio,pageable);
        }

        return repo.findAll(pageable);
    }

    public List<Episodio> listAll(String servicio){
        if (servicio!=null){
            return repo.findAll(servicio);
        }

        return repo.findAll();
    }
}
