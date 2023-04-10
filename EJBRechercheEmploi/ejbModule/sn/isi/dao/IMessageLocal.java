package sn.isi.dao;

import jakarta.ejb.Local; 
import sn.isi.entities.Message;

@Local
public interface IMessageLocal extends RepositoryLocal<Message> {

}
