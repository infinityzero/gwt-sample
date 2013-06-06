package com.github.infinityzero.gwt_sample.tutorials.server;

import java.util.List;
import java.util.Map;

import com.github.infinityzero.gwt_sample.tutorials.client.TutorialsService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class TutorialsServiceImpl extends RemoteServiceServlet implements
		TutorialsService {

	private static final long serialVersionUID = 345025593079066379L;

	@Override
	public String getGwtTutorials(int chapter, int offset, int limit) {
		if (chapter <= 0) {
			throw new IllegalArgumentException(
					"Parameter chapter must be greater than 0");
		}
		TutorialsDb db = new TutorialsDb();
		int count = db.selectCountByChapter(chapter);
		List<Map<String, Object>> ret = db.selectTutorialByChapter(chapter,
				offset, limit);
		return "Count:" + count;
	}

}
