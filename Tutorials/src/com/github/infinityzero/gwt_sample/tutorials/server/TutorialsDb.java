package com.github.infinityzero.gwt_sample.tutorials.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.dev.util.collect.HashMap;

public class TutorialsDb {
	private static List<Map<String, Object>> DB = new ArrayList<Map<String, Object>>();
	static {
		for (int i = 0; i < 100; i++) {
			Map<String, Object> tutorial = new HashMap<String, Object>();
			tutorial.put("chapter", i);
			tutorial.put("title", "Getting Start");
			tutorial.put("brief", "In May 2006, Google released the GWT...");
			DB.add(tutorial);
		}
	}

	public List<Map<String, Object>> selectTutorialByChapter(int chapter,
			int offset, int limit) {
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();

		for (int i = offset; i < limit; i++) {
			if (limit > DB.size()) {
				break;
			}
			ret.add(DB.get(i));
		}

		return ret;
	}

	public Integer selectCountByChapter(int chapter) {
		return DB.size();
	}
}
