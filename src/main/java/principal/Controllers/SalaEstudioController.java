package principal.Controllers;

/*
Autor: Alberto López García
Licencia:
Creative commons CC BY-SA 4.0 
https://creativecommons.org/licenses/by-sa/4.0/deed.es
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import principal.dominio.SalaEstudio;
import principal.data.SalaEstudioRepository;

@RestController
@RequestMapping("/api/salas")
public class SalaEstudioController {

    @Autowired
    private SalaEstudioRepository salaEstudioRepository;

    @GetMapping("/{id}/aforo")
    public ResponseEntity<Integer> obtenerAforoSala(@PathVariable Integer id) {

        SalaEstudio sala = salaEstudioRepository.findById(id).orElse(null);

        if (sala != null) {
            int aforo = sala.getAforoActual();

            if (aforo <= 0) {
                return ResponseEntity.badRequest().body(null); // Aforo negativo           
            } else {
                return ResponseEntity.ok(aforo); // Aforo válido
            }
        } else {
            System.out.println("Sala no encontrada con ID: " + id);
            return ResponseEntity.notFound().build(); // Sala no encontrada
        }
    }
}
