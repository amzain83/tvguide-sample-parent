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
package com.acme.gwt.client;

import com.acme.gwt.shared.TvGuideRequest;
import com.acme.gwt.shared.TvSetupRequest;
import com.acme.gwt.shared.TvViewerProxy;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

/**
 * RequestFactory stub for the TvGuide server calls
 *
 * @author colin
 */
public interface TvGuideRequestFactory extends RequestFactory {
	TvViewerProxy.TvViewerRequest makeLoginRequest();

	TvGuideRequest makeGuideRequest();

	TvSetupRequest makeSetupRequest();
}
