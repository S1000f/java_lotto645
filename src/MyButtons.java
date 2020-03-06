import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButtons extends JButton {
	public MyButtons(String text) {
		super(text);
		setBorderPainted(false);
		setOpaque(false);
		
	}
	@Override
	public void paint(Graphics g) {
		int w = getWidth();
		int h = getHeight();
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRoundRect(0, 0, w, h, 60, 60);
		
		g.setColor(Color.black);
		g.drawString(getText(), 23, 35);
	}
}

@SuppressWarnings("serial")
class BonusButton extends MyButtons {
	public BonusButton(String text) {
		super(text);
	}
	@Override
	public void paint(Graphics g) {
		int w = getWidth();
		int h = getHeight();
		
		g.setColor(Color.GREEN);
		g.fillRoundRect(0, 0, w, h, 60, 60);
		
		g.setColor(Color.black);
		g.drawString(getText(), 23, 35);
		
	}
}