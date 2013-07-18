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

package org.springframework.web.servlet.view.velocity;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

/**
 * Convenience subclass of UrlBasedViewResolver that supports VelocityView
 * (that is Velocity templates) and custom subclasses of it.
 *
 * <p>The view class for all views generated by this resolver can be specified
 * via <code>setViewClass</code>. See UrlBasedViewResolver's javadoc for details.
 *
 * <p><b>Note:</b> When chaining ViewResolvers, a VelocityViewResolver always needs
 * to be last, as it will attempt to resolve any view name, no matter whether
 * the underlying resource actually exists.
 *
 * @author Juergen Hoeller
 * @since 13.12.2003
 * @see #setViewClass
 * @see #setPrefix
 * @see #setSuffix
 * @see #setRequestContextAttribute
 * @see #setExposeSpringMacroHelpers
 * @see #setVelocityFormatterAttribute
 * @see #setDateToolAttribute
 * @see #setNumberToolAttribute
 * @see VelocityView
 */
public class VelocityViewResolver extends AbstractTemplateViewResolver {

	private String velocityFormatterAttribute;

	private String dateToolAttribute;

	private String numberToolAttribute;

	private String toolboxConfigLocation;


	/**
	 * Sets default viewClass to <code>requiredViewClass</code>.
	 * @see #setViewClass
	 * @see #requiredViewClass
	 */
	public VelocityViewResolver() {
		setViewClass(requiredViewClass());
	}

	/**
	 * Requires VelocityView.
	 * @see VelocityView
	 */
	protected Class requiredViewClass() {
		return VelocityView.class;
	}

	/**
	 * Set the name of the VelocityFormatter helper object to expose in the
	 * Velocity context of this view, or <code>null</code> if not needed.
	 * VelocityFormatter is part of the standard Velocity distribution.
	 * @see org.apache.velocity.app.tools.VelocityFormatter
	 * @see VelocityView#setVelocityFormatterAttribute
	 */
	public void setVelocityFormatterAttribute(String velocityFormatterAttribute) {
		this.velocityFormatterAttribute = velocityFormatterAttribute;
	}

	/**
	 * Set the name of the DateTool helper object to expose in the Velocity context
	 * of this view, or <code>null</code> if not needed. DateTool is part of Velocity Tools 1.0.
	 * @see org.apache.velocity.tools.generic.DateTool
	 * @see VelocityView#setDateToolAttribute
	 */
	public void setDateToolAttribute(String dateToolAttribute) {
		this.dateToolAttribute = dateToolAttribute;
	}

	/**
	 * Set the name of the NumberTool helper object to expose in the Velocity context
	 * of this view, or <code>null</code> if not needed. NumberTool is part of Velocity Tools 1.1.
	 * @see org.apache.velocity.tools.generic.NumberTool
	 * @see VelocityView#setNumberToolAttribute
	 */
	public void setNumberToolAttribute(String numberToolAttribute) {
		this.numberToolAttribute = numberToolAttribute;
	}

	/**
	 * Set a Velocity Toolbox config location, for example "/WEB-INF/toolbox.xml",
	 * to automatically load a Velocity Tools toolbox definition file and expose
	 * all defined tools in the specified scopes. If no config location is
	 * specified, no toolbox will be loaded and exposed.
	 * <p>The specfied location string needs to refer to a ServletContext
	 * resource, as expected by ServletToolboxManager which is part of
	 * the view package of Velocity Tools.
	 * <p><b>Note:</b> Specifying a toolbox config location will lead to
	 * VelocityToolboxView instances being created.
	 * @see org.apache.velocity.tools.view.servlet.ServletToolboxManager#getInstance
	 * @see VelocityToolboxView#setToolboxConfigLocation
	 */
	public void setToolboxConfigLocation(String toolboxConfigLocation) {
		this.toolboxConfigLocation = toolboxConfigLocation;
	}


	protected void initApplicationContext() {
		super.initApplicationContext();

		if (this.toolboxConfigLocation != null) {
			if (VelocityView.class.equals(getViewClass())) {
				logger.info("Using VelocityToolboxView instead of default VelocityView " +
						"due to specified toolboxConfigLocation");
				setViewClass(VelocityToolboxView.class);
			}
			else if (!VelocityToolboxView.class.isAssignableFrom(getViewClass())) {
				throw new IllegalArgumentException(
						"Given view class [" + getViewClass().getName() +
						"] is not of type [" + VelocityToolboxView.class.getName() +
						"], which it needs to be in case of a specified toolboxConfigLocation");
			}
		}
	}


	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		VelocityView view = (VelocityView) super.buildView(viewName);
		view.setVelocityFormatterAttribute(this.velocityFormatterAttribute);
		view.setDateToolAttribute(this.dateToolAttribute);
		view.setNumberToolAttribute(this.numberToolAttribute);
		if (this.toolboxConfigLocation != null) {
			((VelocityToolboxView) view).setToolboxConfigLocation(this.toolboxConfigLocation);
		}
		return view;
	}

}
