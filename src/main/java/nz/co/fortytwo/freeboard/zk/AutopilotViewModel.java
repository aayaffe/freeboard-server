/*
 * Copyright 2012,2013 Robert Huitema robert@42.co.nz
 * 
 * This file is part of FreeBoard. (http://www.42.co.nz/freeboard)
 *
 *  FreeBoard is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  FreeBoard is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.

 *  You should have received a copy of the GNU General Public License
 *  along with FreeBoard.  If not, see <http://www.gnu.org/licenses/>.
 */
package nz.co.fortytwo.freeboard.zk;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.event.MouseEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Button;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Window;

public class AutopilotViewModel extends SelectorComposer<Window>{

	private static Logger logger = Logger.getLogger(AutopilotViewModel.class);
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@WireVariable
    private Session sess;
	
	@Wire("button#apPort")
	private Button apPort; 
	@Wire("button#apStbd")
	private Button apStbd; 
	@Wire("button#apCompassOnOff")
	private Button apCompassOnOff; 
	@Wire("button#apWindOnOff")
	private Button apWindOnOff; 
	
	private boolean autopilotOn=false;
	
	public AutopilotViewModel() {
		super();
		logger.debug("Constructing..");
	}

	//@AfterCompose
	public void init() {
		logger.debug("Init..");
	}
	
	@Listen("onClick = button#apPort")
	public void apPortClick(MouseEvent event) {
	    logger.debug(" apPort button event = "+event);
	    
	}
	@Listen("onClick = button#apStbd")
	public void apStbdClick(MouseEvent event) {
	    logger.debug(" apStbd button event = "+event);
	    
	}
	@Listen("onClick = button#apCompassOnOff")
	public void apCompassOnOffClick(MouseEvent event) {
	    logger.debug(" apCompassOnOff button event = "+event);
	    autopilotOn=!autopilotOn;
	    if(autopilotOn){
	    	apCompassOnOff.setImage("./js/img/west-mini.png");
	    	apWindOnOff.setImage("./js/img/zoom-world-mini.png");
	    }else{
	    	apCompassOnOff.setImage("./js/img/zoom-world-mini.png");
	    }
	}
	
	@Listen("onClick = button#apWindOnOff")
	public void apOnOffClick(MouseEvent event) {
	    logger.debug(" apWindOnOff button event = "+event);
	    autopilotOn=!autopilotOn;
	    if(autopilotOn){
	    	apWindOnOff.setImage("./js/img/west-mini.png");
	    	apCompassOnOff.setImage("./js/img/zoom-world-mini.png");
	    }else{
	    	apWindOnOff.setImage("./js/img/zoom-world-mini.png");
	    }
	}
	
	
	

}