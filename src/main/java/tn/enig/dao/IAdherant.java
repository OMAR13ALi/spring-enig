package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enig.model.Adherant;

@Repository
public interface IAdherant extends JpaRepository<Adherant, Integer> {
}
