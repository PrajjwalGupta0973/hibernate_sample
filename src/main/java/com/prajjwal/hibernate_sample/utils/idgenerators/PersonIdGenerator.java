package com.prajjwal.hibernate_sample.utils.idgenerators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.prajjwal.hibernate_sample.domain.Person;

public class PersonIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Person person = (Person) object;
		
		return "person_id";
	}
}
