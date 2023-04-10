package sn.isi.dao;

import jakarta.ejb.Remote;
import sn.isi.entities.Categorie;

@Remote
public interface ICategorieRemote extends RepositoryRemote<Categorie> {

}
