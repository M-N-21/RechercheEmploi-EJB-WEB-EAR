package sn.isi.dao;

import jakarta.ejb.Remote;
import sn.isi.entities.DetailOffre;

@Remote
public interface IDetailOffreRemote extends RepositoryRemote<DetailOffre> {

}
