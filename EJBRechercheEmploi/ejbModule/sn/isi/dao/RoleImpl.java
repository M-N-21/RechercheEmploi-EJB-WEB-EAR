package sn.isi.dao;

import jakarta.ejb.Stateless;
import sn.isi.entities.Role;

@Stateless
public class RoleImpl extends RepositoryImpl<Role> implements IRoleLocal, IRoleRemote {

}
