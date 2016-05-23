package models;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Events;
import entities.News;
import entities.Workshops;
import hibernate.SessionFactoryBuilder;

public class EventsModel {
	
	public static List<Events> fetchEvents(){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From Events order by date";
		Query query = session.createQuery(hql);
		List<Events> list = (List<Events>)query.list();
		return list;
	}
	
	public static String deleteEvent(int id){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg=null;
		try{
			tx= s.beginTransaction();
			Events e = (Events)s.get(Events.class, id);
			s.delete(e);
			tx.commit();
			msg= "Event has been deleted successfully!";
			
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
			msg = e.getMessage();
		}finally{
			s.close();
		}
		
		return msg;
	}
	
	public static List<Workshops> fetchWorkshops(){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From Workshops order by date";
		Query query = session.createQuery(hql);
		List<Workshops> list = (List<Workshops>)query.list();
		return list;
	}
	
	public static String deleteWorkshop(int id){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg=null;
		try{
			tx= s.beginTransaction();
			Workshops w = (Workshops)s.get(Workshops.class, id);
			s.delete(w);
			tx.commit();
			msg= "Workshop has been deleted successfully!";
			
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
			msg = e.getMessage();
		}finally{
			s.close();
		}
		
		return msg;
	}
}
