package willigrossBubble.gui.customComponents.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import willigrossBubble.Function;
import willigrossBubble.Functions;
import willigrossBubble.gui.FrameMain;
import willigrossBubble.gui.customComponents.buttons.CustomButtonSmall;


public class PanelCreateFunction_TypeFunction extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel f;
	private JTextField function;
	private CustomButtonSmall go;
	
	
	public PanelCreateFunction_TypeFunction() {
		setLayout(null);
		
		f = new JLabel("f(x) = ", SwingConstants.CENTER);
		f.setBounds(25, 40, 50, 30);
		add(f);
		
		function = new JTextField();
		function.setBounds(75, 40, 475, 30);
		function.setBorder(new LineBorder(Color.RED, 2));
		function.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (!Functions.isExpressionValid(function.getText())) {
					function.setBorder(new LineBorder(Color.RED, 2));
					go.setEnabled(false);
				} else {
					function.setBorder(new LineBorder(Color.BLACK));
					go.setEnabled(true);
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					go.doClick();
				}
			}
		});
		add(function);
		
		go = new CustomButtonSmall("Go");
		go.setBounds(250, 80, 100, 30);
		go.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameMain.getInstance().getMainLogic().storeFunction(new Function(function.getText()));
			}
		});
		add(go);
	}
	
}
