package principal.data;

/*
Autor: Alberto López García
Licencia:
Creative commons CC BY-SA 4.0 
https://creativecommons.org/licenses/by-sa/4.0/deed.es
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import principal.dominio.SalaEstudio;

@Repository
public class ModeloSalaEstudio {

    private final SalaEstudioRepository salaEstudioRepository;

    @Autowired
    public ModeloSalaEstudio(SalaEstudioRepository salaEstudioRepository) {
        this.salaEstudioRepository = salaEstudioRepository;
    }

    public void aumentarAforo(int idSala) {
        SalaEstudio salaEstudio = salaEstudioRepository.findById(idSala).orElse(null);
        if (salaEstudio != null) {
            int aforoActual = salaEstudio.getAforoActual();
            salaEstudio.setAforoActual(aforoActual + 1);
            salaEstudioRepository.save(salaEstudio);
        }
    }

    public void disminuirAforo(int idSala) {
        SalaEstudio salaEstudio = salaEstudioRepository.findById(idSala).orElse(null);
        if (salaEstudio != null) {
            int aforoActual = salaEstudio.getAforoActual();
            salaEstudio.setAforoActual(aforoActual - 1);
            salaEstudioRepository.save(salaEstudio);
        }
    }

}
