/**
 * Tutorials.java
 */
package com.github.infinityzero.gwt_sample.tutorials.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point class.
 * 
 * @author Zeyar
 */
public class Tutorials implements EntryPoint {

	/**
	 * Starting point of this project.
	 */
	@Override
	public void onModuleLoad() {
		AppController appViewer = new AppController();
		appViewer.go(RootPanel.get());
	}

}