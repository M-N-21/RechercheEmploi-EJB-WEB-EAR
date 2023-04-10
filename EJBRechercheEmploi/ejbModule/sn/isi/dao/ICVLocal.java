package sn.isi.dao;

import jakarta.ejb.Local;
import sn.isi.entities.CV;

@Local
public interface ICVLocal extends RepositoryLocal<CV> {

}
