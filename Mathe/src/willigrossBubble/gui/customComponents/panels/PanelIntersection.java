package willigrossBubble.gui.customComponents.panels;

import willigrossBubble.gui.FrameMain;

public class PanelIntersection extends CenterPanel {

	private static final long serialVersionUID = 1L;

	@Override
	public void back() {
		FrameMain.getInstance().panelMain();
	}

}