package com.finastra.oidcclient.rest;

import com.finastra.oidcclient.domain.UtilisateurDTO;
import com.finastra.oidcclient.entities.Utilisateur;
import com.finastra.oidcclient.service.UtilisateurService;
import com.finastra.oidcclient.utils.UtilisateurModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UtilisateurController {

    private final UtilisateurService utilisateurService;


    public UtilisateurController(UtilisateurService utilisateurService ) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/utilisateurs")
    public ResponseEntity<List<UtilisateurDTO>> getUtilisateurs() {

/*        Object[] ret = new UtilisateurDTO[1];
        ret[0] = new UtilisateurDTO("Moez","Mejri","MME","moez@gmail.com","test123");
        return ret;
 */      return  utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/utilisateurs/{login}")
    public ResponseEntity<UtilisateurDTO> getTutorialByLogin(@PathVariable("login") String login) {

        return utilisateurService.findByLogin (login);

    }

    @PostMapping("/utilisateurs/create")
    public ResponseEntity createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {

        return utilisateurService.createUtilisateur(utilisateurDTO);
    }

    @PutMapping("/utilisateurs/{login}")
    public ResponseEntity<UtilisateurDTO> updateTutorial(@PathVariable("login") String login, @RequestBody UtilisateurDTO tutorial) {

        return utilisateurService.updateUtilisateur(login, tutorial);
    }

    @DeleteMapping("/utilisateurs/{login}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("login") String login) {
            return utilisateurService.deleteByLogin(login);

    }

}