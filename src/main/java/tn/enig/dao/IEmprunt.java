package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enig.model.Emprunt;

@Repository
public interface IEmprunt extends JpaRepository<Emprunt, Integer> {
}
