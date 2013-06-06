package com.github.infinityzero.gwt_sample.tutorials.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TutorialsServiceAsync {
	public void getGwtTutorials(int chapter, int offset, int limit,
			AsyncCallback<String> callback);
}
