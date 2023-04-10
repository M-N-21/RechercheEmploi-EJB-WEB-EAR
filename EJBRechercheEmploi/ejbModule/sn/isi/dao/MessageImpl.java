package sn.isi.dao;

import jakarta.ejb.Stateless;
import sn.isi.entities.Message;

@Stateless
public class MessageImpl extends RepositoryImpl<Message> implements IMessageLocal, IMessageRemote {

}
