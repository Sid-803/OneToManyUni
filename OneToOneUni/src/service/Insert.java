package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;
import entity.TeacherDetails;

public class Insert {

	public static void main(String[] args) {
		System.out.println("Connecting to Database");
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				//if not using mapping tab in xml then we can use:-
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.buildSessionFactory();
		//  System.out.println("created");
		
		Session session = null;
		Transaction tx =null;
		try {
			session = factory.getCurrentSession();
			tx=session.beginTransaction();
		
			Teacher teacher = new Teacher("Ramesh","Jitesh","JRamesh@gmail.com");
			TeacherDetails tempteacherdetails = new TeacherDetails("Mumbai","Biotech");
			teacher.setTeacherdetails(tempteacherdetails);
			session.save(teacher);
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
			factory.close();
		}

	}

}
