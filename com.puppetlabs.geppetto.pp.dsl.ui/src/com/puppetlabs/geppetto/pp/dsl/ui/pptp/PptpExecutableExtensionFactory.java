/**
 * Copyright (c) 2013 Puppet Labs, Inc. and other contributors, as listed below.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Puppet Labs
 */
package com.puppetlabs.geppetto.pp.dsl.ui.pptp;

import org.osgi.framework.Bundle;

import com.google.inject.Injector;
import com.puppetlabs.geppetto.injectable.eclipse.AbstractGuiceAwareExecutableExtensionFactory;
import com.puppetlabs.geppetto.pp.dsl.PPDSLConstants;
import com.puppetlabs.geppetto.pp.dsl.ui.internal.PPActivator;

/**
 * Executable Extension configuration for PPTP (non Ruby).
 */
public class PptpExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory#getBundle()
	 */
	@Override
	protected Bundle getBundle() {
		return PPActivator.getInstance().getBundle();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory#getInjector()
	 */
	@Override
	protected Injector getInjector() {
		return PPActivator.getInstance().getInjector(PPDSLConstants.PPTP_LANGUAGE_NAME);
	}

}
