package sn.isi.dao;

import jakarta.ejb.Stateless;
import sn.isi.entities.CV;

@Stateless
public class CVImpl extends RepositoryImpl<CV> implements ICVLocal, ICVRemote {

}
