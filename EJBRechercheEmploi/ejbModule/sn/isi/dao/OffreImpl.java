package sn.isi.dao;

import jakarta.ejb.Stateless;
import sn.isi.entities.Offre;

@Stateless
public class OffreImpl extends RepositoryImpl<Offre> implements IOffreLocal, IOffreRemote {

}
