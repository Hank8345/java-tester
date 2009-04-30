package org.jtester.utility;

import java.util.Arrays;
import java.util.List;

import org.jtester.dbtest.service.UserService;
import org.jtester.testng.JTester;

/**
 * this test is broken for EclEmma Test
 * 
 * @author darui.wudr
 * 
 */
//@Test(groups = { "JTester" })
public class FindMethodUtilTest extends JTester {
	public void findTestMethod_1() {
		List<String> methods = FindMethodUtil.findTestMethod(UserService.class, "findAddress");
		want.collection(methods).sizeGe(4);
		want.collection(methods).hasItems(
				Arrays.asList("org.jtester.dbtest.service.UserServiceTest_ByInjectedMock.findAddress",
						"org.jtester.dbtest.service.UserServiceTest_Mock1.findAddress"));
	}

	public void findTestMethod_2() {
		List<String> methods = FindMethodUtil.findTestMethod(UserService.class, "getUser");
		want.collection(methods).sizeGe(2);
		want.collection(methods).hasItems(
				Arrays.asList("org.jtester.dbtest.service.UserServiceTest.getUser",
						"org.jtester.dbtest.service.UserServiceTest.getUser_LazyAddress"));
	}
}