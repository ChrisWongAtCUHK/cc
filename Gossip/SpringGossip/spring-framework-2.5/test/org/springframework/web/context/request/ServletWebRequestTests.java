/*
 * Copyright 2002-2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.context.request;

import java.util.Locale;
import java.util.Map;

import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Juergen Hoeller
 * @since 26.07.2006
 */
public class ServletWebRequestTests extends TestCase {

	public void testParameters() {
		MockHttpServletRequest servletRequest = new MockHttpServletRequest();
		servletRequest.addParameter("param1", "value1");
		servletRequest.addParameter("param2", "value2");
		servletRequest.addParameter("param2", "value2a");

		ServletWebRequest request = new ServletWebRequest(servletRequest);
		assertEquals("value1", request.getParameter("param1"));
		assertEquals(1, request.getParameterValues("param1").length);
		assertEquals("value1", request.getParameterValues("param1")[0]);
		assertEquals("value2", request.getParameter("param2"));
		assertEquals(2, request.getParameterValues("param2").length);
		assertEquals("value2", request.getParameterValues("param2")[0]);
		assertEquals("value2a", request.getParameterValues("param2")[1]);

		Map paramMap = request.getParameterMap();
		assertEquals(2, paramMap.size());
		assertEquals(1, ((String[]) paramMap.get("param1")).length);
		assertEquals("value1", ((String[]) paramMap.get("param1"))[0]);
		assertEquals(2, ((String[]) paramMap.get("param2")).length);
		assertEquals("value2", ((String[]) paramMap.get("param2"))[0]);
		assertEquals("value2a", ((String[]) paramMap.get("param2"))[1]);
	}

	public void testLocale() {
		MockHttpServletRequest servletRequest = new MockHttpServletRequest();
		servletRequest.addPreferredLocale(Locale.UK);

		ServletWebRequest request = new ServletWebRequest(servletRequest);
		assertEquals(Locale.UK, request.getLocale());
	}

}
