package sn.isi.dao;

import jakarta.ejb.Stateless;
import sn.isi.entities.Contrat;

@Stateless
public class ContratImpl extends RepositoryImpl<Contrat> implements IContratLocal, IContratRemote {

}
