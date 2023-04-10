package sn.isi.dao;

import jakarta.ejb.Remote; 
import sn.isi.entities.Offre;

@Remote
public interface IOffreRemote extends RepositoryRemote<Offre> {

}
