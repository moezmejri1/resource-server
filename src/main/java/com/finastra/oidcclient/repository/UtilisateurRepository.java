package com.finastra.oidcclient.repository;

import com.finastra.oidcclient.domain.UtilisateurDTO;
import com.finastra.oidcclient.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findByLogin(String login);

    void deleteByLogin(String login);
}
