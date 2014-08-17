/*
 * generated by Xtext
 */
package com.puppetlabs.geppetto.module.dsl.formatting

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig

class ModuleFormatter extends AbstractDeclarativeFormatter {

	override protected void configureFormatting(FormattingConfig c) {
		for (pair : grammar.findKeywordPairs('{', '}')) {
			c.setNoSpace().before(pair.first)
			c.setLinewrap(1).after(pair.first);

			// indentation between
			c.setIndentation(pair.first, pair.second);

			// and a linewrap before '}'
			c.setLinewrap(1).before(pair.second);
			c.setLinewrap(1).after(pair.second);
			c.setNoSpace().between(pair.first, pair.second);
		}

		for (pair : grammar.findKeywordPairs('[', ']')) {
			c.setNoSpace().before(pair.first)

			// indentation between
			c.setIndentation(pair.first, pair.second);

			// and a linewrap before ']'
			c.setLinewrap(1).before(pair.second);
			c.setNoSpace().between(pair.first, pair.second);			
		}

		for (colon : grammar.findKeywords(':')) {
			c.setNoSpace().before(colon)
			c.setSpace(' ').after(colon)
		}

		for (comma : grammar.findKeywords(',')) {			
			c.setNoSpace().before(comma)
			c.setLinewrap(1).after(comma);
		}
	}
}