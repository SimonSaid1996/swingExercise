import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class TicTacToe {
    JFrame _frame = new JFrame("Tic-Tac-Toe");
    JButton[] _buttons = new JButton[9];
	JButton restart = new JButton();
	int count=0;
	public class ButtonListener implements ActionListener {

	// Every time we click the button, it will perform
	// the following action.

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==restart){
			for (int j=0; j<9; j++) {
				String currentText = _buttons[j].getText();
				if (!currentText.equals("_")) {
					_buttons[j].setText("_");
					_buttons[j].setEnabled(true);
				} 
			}	
		}
		else{
			JButton source = (JButton) e.getSource();
			String currentText = source.getText();
				if (currentText.equals("_")) {
					if((count % 2)==0){
						source.setText("X");
						count++;
						source.setEnabled(false);
					}
					else{
						source.setText("O");
						count++;
						source.setEnabled(false);
					}
				} 
				else {
					source.setText("_");
				}
		}
	    
	}
    
    }
	public TicTacToe(){
		_frame.setSize(400, 400);
		_frame.setVisible(true);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel _ttt = new JPanel();
		JPanel _newPanel = new JPanel();
		_ttt.setLayout(new GridLayout(3, 3));
		_newPanel.setLayout(new FlowLayout());
		
		_frame.add(_ttt, BorderLayout.NORTH);
		_frame.add(_newPanel, BorderLayout.SOUTH);
		
		for (int j=0; j<9; j++) {
	    // Make a new button in the array location with text "_"
			_buttons[j] = new JButton("_");
	    // Associate a new ButtonListener to the button (see below)
			ActionListener buttonListener = new ButtonListener();
			_buttons[j].addActionListener(buttonListener);
	    // Set the font on the button
			_buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
	    // Add this button to the _ttt panel
			_ttt.add(_buttons[j]);
		}
		ActionListener buttonListenerTwo = new ButtonListener();
		restart = new JButton("New Game");
		restart.addActionListener(buttonListenerTwo);
		_newPanel.add(restart);
	}
    public static void main(String[] args) {
		new TicTacToe();
		
		
    }

}