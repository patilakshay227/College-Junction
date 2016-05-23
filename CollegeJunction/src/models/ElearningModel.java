package models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Ebooks;
import entities.VideoLectures;
import entities.Workshops;
import hibernate.SessionFactoryBuilder;

public class ElearningModel {
	
	public static List<Ebooks> fetchNewlyAddedEbooks(){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From Ebooks order by id desc";
		List<Ebooks> list = session.createQuery(hql).setMaxResults(10).list();
		return list;
	}
	
	public static List<Ebooks> fetchMyEbooks(String email){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From Ebooks where uploader = :email order by id desc";
		List<Ebooks> list = session.createQuery(hql).setString("email", email).list();
		return list;
	}
	
	public static List<VideoLectures> fetchMyVideoLectures(String email){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From VideoLectures where uploader = :email order by id desc";
		List<VideoLectures> list = session.createQuery(hql).setString("email", email).list();
		return list;
	}
	
	public static String deleteEbook(int id){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg=null;
		try{
			tx= s.beginTransaction();
			Ebooks w = (Ebooks)s.get(Ebooks.class, id);
			s.delete(w);
			tx.commit();
			msg= "Ebook has been deleted successfully!";
			
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
			msg = e.getMessage();
		}finally{
			s.close();
		}
		
		return msg;
	}
	
	public static String deleteVideoLecture(int id){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg=null;
		try{
			tx= s.beginTransaction();
			VideoLectures vl = (VideoLectures)s.get(VideoLectures.class, id);
			s.delete(vl);
			tx.commit();
			msg= "Video Lecture has been deleted successfully!";
			
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
