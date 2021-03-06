/**
 *  Copyright 2011 Colin Alworth
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.acme.gwt.client.widget;

import java.util.List;

import com.acme.gwt.client.TvGuideRequestFactory;
import com.acme.gwt.client.view.WelcomeView;
import com.acme.gwt.shared.TvShowProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;

/**
 * @author colin
 * 
 */
@Singleton
public class WelcomeWidget extends Composite
		implements
			RequiresResize,
			WelcomeView {
	interface FavoritesDriver
			extends
				RequestFactoryEditorDriver<List<TvShowProxy>, FavoriteShowsListWidget> {
	}

	private static WelcomeWidgetUiBinder uiBinder = GWT
			.create(WelcomeWidgetUiBinder.class);

	interface WelcomeWidgetUiBinder extends UiBinder<Widget, WelcomeWidget> {
	}

	FavoritesDriver driver = GWT.create(FavoritesDriver.class);

	@UiField
	LayoutPanel layoutPanel;

	@UiField(provided = true)
	FavoriteShowsListWidget listView;

	@Inject
	public WelcomeWidget(TvGuideRequestFactory rf,
			FavoriteShowsListWidget listView) {
		this.listView = listView;
		initWidget(uiBinder.createAndBindUi(this));

		// Attach the data - easy way to bind a views editor to something
		// accessible from a presenter
		driver.initialize(rf, listView);
	}

	public RequestFactoryEditorDriver<List<TvShowProxy>, ?> getDriver() {
		return driver;
	}

	@Override
	public void onResize() {
		// ?
	}

	@Override
	public void setPresenter(Presenter p) {
		// useless, ignore it
	}
}
