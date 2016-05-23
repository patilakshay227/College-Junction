package models;

import java.io.File;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Events;
import entities.MotivationalThought;
import entities.News;
import entities.Photography;
import entities.Poetry;
import entities.Research;
import entities.Skills;
import entities.Videos;
import hibernate.SessionFactoryBuilder;

public class SkillsModels {

	// method to update views
	
	public static void updateView(String skillType,long id){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		
		switch(skillType){
		case "Poetry": 
			Poetry p =  (Poetry)session.get(Poetry.class,id);
			p.setViews(p.getViews()+1);
			session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
			break;
		}
		
	}
	
	// method to fetch my uploads

	@SuppressWarnings("unchecked")
	public static List<Skills> fetchMyUploads(String email) {
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		List<Skills> list = session.createQuery("From Videos where author = :email").setString("email", email).list();
		list.addAll((List<Skills>) session.createQuery("From Poetry where author = :email").setString("email", email)
				.list());
		list.addAll((List<Skills>) session.createQuery("From Photography where author = :email")
				.setString("email", email).list());
		list.addAll((List<Skills>) session.createQuery("From Research where author = :email")
				.setString("email", email).list());
		list.addAll((List<Skills>) session.createQuery("From MotivationalThought where author = :email")
				.setString("email", email).list());
		return list;
	}

	// Videos model start
	
	public static List<Videos> fetchVideos() {
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From Videos order by uploadDate desc";
		Query query = session.createQuery(hql);
		List<Videos> list = query.list();
		return list;
	}

	public static String deleteVideo(long id) {
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg = null;
		try {
			tx = s.beginTransaction();
			Videos v = (Videos) s.get(Videos.class, id);
			File f = new File(
					"F:/Mars Workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/CollegeJunction/videos/"
							+ v.getFileName());
			f.delete();
			s.delete(v);
			tx.commit();
			msg = "Video has been deleted successfully!";

		} catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
			msg = e.getMessage();
		} finally {
			s.close();
		}

		return msg;
	}

	// Videos model end

	// Poetry model starts..

	public static Poetry getPoetry(long id){
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Poetry p = (Poetry) s.get(Poetry.class, id);
		return p;
	}

	public static String deletePoetry(long id) {
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg = null;
		try {
			tx = s.beginTransaction();
			Poetry p = (Poetry) s.get(Poetry.class, id);
			s.delete(p);
			tx.commit();
			msg = "Poem has been deleted successfully!";

		} catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
			msg = e.getMessage();
		} finally {
			s.close();
		}

		return msg;
	}
	// Poetry model ends..

	// Photohraphy model starts..

	public static List<Photography> fetchPhotos() {
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From Photography order by uploadDate";
		Query query = session.createQuery(hql);
		List<Photography> list = query.list();
		return list;
	}

	public static String deletePhotography(long id) {
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg = null;
		try {
			tx = s.beginTransaction();
			Photography p = (Photography) s.get(Photography.class, id);
			s.delete(p);
			tx.commit();
			msg = "Photo has been deleted successfully!";

		} catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
			msg = e.getMessage();
		} finally {
			s.close();
		}

		return msg;
	}
	// Photography model ends..

	// Research Model starts..

	public static Research fetchResearch(long id) {
		Research r = null;
		try {
			SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			r = (Research) session.get(Research.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public static String deleteResearch(long id) {
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg = null;
		try {
			tx = s.beginTransaction();
			Research r = (Research) s.get(Research.class, id);
			s.delete(r);
			tx.commit();
			msg = "Research has been deleted successfully!";

		} catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
			msg = e.getMessage();
		} finally {
			s.close();
		}

		return msg;
	}
	
	// Research Model ends..
	
	// Motivational thought model starts
 		
	public static String deleteMotivationalThought(long id) {
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg = null;
		try {
			tx = s.beginTransaction();
			MotivationalThought mt = (MotivationalThought) s.get(MotivationalThought.class, id);
			s.delete(mt);
			tx.commit();
			msg = "Thought has been deleted successfully!";

		} catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
			msg = e.getMessage();
		} finally {
			s.close();
		}

		return msg;
	}	
	
	//Motivational thought model ends..
	
}
