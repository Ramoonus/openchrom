/*******************************************************************************
 * Copyright (c) 2024 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package net.openchrom.xxd.base.ui.support;

import org.eclipse.chemclipse.model.types.DataType;

import net.openchrom.xxd.base.ui.Activator;
import net.openchrom.xxd.base.ui.services.IAnalysisSegmentService;

public class AnalysisSegmentSupport {

	public static IAnalysisSegmentService getAnalysisSegmentService(DataType dataType) {

		Object[] services = Activator.getDefault().getAnalysisSegmentServices();
		if(services != null) {
			for(Object service : services) {
				if(service instanceof IAnalysisSegmentService analysisSegmentService) {
					if(dataType.equals(analysisSegmentService.getDataType())) {
						return analysisSegmentService;
					}
				}
			}
		}
		//
		return null;
	}
}