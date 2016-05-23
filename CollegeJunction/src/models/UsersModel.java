package models;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.SessionFactoryBuilder;
import users.Dean;
import users.Director;
import users.Faculty;
import users.Student;
import users.TPO;

public class UsersModel {

	public static String getName(String email){
		String name=null;
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		Faculty f = (Faculty)session.get(Faculty.class, email);
		if(f!=null){
			name = f.getName();
		}else{
			Dean d = (Dean)session.get(Dean.class, email);
			if(d!=null){
				name = d.getName();
			}else{
				Director dir = (Director)session.get(Director.class, email);
				if(dir!=null){
					name= dir.getName();
				}
			}
		}
		return name;
	}
	
	// Method to fetch all registred Stduents from database

		
		
		public static List<Student> fetchAllStudents() {
			SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			String hql = "From Student";
			Query query = session.createQuery(hql);
			List<Student> list = query.list();
			return list;
		}
	
	// Method to fetch faculties from database

	public static List<Faculty> fetchAllFaculties() {
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From Faculty";
		Query query = session.createQuery(hql);
		List<Faculty> list = query.list();
		return list;
	}

	// Method to fetch Deans from databses
	public static List<Dean> fetchAllDeans() {
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From Dean";
		Query query = session.createQuery(hql);
		List<Dean> list = query.list();
		return list;
	}

	// method for fetching director details
	public static Director fetchDirector() {
		Director d = null;
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		String hql = "From Director";
		Query query = session.createQuery(hql);
		List list = query.list();
		if (list.size()>0)
			d = (Director) list.get(0);
		return d;
	}
	
	// method for fetching TPO details
		public static TPO fetchTPO() {
			TPO tpo = null;
			SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			String hql = "From TPO";
			Query query = session.createQuery(hql);
			List list = query.list();
			if (list.size()>0)
				tpo = (TPO) list.get(0);
			return tpo;
		}

	// search user for updation

	public static Object searchUser(String userType, String email) {
		Object user = null;
		SessionFactory sf =  SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		Query query;
		try{
		switch (userType) {
			
			case "Faculty":
				query = session.createQuery("From Faculty f where f.email = :email");
				query.setString("email",email);
				user = (Faculty)query.list().get(0);
				break;
			case "Dean" : 
				query = session.createQuery("From Dean d where d.email = :email");
				query.setString("email",email);
				user = (Dean)query.list().get(0);
				break;
			case "Director": 
				query = session.createQuery("From Director d where d.email = :email");
				query.setString("email",email);
				user = (Director)query.list().get(0);
				break;
			case "TPO": 
				query = session.createQuery("From TPO t where t.email = :email");
				query.setString("email",email);
				user = (TPO)query.list().get(0);
				break;
			
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
		return user;
	}
	
	// method to delete user 
	
	public static String deleteUser(String userType,String email){
		
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		String msg=null;
		
		try{
			
			switch (userType) {
			
			case "Faculty":
				tx= s.beginTransaction();
				Faculty f =  (Faculty)s.get(Faculty.class, email);
				s.delete(f);
				tx.commit();
				msg= "User has been deleted successfully!";
				break;
			case "Dean" : 
				tx= s.beginTransaction();
				Dean d =  (Dean)s.get(Dean.class, email);
				s.delete(d);
				tx.commit();
				msg= "User has been deleted successfully!";
				break;
			case "Director": 
				tx= s.beginTransaction();
				Director dir =  (Director)s.get(Director.class, email);
				s.delete(dir);
				tx.commit();
				msg= "User has been deleted successfully!";
				break;
			case "TPO": 
				tx= s.beginTransaction();
				TPO tpo =  (TPO)s.get(TPO.class, email);
				s.delete(tpo);
				tx.commit();
				msg= "User has been deleted successfully!";
				break;
				
			case "Student":
				tx= s.beginTransaction();
				String hql = "delete From Student where email = :email";
				s.createQuery(hql).setString("email", email).executeUpdate();
				tx.commit();
				msg= "User has been deleted successfully!";
				break;
		}
			
			
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
