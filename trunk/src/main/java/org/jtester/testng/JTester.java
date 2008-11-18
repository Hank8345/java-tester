package org.jtester.testng;

import org.jmock.Expectations;
import org.jtester.unitils.jmock.JmockUnitils;
import org.jtester.unitils.jmock.fluent.IAssertThat;
import org.jtester.unitils.jmock.fluent.impl.ExpectAssertThat;
import org.unitils.UnitilsTestNG;

public class JTester extends UnitilsTestNG implements IAssertThat {

	public static void checking(JExpectations expectations) {
		JmockUnitils.checking(expectations);
	}

	public static class JExpectations extends Expectations {

	}

	protected ExpectAssertThat the() {
		return new ExpectAssertThat();
	}
}