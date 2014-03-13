package com.fabiale.nutritiveguide.web.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;

public class SiteMeshConfigFilter extends ConfigurableSiteMeshFilter {
	
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/WEB-INF/decorators/default.jsp");
		builder.addTagRuleBundle(new DivExtractingTagRuleBundle());
	}
}
