package com.github.infinityzero.gwt_sample.tutorials.client.presenter;

import com.github.infinityzero.gwt_sample.tutorials.client.TutorialsServiceAsync;
import com.github.infinityzero.gwt_sample.tutorials.client.view.TutorialsView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TextBox;

public class TutorialsPresenter implements Presenter {
	public interface View {
		TextBox getTxtChapter();

		Button getBtnSearch();

		Button getBtnReset();

		FlexTable getFlxResult();

		void setResult(String result);
	}

	private TutorialsServiceAsync rpcService;
	private static TutorialsPresenter instance;
	private TutorialsView view;

	public static TutorialsPresenter getInstance(
			TutorialsServiceAsync rpcService) {
		if (instance == null) {
			instance = new TutorialsPresenter(rpcService);
		}

		return instance;
	}

	// prevent from object creation
	private TutorialsPresenter(TutorialsServiceAsync rpcService) {
		this.view = TutorialsView.getInstance();
		this.rpcService = rpcService;
		bind();
	}

	private void bind() {
		getResult();

		view.getBtnSearch().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getSearchCondition();
				getResult();
			}
		});
	}

	// default result
	private void getResult() {
		getResult(null);
	}

	private int chapter = 1;
	private static final int ROW_PER_PAGE = 10;

	private void getSearchCondition() {
		chapter = Integer.parseInt(view.getTxtChapter().getText());
	}

	private void getResult(String pageNo) {
		AsyncCallback<String> callback = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(String result) {
				view.setResult(result);
			}
		};

		rpcService.getGwtTutorials(chapter,
				Integer.parseInt(pageNo == null ? "1" : pageNo), ROW_PER_PAGE,
				callback);
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
	}

}
