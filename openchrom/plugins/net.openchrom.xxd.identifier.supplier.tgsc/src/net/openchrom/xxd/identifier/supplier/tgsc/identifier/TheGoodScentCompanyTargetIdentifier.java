/*******************************************************************************
 * Copyright (c) 2023, 2024 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package net.openchrom.xxd.identifier.supplier.tgsc.identifier;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.identifier.targets.ITargetIdentifierSupplier;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.cas.CasSupport;
import org.eclipse.chemclipse.model.identifier.IIdentifierSettings;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.support.literature.LiteratureReference;

public class TheGoodScentCompanyTargetIdentifier implements ITargetIdentifierSupplier {

	private static final Logger logger = Logger.getLogger(TheGoodScentCompanyTargetIdentifier.class);
	private static final String URL = "http://www.thegoodscentscompany.com/opl/{0}.html";

	@Override
	public String getId() {

		return "net.openchrom.xxd.identifier.supplier.tgsc.identifier";
	}

	@Override
	public String getDescription() {

		return "Click to open the corresponding The Good Scent Company database entry in a web browser.";
	}

	@Override
	public String getIdentifierName() {

		return "TGSC";
	}

	@Override
	public Class<? extends IIdentifierSettings> getSettingsClass() {

		return null;
	}

	@Override
	public URL getURL(ILibraryInformation libraryInformation) {

		URL url = null;
		try {
			String cas = libraryInformation.getCasNumber();
			if(cas != null && !cas.isEmpty() && !CasSupport.CAS_DEFAULT.equals(cas)) {
				url = new URL(MessageFormat.format(URL, cas));
			}
		} catch(MalformedURLException e) {
			logger.warn(e);
		}
		return url;
	}

	@Override
	public List<LiteratureReference> getLiteratureReferences() {

		return null;
	}
}
