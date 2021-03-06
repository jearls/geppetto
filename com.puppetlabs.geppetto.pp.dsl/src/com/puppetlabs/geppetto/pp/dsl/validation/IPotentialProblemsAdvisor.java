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
package com.puppetlabs.geppetto.pp.dsl.validation;

/**
 * An interface for potential problems preferences.
 */
public interface IPotentialProblemsAdvisor extends IStylisticProblemsAdvisor {

	/**
	 * How should a duplicate parameter be handled
	 */
	ValidationPreference getDuplicateParameter();

	/**
	 * How should assignment to variable $string be treated. Puppet bug http://projects.puppetlabs.com/issues/14093.
	 */
	ValidationPreference getAssignmentToVarNamedString();

	/**
	 * How should assignment to variable $trusted be treated.
	 */
	ValidationPreference getAssignmentToVarNamedTrusted();

	/**
	 * Puppet interprets the strings "false" and "true" as boolean true when they are used in a boolean context.
	 * This validation preference flags them as "not a boolean value"
	 *
	 * @return
	 */
	ValidationPreference getBooleansInStringForm();

	/**
	 * How should use of deprecated 'import' keyword be reported.
	 */
	ValidationPreference getDeprecatedImport();

	/**
	 * How should use of deprecated node inheritance be reported.
	 */
	ValidationPreference getDeprecatedNodeInheritance();

	/**
	 * How should use of deprecated '-=' and '+=' operators be reported.
	 */
	ValidationPreference getDeprecatedPlusEquals();

	/**
	 * How should use of deprecated capitalized variable names be reported.
	 */
	ValidationPreference getDeprecatedVariableName();

	/**
	 * How to validate a dq string - style guide says single quoted should be used if possible.
	 *
	 * @return
	 */
	ValidationPreference getDqStringNotRequired();

	/**
	 * How to validate a dq string when it only contains a single interpolated variable.
	 *
	 * @return
	 */
	ValidationPreference getDqStringNotRequiredVariable();

	/**
	 * How to validate hyphens in non brace enclosed interpolations. In < 2.7 interpolation stops at a hyphen, but
	 * not in 2.7. Thus when using 2.6 code in 2.7 or vice versa, the result is different.
	 */
	ValidationPreference getInterpolatedNonBraceEnclosedHyphens();

	/**
	 * How to validate a missing 'default' in switch type expressions i.e. 'case' and 'selector'
	 */
	ValidationPreference getMissingDefaultInSelector();

	/**
	 * How to validate unbraced interpolation.
	 */
	ValidationPreference getUnbracedInterpolation();

	/**
	 * How to validate a literal resource title. Style guide says they should be single quoted.
	 */
	ValidationPreference getUnquotedResourceTitles();

	/**
	 * How should expression validity that cannot be asserted until runtime be reported.
	 * See Issue GEP-110
	 */
	ValidationPreference getValidityAssertedAtRuntime();
}
