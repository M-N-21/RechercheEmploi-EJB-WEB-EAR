package sn.isi.dao;

import jakarta.ejb.Remote; 
import sn.isi.entities.Role;

@Remote
public interface IRoleRemote extends RepositoryRemote<Role> {

}
