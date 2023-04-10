package sn.isi.dao;

import jakarta.ejb.Local; 
import sn.isi.entities.Personne;

@Local
public interface IPersonneLocal extends RepositoryLocal<Personne> {
	public Personne login(String username, String password);
    public Personne getByUsername(String email);
}
