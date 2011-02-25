package org.doneta;

import junit.framework.TestCase;

import org.doneta.base.dao.impl.BaseDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestDBCPConnection extends TestCase{

	public void test() {
		String[] paths = new String[]{"classpath:applicationContext-common.xml", "classpath:config/base/applicationContext-base.xml"};
		ApplicationContext ctx = new FileSystemXmlApplicationContext(paths); 
		BaseDAO baseDAO = ctx.getBean(BaseDAO.class);
		int i = baseDAO.count("select count(*) from help_category", null);
		System.out.println(i);
		assertTrue(true);
	}
	
}
