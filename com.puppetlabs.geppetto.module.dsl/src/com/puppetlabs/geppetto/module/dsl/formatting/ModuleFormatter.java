/**
 * generated by Xtext
 */
package com.puppetlabs.geppetto.module.dsl.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;

public class ModuleFormatter extends AbstractDeclarativeFormatter {
	@Override
	protected void configureFormatting(final FormattingConfig c) {
		for(Pair<Keyword, Keyword> pair : grammar.findKeywordPairs("{", "}")) {
			c.setNoSpace().before(pair.getFirst());
			c.setLinewrap(1).after(pair.getFirst());
			// indentation between
			c.setIndentation(pair.getFirst(), pair.getSecond());

			// and a linewrap before '}'
			c.setLinewrap(1).before(pair.getSecond());
			c.setLinewrap(1).after(pair.getSecond());
			c.setNoSpace().between(pair.getFirst(), pair.getSecond());
		}

		for(Pair<Keyword, Keyword> pair : grammar.findKeywordPairs("[", "]")) {
			c.setNoSpace().before(pair.getFirst());

			// indentation between
			c.setIndentation(pair.getFirst(), pair.getSecond());

			// and a linewrap before ']'
			c.setLinewrap(1).before(pair.getSecond());
			c.setNoSpace().between(pair.getFirst(), pair.getSecond());
		}

		for(Keyword colon : grammar.findKeywords(":")) {
			c.setNoSpace().before(colon);
			c.setSpace(" ").after(colon);
		}

		for(Keyword comma : grammar.findKeywords(",")) {
			c.setNoSpace().before(comma);
			c.setLinewrap(1).after(comma);
		}
	}
}