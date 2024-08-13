package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import connection.dbconnection;
import model.user;



public class userdao {

	Transaction tx = null;
	Session session = null;
	List<user> list = null;
	user u = null;
	
	public void insertuser(user u) {
		Session session = new dbconnection().createsession();
		tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
	}
	
	public user dologin(user u) {
		try {
			session = new dbconnection().createsession();
			tx = session.beginTransaction();
			Query  q = session.createQuery("from user u where u.email=:email and u.password=:password ");
			q.setParameter("email", u.getEmail());
			q.setParameter("password", u.getPassword());
			list =q.list();
			u = list.get(0);
			tx.commit();
			session.close();
			
			
		   
		} catch (Exception e) {
			// TODO: handle exception
			u = null;
			e.printStackTrace();
		}
		return u;
	}
	public user getuserbyid(int uid) {
		try {
			session = new dbconnection().createsession();
			tx = session.beginTransaction();
			Query  q = session.createQuery("from userBean u where u.uid=:uid ");
			q.setParameter("uid", uid);
			list = q.list();
			u = list.get(0);
			session.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		 u = null;
		 e.printStackTrace();
		}
		return u;
	}
}
