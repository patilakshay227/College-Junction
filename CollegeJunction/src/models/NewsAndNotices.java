package models;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.News;
import entities.Notices;
import hibernate.SessionFactoryBuilder;
import users.Faculty;

public class NewsAndNotices {

	public static List<News> fetchNews(){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From News order by uploadDate desc";
		Query query = session.createQuery(hql);
		List<News> list = (List<News>)query.list();
		return list;
	}
	
	public static List<Notices> fetchNotices(){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From Notices order by date desc";
		Query query = session.createQuery(hql);
		List<Notices> list = (List<Notices>)query.list();
		return list;
	}
	
	public static String deleteNews(int id){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg=null;
		try{
			tx= s.beginTransaction();
			News n = (News)s.get(News.class, id);
			s.delete(n);
			tx.commit();
			msg= "News has been deleted successfully!";
			
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
			msg = e.getMessage();
		}finally{
			s.close();
		}
		
		return msg;
	}
	
	public static String deleteNotice(int id){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg=null;
		try{
			tx= s.beginTransaction();
			Notices n = (Notices)s.get(Notices.class, id);
			s.delete(n);
			tx.commit();
			msg= "Notice has been deleted successfully!";
			
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
