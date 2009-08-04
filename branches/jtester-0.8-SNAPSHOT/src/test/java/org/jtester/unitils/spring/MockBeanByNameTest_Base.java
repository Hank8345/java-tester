package org.jtester.unitils.spring;

import org.jtester.testng.JTester;
import org.testng.annotations.Test;
import org.unitils.spring.annotation.SpringApplicationContext;

@Test(groups = { "jtester", "mockbean" })
@SpringApplicationContext( { "org/jtester/unitils/database/ibatis/spring/beans.xml",
		"org/jtester/unitils/database/ibatis/spring/data-source.xml" })
public class MockBeanByNameTest_Base extends JTester {

}
