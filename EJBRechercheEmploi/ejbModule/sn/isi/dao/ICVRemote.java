package sn.isi.dao;

import jakarta.ejb.Remote;
import sn.isi.entities.CV;

@Remote
public interface ICVRemote extends RepositoryRemote<CV> {

}
