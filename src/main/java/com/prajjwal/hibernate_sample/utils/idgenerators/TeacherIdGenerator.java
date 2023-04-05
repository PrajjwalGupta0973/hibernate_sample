package com.prajjwal.hibernate_sample.utils.idgenerators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.prajjwal.hibernate_sample.domain.Teacher;

public class TeacherIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Teacher t = (Teacher) object;
		return t.getIdAppender() + "success";
	}

}
