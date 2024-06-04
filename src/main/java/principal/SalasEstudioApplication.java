package principal;

/*
Autor: Alberto López García
Licencia:
Creative commons CC BY-SA 4.0 
https://creativecommons.org/licenses/by-sa/4.0/deed.es
 */
import java.awt.List;
import principal.data.SalaEstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import principal.dominio.SalaEstudio;

@SpringBootApplication
public class SalasEstudioApplication implements CommandLineRunner {

    @Autowired
    SalaEstudioRepository salaEstudioRepository;

    public static void main(String[] args) {
        SpringApplication.run(SalasEstudioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("");
        int numSalas = (int) salaEstudioRepository.count();
        System.out.println("Número de salas de estudio: " + numSalas);
        System.out.println("");

        /*Las salas se crean manualmente en la base de datos ya que solo se trata de una suimulación.
        También podrían crearse de la siguiente manera comentada:
        SalaEstudio salaEstudio = new SalaEstudio(50);
        // Guardar            
        salaEstudioRepository.save(salaEstudio);
        System.out.println("Sala guardada en base de datos");

        System.out.println("");*/
    }
}
