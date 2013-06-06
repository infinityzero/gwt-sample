package com.github.infinityzero.gwt_sample.tutorials.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("tutorialsService")
public interface TutorialsService extends RemoteService {

	String getGwtTutorials(int chapter, int offset, int limit);

}
