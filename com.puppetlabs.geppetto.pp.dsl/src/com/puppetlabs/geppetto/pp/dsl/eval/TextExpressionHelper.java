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
package com.puppetlabs.geppetto.pp.dsl.eval;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import com.puppetlabs.geppetto.pp.DoubleQuotedString;
import com.puppetlabs.geppetto.pp.Expression;
import com.puppetlabs.geppetto.pp.ExpressionTE;
import com.puppetlabs.geppetto.pp.LiteralName;
import com.puppetlabs.geppetto.pp.LiteralNameOrReference;
import com.puppetlabs.geppetto.pp.TextExpression;
import com.puppetlabs.geppetto.pp.VariableExpression;
import com.puppetlabs.geppetto.pp.VariableTE;
import com.puppetlabs.geppetto.pp.VerbatimTE;

/**
 * Helps with TextExpressions in interpolated Strings.
 */
public class TextExpressionHelper {

	public static String getNonInterpolated(DoubleQuotedString dqString) {
		EList<TextExpression> parts = dqString.getStringPart();
		if(parts.size() < 1)
			return "";
		if(parts.size() == 1) {
			TextExpression part = parts.get(0);
			if(part instanceof VerbatimTE)
				return ((VerbatimTE) part).getText();
		}
		return null;
	}

	public static boolean hasInterpolation(DoubleQuotedString dqString) {
		for(TextExpression stringPart : dqString.getStringPart())
			if(!(stringPart instanceof VerbatimTE))
				return true;
		return false;

	}

	/**
	 * Returns a list of trivially interpolated variables; i.e. ${name}, $name, or ${$name}but not variables embedded in
	 * more
	 * complex expression e.g. ${$a + $b}.
	 *
	 * @param dqString
	 * @return
	 */
	public static List<String> interpolatedVariables(DoubleQuotedString dqString) {
		List<String> result = new ArrayList<String>();
		for(TextExpression te : dqString.getStringPart()) {
			if(te instanceof VariableTE) {
				result.add(((VariableTE) te).getVarName());
			}
			else if(te instanceof ExpressionTE) {
				Expression e = ((ExpressionTE) te).getExpression();
				if(e instanceof LiteralNameOrReference)
					result.add(((LiteralNameOrReference) e).getValue());
				else if(e instanceof LiteralName)
					result.add(((LiteralName) e).getValue());
				else if(e instanceof VariableExpression)
					result.add(((VariableExpression) e).getVarName());
			}
		}
		return result;
	}

	public static int interpolationCount(DoubleQuotedString dqString) {
		int count = 0;
		for(TextExpression te : dqString.getStringPart()) {
			if(te instanceof VerbatimTE)
				continue;
			count++;
		}
		return count;

	}

	public static int segmentCount(DoubleQuotedString dqString) {
		return dqString.getStringPart().size();
	}

	public String doubleQuote(String s) {
		return '"' + s + '"';
	}

	// Integers and floats are presented as LiteralNameOrReference. This
	// method will return such strings but nothing else (not quoted
	// strings for instance)
	public static String getLiteralString(Expression value) {
		String s = null;
		if(value instanceof LiteralNameOrReference)
			s = ((LiteralNameOrReference) value).getValue();
		if(s != null && s.isEmpty())
			s = null;
		return s;
	}

}
