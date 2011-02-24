/*
 * Copyright 1999-2005 The Apache Software Foundation.
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
 * 
 * $Id: ShadowBorder.java,v 1.3 2005/09/18 13:58:08 jpassenger Exp $
 */

/*
 * Copyright (c) 2000-2005 JGoodies Karsten Lentzsch. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 *  o Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer. 
 *     
 *  o Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution. 
 *     
 *  o Neither the name of JGoodies Karsten Lentzsch nor the names of 
 *    its contributors may be used to endorse or promote products derived 
 *    from this software without specific prior written permission. 
 *     
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, 
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */
package org.logview4j.ui.border;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;

/**
 * A shadow border 
 * Ripped from com.jgoodies.uif_lite.panel.SimpleInternalFrame 
 */
public class ShadowBorder extends AbstractBorder {

	private static final Insets INSETS = new Insets(1, 1, 3, 3);

	public Insets getBorderInsets(Component c) {
		return INSETS;
	}

	public void paintBorder(Component c, Graphics g,
			int x, int y, int w, int h) {

		Color shadow = UIManager.getColor("controlShadow");

		if (shadow == null) {
			shadow = Color.GRAY;
		}

		Color lightShadow = new Color(shadow.getRed(),
				shadow.getGreen(),
				shadow.getBlue(),
				170);

		Color lighterShadow = new Color(shadow.getRed(),
				shadow.getGreen(),
				shadow.getBlue(),
				70);

		g.translate(x, y);

		g.setColor(shadow);
		g.fillRect(0, 0, w - 3, 1);
		g.fillRect(0, 0, 1, h - 3);
		g.fillRect(w - 3, 1, 1, h - 3);
		g.fillRect(1, h - 3, w - 3, 1);

		// Shadow line 1
		g.setColor(lightShadow);
		g.fillRect(w - 3, 0, 1, 1);
		g.fillRect(0, h - 3, 1, 1);
		g.fillRect(w - 2, 1, 1, h - 3);
		g.fillRect(1, h - 2, w - 3, 1);

		// Shadow line2
		g.setColor(lighterShadow);
		g.fillRect(w - 2, 0, 1, 1);
		g.fillRect(0, h - 2, 1, 1);
		g.fillRect(w - 2, h - 2, 1, 1);
		g.fillRect(w - 1, 1, 1, h - 2);
		g.fillRect(1, h - 1, w - 2, 1);
		g.translate(-x, -y);
	}
}
