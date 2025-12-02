package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enig.model.Adherant;
import tn.enig.model.Emprunt;
import tn.enig.model.Livre;

import java.util.List;

@Repository
public interface IEmprunt extends JpaRepository<Emprunt, Integer> {
    List<Emprunt> findByAdherant(Adherant adherant);
    List<Emprunt> findByLivre(Livre livre);
}
