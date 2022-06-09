package discordbotqa.intrebari;

import discordbotqa.Utilitati;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ControlerIntrebari {

    @Autowired
    private EntitateIntrebariRepository entitateIntrebariRepository;

    @PostMapping
    public ResponseEntity creazaIntrebare(@RequestParam("token") String token, @RequestParam("intrebare") String question, @RequestParam("raspuns") Boolean value) {
        if (token.equalsIgnoreCase(Utilitati.iaTokenSpecial())) {
            EntitateIntrebari entitateIntrebari = new EntitateIntrebari();
            entitateIntrebari.setIntrebare(question);
            entitateIntrebari.setRaspuns(value);
            entitateIntrebariRepository.save(entitateIntrebari);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping
    public ResponseEntity iaIntrebari() {
        return new ResponseEntity<>(entitateIntrebariRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity stergeIntrebare(@RequestParam("token") String token, @RequestParam("id") int id) {
        if (token.equalsIgnoreCase(Utilitati.iaTokenSpecial())) {
            if (entitateIntrebariRepository.existsById(id)) {
                entitateIntrebariRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping
    public ResponseEntity modificaRaspuns(@RequestParam("token") String token, @RequestParam("id") int id, @RequestParam("raspuns") boolean response) {
        if (token.equalsIgnoreCase(Utilitati.iaTokenSpecial())) {
            if (entitateIntrebariRepository.existsById(id)) {
                EntitateIntrebari q = entitateIntrebariRepository.findById(id).get();
                q.setRaspuns(response);
                entitateIntrebariRepository.save(q);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    public List<EntitateIntrebari> listaIntrebari() {
        return (List<EntitateIntrebari>) entitateIntrebariRepository.findAll();
    }


}
