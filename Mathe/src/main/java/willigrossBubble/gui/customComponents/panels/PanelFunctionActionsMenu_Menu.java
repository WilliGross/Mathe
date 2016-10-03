package willigrossBubble.gui.customComponents.panels;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import willigrossBubble.data.Strings;
import willigrossBubble.gui.FrameMain;
import willigrossBubble.gui.customComponents.buttons.CustomButtonLarge;
import willigrossBubble.logic.Function;

public class PanelFunctionActionsMenu_Menu extends RequestFocusForDefaultComponentPanel {

	private static final long		serialVersionUID	= 1L;
	private final JLabel			heading, function;
	private final CustomButtonLarge	b1_table, b2_point, b3_mirror;
	private final JCheckBox			saveInFile;
	
	public PanelFunctionActionsMenu_Menu(Function function) {
		setLayout(null);
		
		heading = new JLabel(Strings.getStringAsHTML("PanelFunctionActionsMenu_Menu.label_heading"), //$NON-NLS-1$
				SwingConstants.CENTER);
		heading.setFont(FrameMain.getHeadingFont());
		heading.setBounds(100, 40, 400, 50);
		add(heading);
		
		this.function = new JLabel(function.toString(), SwingConstants.CENTER);
		this.function.setFont(FrameMain.getHeadingFont().deriveFont(Font.BOLD));
		this.function.setBounds(100, 70, 400, 30);
		add(this.function);
		
		b1_table = new CustomButtonLarge(Strings.getStringAsHTML("PanelFunctionActionsMenu_Menu.button_table")); //$NON-NLS-1$
		b1_table.setLocation(100, 110);
		b1_table.addActionListener(e -> {
			final CenterPanel instance = FrameMain.getInstance().getPanelCenter();
			if (instance instanceof PanelFunctionActionsMenu)
				((PanelFunctionActionsMenu) instance).table();
		});
		add(b1_table);
		
		b2_point = new CustomButtonLarge(Strings.getStringAsHTML("PanelFunctionActionsMenu_Menu.button_point")); //$NON-NLS-1$
		b2_point.setLocation(100, 145);
		b2_point.addActionListener(e -> {
			final CenterPanel instance = FrameMain.getInstance().getPanelCenter();
			if (instance instanceof PanelFunctionActionsMenu)
				((PanelFunctionActionsMenu) instance).point();
		});
		add(b2_point);

		b3_mirror = new CustomButtonLarge(Strings.getStringAsHTML("PanelFunctionActionsMenu_Menu.button_mirror")); //$NON-NLS-1$
		b3_mirror.setLocation(100, 180);
		b3_mirror.addActionListener(e -> {
			final CenterPanel instance = FrameMain.getInstance().getPanelCenter();
			if (instance instanceof PanelFunctionActionsMenu)
				((PanelFunctionActionsMenu) instance).mirror();
		});
		add(b3_mirror);
		
		saveInFile = new JCheckBox(Strings.getStringAsHTML("PanelFunctionActionsMenu_Menu.checkBox_save_message")); //$NON-NLS-1$
		saveInFile.setToolTipText(Strings.getStringAsHTML("PanelFunctionActionsMenu_Menu.checkBox_save_tooltip")); //$NON-NLS-1$
		saveInFile.setHorizontalAlignment(SwingConstants.CENTER);
		saveInFile.setBounds(100, 220, 400, 30);
		if (FrameMain.getInstance().getMainLogic().getMainData().isFunctionSaved(function))
			saveInFile.setSelected(true);
		saveInFile.addItemListener(e -> {
			if (saveInFile.isSelected())
				FrameMain.getInstance().getMainLogic().getMainData().saveFunctionInFile(function);
			else
				FrameMain.getInstance().getMainLogic().getMainData().removeFunctionFromFile(function);
			FrameMain.getInstance().getMainLogic().getMainData().displayFunctionsDat();
		});
		add(saveInFile);
		
		setDefaultComponent(b1_table);
	}
}
