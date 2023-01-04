package com.finastra.oidcclient.service.impl;

import com.finastra.oidcclient.domain.UtilisateurDTO;
import com.finastra.oidcclient.entities.Utilisateur;
import com.finastra.oidcclient.repository.UtilisateurRepository;
import com.finastra.oidcclient.service.UtilisateurService;
import com.finastra.oidcclient.utils.UtilisateurModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurModelMapper utilisateurModelMapper;

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public ResponseEntity<List<UtilisateurDTO>> getAllUtilisateurs() {
        try{
            List<UtilisateurDTO> list = utilisateurRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

}

    @Override
    public ResponseEntity createUtilisateur(UtilisateurDTO utilisateurDTO) {
        try {
            Utilisateur newUser = utilisateurRepository
                    .save(utilisateurModelMapper.map( utilisateurDTO, Utilisateur.class));
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<UtilisateurDTO> findByLogin(String login) {
        Optional<Utilisateur> accountRes = utilisateurRepository.findByLogin(login);

        if (accountRes.isPresent()) {
            return new ResponseEntity<>(utilisateurModelMapper.map(accountRes.get() , UtilisateurDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<UtilisateurDTO> updateUtilisateur(String login, UtilisateurDTO utilisateurDTO) {
        Optional<Utilisateur> utilisateurData =
                utilisateurRepository.findByLogin(login);

        if (utilisateurData.isPresent()) {
            Utilisateur _utilisateur = utilisateurData.get();
            _utilisateur.setFirstName(utilisateurDTO.getFirstName());
            _utilisateur.setLastName(utilisateurDTO.getLastName());
            return new ResponseEntity<>(utilisateurModelMapper.map(utilisateurRepository.save(_utilisateur), UtilisateurDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    }

    @Override
    public ResponseEntity<HttpStatus> deleteByLogin(String login) {
        try {
            utilisateurRepository.deleteByLogin(login);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private UtilisateurDTO convertToDto(Utilisateur utilisateur) {
        UtilisateurDTO utilisateurDTO = utilisateurModelMapper.map(utilisateur, UtilisateurDTO.class);
        //postDto.setSubmissionDate(utilisateur.getSubmissionDate(),
        //        userService.getCurrentUser().getPreference().getTimezone());
        return utilisateurDTO;
    }

    private Utilisateur convertToEntity(UtilisateurDTO utilisateurDTO) throws ParseException {
        Utilisateur utilisateur = utilisateurModelMapper.map(utilisateurDTO, Utilisateur.class);
        // utilisateur.setSubmissionDate(postDto.getSubmissionDateConverted(
        //        userService.getCurrentUser().getPreference().getTimezone()));

     /*   if (postDto.getId() != null) {
            Utilisateur oldPost = postService.getPostById(postDto.getId());
            utilisateur.setRedditID(oldPost.getRedditID());
            utilisateur.setSent(oldPost.isSent());
        }

      */
        return utilisateur;
    }
}
