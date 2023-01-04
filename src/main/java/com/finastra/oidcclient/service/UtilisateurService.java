package com.finastra.oidcclient.service;

import com.finastra.oidcclient.domain.UtilisateurDTO;
import com.finastra.oidcclient.entities.Utilisateur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UtilisateurService {

    ResponseEntity<List<UtilisateurDTO>> getAllUtilisateurs() ;

    ResponseEntity createUtilisateur(UtilisateurDTO utilisateurDTO);

    ResponseEntity<UtilisateurDTO> findByLogin(String login);

    ResponseEntity<UtilisateurDTO> updateUtilisateur(String login, UtilisateurDTO tutorial);

    ResponseEntity<HttpStatus> deleteByLogin(String login);
}
