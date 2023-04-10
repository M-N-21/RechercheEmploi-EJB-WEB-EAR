package sn.isi.dao;

import jakarta.ejb.Remote;
import sn.isi.entities.Contrat; 

@Remote
public interface IContratRemote extends RepositoryRemote<Contrat> {

}
