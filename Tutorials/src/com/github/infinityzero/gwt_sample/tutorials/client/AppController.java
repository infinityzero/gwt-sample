package com.github.infinityzero.gwt_sample.tutorials.client;

import com.github.infinityzero.gwt_sample.tutorials.client.presenter.Presenter;
import com.github.infinityzero.gwt_sample.tutorials.client.presenter.TutorialsPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {
	private TutorialsServiceAsync rpcService;
	private HasWidgets container;

	public AppController() {
		rpcService = GWT.create(TutorialsService.class); // create rpc service
		History.addValueChangeHandler(this); // register history change handler
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;
			if ("gwt".equals(token)) {
				presenter = TutorialsPresenter.getInstance(rpcService);
			} else if ("jse".equals(token)) {
				// TODO JsePresenter
			}

			if (presenter != null) {
				presenter.go(container);
			}
		}
	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem("gwt"); // default page
		} else {
			History.fireCurrentHistoryState();
		}
	}

}
