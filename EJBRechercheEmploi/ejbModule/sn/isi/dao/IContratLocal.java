package sn.isi.dao;

import jakarta.ejb.Local; 
import sn.isi.entities.Contrat;

@Local
public interface IContratLocal extends RepositoryLocal<Contrat> {

}
