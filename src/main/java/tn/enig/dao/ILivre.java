package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enig.model.Adherant;
import tn.enig.model.Livre;

import java.util.List;

@Repository
public interface ILivre extends JpaRepository<Livre, Integer> {
    public List <Livre>  getLivreByAdeherant(Adherant adherant);
}
