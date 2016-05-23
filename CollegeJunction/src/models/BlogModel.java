package models;

import java.io.File;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.BlogPost;
import entities.Videos;
import hibernate.SessionFactoryBuilder;

public class BlogModel {
	
	public static List<BlogPost> fetchDeanPosts(String department){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From BlogPost where authorType = 'Dean' and department = :department order by date desc,id desc";
		Query query = session.createQuery(hql);
		query.setString("department", department);
		List<BlogPost> list = query.list();
		return list;
	}
	
	public static List<BlogPost> fetchDirectorPosts(){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From BlogPost where authorType = 'Director' order by date desc,id desc";
		Query query = session.createQuery(hql);
		List<BlogPost> list = query.list();
		return list;
	}
	
	public static List<BlogPost> fetchMyPosts(String name, String authType){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From BlogPost where authorType = :authType and author = :name order by date desc,id desc";
		Query query = session.createQuery(hql);
		query.setString("authType", authType);
		query.setString("name", name);
		List<BlogPost> list = query.list();
		return list;
	}
	
	public static String deletePost(int id){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg = null;
		try {
			tx = s.beginTransaction();
			BlogPost p = (BlogPost) s.get(BlogPost.class, id);
			s.delete(p);
			tx.commit();
			msg = "Post has been deleted successfully!";
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
			msg = e.getMessage();
		} finally {
			s.close();
		}

		return msg;
	}
	
}
