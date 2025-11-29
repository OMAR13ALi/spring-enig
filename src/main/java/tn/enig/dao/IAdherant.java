package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enig.model.Adherant;
import tn.enig.model.Livre;

@Repository
public interface IAdherant extends JpaRepository<Adherant, Integer> {
    public Adherant getAdherantByLivre(Livre livre);
}
