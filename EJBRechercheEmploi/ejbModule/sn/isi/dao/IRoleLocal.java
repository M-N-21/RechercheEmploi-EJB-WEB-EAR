package sn.isi.dao;

import jakarta.ejb.Local;  
import sn.isi.entities.Role;

@Local
public interface IRoleLocal extends RepositoryLocal<Role> {

}
