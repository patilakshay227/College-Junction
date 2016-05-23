package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class SessionFactoryBuilder {
	
	static SessionFactory sf = null;
	
	public static SessionFactory getSessionFactory(){
		
			if(sf==null)
			sf = new AnnotationConfiguration().configure().buildSessionFactory();
		
		return sf;
	}

}
