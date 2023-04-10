package sn.isi.dao;

import jakarta.ejb.Remote; 
import sn.isi.entities.Message;

@Remote
public interface IMessageRemote extends RepositoryRemote<Message> {

}
