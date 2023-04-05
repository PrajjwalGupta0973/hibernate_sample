package com.prajjwal.hibernate_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.prajjwal.hibernate_sample.domain.ExtendDemo;

@SpringBootApplication
@EnableCaching
public class SpringHibernateExample {
//	public static void main(String[] args) throws InterruptedException {
//		System.out.println("Hello World!");
//		Configuration config = new Configuration();
//		Properties hibernateConfigProp = new Properties();
//		hibernateConfigProp.put(Environment.DRIVER, "org.postgresql.Driver");
//		hibernateConfigProp.put(Environment.URL, "jdbc:postgresql://localhost:5432/hibernate_sample");
//		hibernateConfigProp.put(Environment.USER, "postgres");
//		hibernateConfigProp.put(Environment.PASS, "PrajjwalB4@");
//		hibernateConfigProp.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
//		hibernateConfigProp.put(Environment.SHOW_SQL, Boolean.TRUE);
//		hibernateConfigProp.put(Environment.HBM2DDL_AUTO, "update");
//		hibernateConfigProp.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//		config.setProperties(hibernateConfigProp);
//		config.addAnnotatedClass(Teacher.class);
//		config.addAnnotatedClass(Person.class);
//		SessionFactory sessionFactory = null;
////		sessionFactory = new Configuration().configure().buildSessionFactory();
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
//				.build();
//		sessionFactory = config.addAnnotatedClass(Teacher.class).buildSessionFactory(serviceRegistry);
//		Session session = sessionFactory.openSession();
//
////		Teacher prajjwal = new Teacher("prajjwal", "pj");
////		System.out.println("before: " + prajjwal);
////		Teacher shivam = new Teacher("shivam", "sm");
////		System.out.println(shivam);
////
////		session.beginTransaction();
////		session.save(prajjwal);
////		session.save(shivam);
////		session.getTransaction().commit();
////		System.out.println("after: " + prajjwal);
////
////		Query<Teacher> q = session.getNamedQuery("t.find");
////		List<Teacher> r = q.getResultList();
////		System.out.println("Result:");
////		System.out.println(r);
////
////		System.out.println("Before refresh: " + r.get(0));
//////		Thread.sleep(20000l);
////		session.refresh(r.get(0));
//////		CascadeType
////
////		System.out.println("After refresh: " + r.get(0));
////
////		System.out.println("Get teacher with id 2 : " + session.get(Teacher.class, "pjsuccess"));
//		Person p = new Person("person_firstName", "person_lastName", 29);
//		session.beginTransaction();
//		p.setId(p.new PersonId());
//		session.save(p);
//		session.getTransaction().commit();
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateExample.class, args);
	}

	
	@Bean("extendDemo")
	public ExtendDemo getExtendedDemo() {
		System.out.println("test aw");
		return new ExtendDemo();
	}
}
