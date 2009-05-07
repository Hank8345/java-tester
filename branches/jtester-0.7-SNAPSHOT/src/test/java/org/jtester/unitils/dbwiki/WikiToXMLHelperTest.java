package org.jtester.unitils.dbwiki;

import org.jtester.testng.JTester;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikiToXMLHelperTest extends JTester {
	private WikiTableMeta meta = null;

	@BeforeMethod
	public void setup() {
		this.meta = new WikiTableMeta();
	}

	@Test
	public void parseSchema() {
		want.string(meta.getSchemaName()).isNull();
		WikiToXMLHelper.parseSchema(meta, "|table|mytable||");
		want.object(meta).propertyEq("schemaName", "mytable");
	}

	@Test(expectedExceptions = { RuntimeException.class })
	public void parseSchema_fail1() {
		want.string(meta.getSchemaName()).isNull();
		WikiToXMLHelper.parseSchema(meta, "table|mytable||");
	}

	@Test(expectedExceptions = { RuntimeException.class })
	public void parseSchema_fail2() {
		want.string(meta.getSchemaName()).isNull();
		WikiToXMLHelper.parseSchema(meta, "mytable");
	}

	@Test(expectedExceptions = { RuntimeException.class })
	public void parseSchema_fail3() {
		want.string(meta.getSchemaName()).isNull();
		WikiToXMLHelper.parseSchema(meta, null);
	}

	@Test
	public void parseHeader() {
		
	}
}