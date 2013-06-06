package com.github.infinityzero.gwt_sample.tutorials.client.view;

import com.github.infinityzero.gwt_sample.tutorials.client.presenter.TutorialsPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class TutorialsView extends Composite implements TutorialsPresenter.View {

	private static TutorialsViewUiBinder uiBinder = GWT
			.create(TutorialsViewUiBinder.class);

	interface TutorialsViewUiBinder extends UiBinder<Widget, TutorialsView> {
	}

	@UiField
	TextBox txtChapter;
	@UiField
	Button btnSearch;
	@UiField
	Button btnReset;
	@UiField
	FlexTable flxResult;

	private static TutorialsView instance;

	public static TutorialsView getInstance() {
		if (instance == null) {
			instance = new TutorialsView();
		}

		return instance;
	}

	private TutorialsView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public TextBox getTxtChapter() {
		return this.txtChapter;
	}

	@Override
	public Button getBtnSearch() {
		return this.btnSearch;
	}

	@Override
	public Button getBtnReset() {
		return this.btnReset;
	}

	@Override
	public FlexTable getFlxResult() {
		return this.flxResult;
	}

	@Override
	public void setResult(String result) {
	}

}
