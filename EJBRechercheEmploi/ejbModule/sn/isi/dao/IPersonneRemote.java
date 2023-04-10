package sn.isi.dao;

import jakarta.ejb.Remote; 
import sn.isi.entities.Personne;

@Remote
public interface IPersonneRemote extends RepositoryRemote<Personne> {
	public Personne login(String username, String password);
    public Personne getByUsername(String email);
}
