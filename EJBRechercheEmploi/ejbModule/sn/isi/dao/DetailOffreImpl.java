package sn.isi.dao;

import jakarta.ejb.Stateless;
import sn.isi.entities.DetailOffre;

@Stateless
public class DetailOffreImpl extends RepositoryImpl<DetailOffre> implements IDetailOffreLocal, IDetailOffreRemote {

}
