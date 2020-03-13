import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

@SuppressWarnings("serial")
public class Lotto extends JFrame implements MouseListener, KeyListener {
	MyButtons[] mbt = new MyButtons[6];
	BonusButton mbt7 = new BonusButton(" ");
	JTextField[] mynumTxt = new JTextField[6];
	
	JButton checkBtn = new JButton("불러오기");
	JTextField turnTxt = new JTextField();
	
	JLabel titlelbl = new JLabel("로또번호");
	JLabel turnlbl = new JLabel("회차번호");
	JLabel yourlbl = new JLabel("당신의 로또번호를 넣어주세요");
	JLabel matchlbl = new JLabel("맞은 번호 >>>");
	
	public void init() {
		getContentPane().setLayout(null);
		
		int w = 60;
		int wm = 70;
		for(int i = 0; i < mbt.length; i++) {
			mbt[i] = new MyButtons("");
			mbt[i].setBounds(10+wm*i, 50, 60, 60);
			getContentPane().add(mbt[i]);
		}
		mbt7.setBounds(10+wm*6, 50, 60, 60);
		getContentPane().add(mbt7);
		
		for(int i = 0; i < mynumTxt.length; i++) {
			mynumTxt[i] = new JTextField();
			mynumTxt[i].setBounds(15+wm*i, 150, 50, 50);
			getContentPane().add(mynumTxt[i]);
		}
		
		titlelbl.setBounds(10, 10, 150, 30);
		getContentPane().add(titlelbl);
		
		yourlbl.setBounds(10, 120, 500, 30);
		getContentPane().add(yourlbl);
		
		matchlbl.setBounds(10,200,550,30);
		getContentPane().add(matchlbl);
		
		turnlbl.setBounds(20, 250, 150, 60);
		getContentPane().add(turnlbl);
		
		turnTxt.setBounds(100, 250, 100, 40);
		getContentPane().add(turnTxt);
		
		checkBtn.setBounds(220, 250, 100, 40);
		getContentPane().add(checkBtn);
	}
	
	
	
	public void showResult() {
		JsonReader json = new JsonReader();
		try {
			JSONObject jo = json.connectionUrlToJSON(turnTxt.getText());
			if(jo.get("returnValue").equals("fail")) {
				turnlbl.setText("틀린회차 입니다");
				return;
			}
			
			for(int i = 0; i < mbt.length; i++) {
				mbt[i].setText(String.valueOf(jo.get("drwtNo"+(i+1))));
			}
			mbt7.setText(String.valueOf(jo.get("bnusNo")));
			
			calcWin(mbt,mbt7);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		turnlbl.setText(turnTxt.getText() + "회차");
	}
	
		
	public void collectMynum() {
		int checksum;
		List<String> myNumList = new ArrayList<>();
		
		for(int i = 0; i < mynumTxt.length; i++) {
			myNumList.add(mynumTxt[i].getText());
		}					  
		
		Checking checking = new Checking();
		checksum = checking.getChecksum(myNumList);
		System.out.println("checksum: " + checksum);
		
		
		return;
	}
	
	
	
	
	public void calcWin(MyButtons[] mbt, BonusButton mbt7) {
		matchlbl.setText("맞은 번호 >>>");
		int count = 0;
		int countBonus = 0;
		for(int i = 0; i < mynumTxt.length; i++) {
			for(int j = 0; j < mynumTxt.length; j++) {
				if(mynumTxt[i].getText().equals(mbt[j].getText())) {
					matchlbl.setText(matchlbl.getText()+" "+mynumTxt[i].getText()+", ");
					count++;
				}
			}
		}
		
		for(int i = 0; i < mynumTxt.length; i++) {
			if(mynumTxt[i].getText().equals(mbt7.getText())) {
				matchlbl.setText(matchlbl.getText()+"+보너스번호 "+ mynumTxt[i].getText());
				countBonus = 1;
			}
		}
		
		if(count == 6) {
			matchlbl.setText(matchlbl.getText() + "  결과: 1등 입니다!!!!!!");
		} else if(count == 5 && countBonus == 1) {
			matchlbl.setText(matchlbl.getText() + "  결과: 2등 입니다!!!");
		} else if(count == 5) {
			matchlbl.setText(matchlbl.getText() + "  결과: 3등 입니다!!");
		} else if(count == 4) {
			matchlbl.setText(matchlbl.getText() + "  결과: 4등 입니다!");
		} else if(count == 3) {
			matchlbl.setText(matchlbl.getText() + "  결과: 5등 입니다");
		}
	}
	public static void main(String[] args) throws Exception {
		new Lotto();
	}
	
	public Lotto() { // constructor
		super("로또번호 조회");
		
		// 기본화면 컴포넌트 초기화
		init();
		
		// event 초기화
		event();
		
		//frame setting
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public void event() {
		checkBtn.addMouseListener(this);
		turnTxt.addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) { //누르고 뗐을때
		showResult();
		collectMynum();
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) { //계속 누르고 있는 상태
	}
	
	@Override
	public void mouseReleased(MouseEvent e) { // 눌렀다가 떼었을때
		
	}
}















