package org.jtester.unitils.dbwiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jtester.utility.FindClazUtil;

public class DataWikiUnitils {
	private List<WikiTableMeta> metas = new ArrayList<WikiTableMeta>();
	private WikiTableMeta currMeta = null;

	public String wiki(Class<?> claz, String wikiFile) {
		try {
			String file = FindClazUtil.finePackageDir(claz) + "/" + wikiFile;
			InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			String line = reader.readLine();
			while (line != null) {
				if (!isTable(line)) {
					line = reader.readLine();
					continue;
				}
				parseTable(line);
				line = reader.readLine();
			}
			return WikiTableUtil.parseMetas(this.metas);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static final String schema_regex = "\\|\\s*table\\s*\\|.*\\|";

	public void parseTable(String line) {
		if (line.matches(schema_regex)) {
			tableStatus = TableStatus.SCHEMA;
			this.currMeta = new WikiTableMeta();
			this.metas.add(this.currMeta);
			WikiTableUtil.parseSchema(this.currMeta, line);
		} else if (tableStatus == TableStatus.SCHEMA) {
			tableStatus = TableStatus.HEADER;
			WikiTableUtil.parseHeader(this.currMeta, line);
		} else if (tableStatus == TableStatus.HEADER || tableStatus == TableStatus.FIELD) {
			tableStatus = TableStatus.FIELD;
			WikiTableUtil.parseFields(this.currMeta, line);
		} else {
			tableStatus = TableStatus.NONE;
		}
	}

	private static final String table_regex = "(\\|[^\\|]*)+\\|?";

	public boolean isTable(String line) {
		return line.matches(table_regex);
	}

	private TableStatus tableStatus = TableStatus.NONE;

	private static enum TableStatus {
		SCHEMA, HEADER, FIELD, NONE;
	}
}
