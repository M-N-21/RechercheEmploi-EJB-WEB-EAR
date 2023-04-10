package sn.isi.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.Stateless;
import sn.isi.entities.Personne;

@Stateless
public class PersonneImpl extends RepositoryImpl<Personne> implements IPersonneLocal, IPersonneRemote {

	@Override
	public Personne login(String email, String password) {
		List<Personne> personnes = new ArrayList<>();
        Personne i = new Personne();
        personnes = this.list(i);
        for (Personne ing : personnes) {
            if(ing.getEmail().equals(email) && ing.getPassword().equals(password)) {
                return ing;
            }
        }
        return null;
	}

	@Override
	public Personne getByUsername(String email) {
		return (Personne) em.createQuery("FROM Personne personne WHERE personne.email = :email")
                .setParameter("email", email);
	}

}
