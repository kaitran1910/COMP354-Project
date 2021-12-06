import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class JavaCalculator extends JFrame {

    private JButton jbtNum1;
    private JButton jbtNum2;
    private JButton jbtNum3;
    private JButton jbtNum4;
    private JButton jbtNum5;
    private JButton jbtNum6;
    private JButton jbtNum7;
    private JButton jbtNum8;
    private JButton jbtNum9;
    private JButton jbtNum0;
    private JButton jbtEqual;
    private JButton jbtAdd;
    private JButton jbtSubtract;
    private JButton jbtMultiply;
    private JButton jbtDivide;
    private JButton jbtDec;
    private JButton jbtSolve;
    private JButton jbtClear;
    private double TEMP;
    private double SolveTEMP;
    private JTextField jtfResult;

    Boolean addBool = false;
    Boolean subBool = false;
    Boolean divBool = false;
    Boolean mulBool = false;
    Boolean operator = false;
    Boolean error = false;
    
    String tooLong = "Error! Number is to large to display";
    String syntaxError = "Syntax Error!.";
    String divZero = "Error! Division by Zero.";

    String display = "";

    public JavaCalculator() {

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 3));
        p1.add(jbtNum1 = new JButton("1"));
        p1.add(jbtNum2 = new JButton("2"));
        p1.add(jbtNum3 = new JButton("3"));
        p1.add(jbtNum4 = new JButton("4"));
        p1.add(jbtNum5 = new JButton("5"));
        p1.add(jbtNum6 = new JButton("6"));
        p1.add(jbtNum7 = new JButton("7"));
        p1.add(jbtNum8 = new JButton("8"));
        p1.add(jbtNum9 = new JButton("9"));
        p1.add(jbtNum0 = new JButton("0"));
        p1.add(jbtDec = new JButton("."));
        p1.add(jbtClear = new JButton("C"));

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(jtfResult = new JTextField(20));
        jtfResult.setHorizontalAlignment(JTextField.RIGHT);
        jtfResult.setEditable(false);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(5, 1));
        p3.add(jbtAdd = new JButton("+"));
        p3.add(jbtSubtract = new JButton("-"));
        p3.add(jbtMultiply = new JButton("*"));
        p3.add(jbtDivide = new JButton("/"));
        p3.add(jbtSolve = new JButton("="));

        JPanel p = new JPanel();
        p.setLayout(new GridLayout());
        p.add(p2, BorderLayout.NORTH);
        p.add(p1, BorderLayout.SOUTH);
        p.add(p3, BorderLayout.EAST);

        add(p);

        jbtNum1.addActionListener(new ListenToOne());
        jbtNum2.addActionListener(new ListenToTwo());
        jbtNum3.addActionListener(new ListenToThree());
        jbtNum4.addActionListener(new ListenToFour());
        jbtNum5.addActionListener(new ListenToFive());
        jbtNum6.addActionListener(new ListenToSix());
        jbtNum7.addActionListener(new ListenToSeven());
        jbtNum8.addActionListener(new ListenToEight());
        jbtNum9.addActionListener(new ListenToNine());
        jbtNum0.addActionListener(new ListenToZero());
        jbtDec.addActionListener(new ListenToDecimal());

        jbtAdd.addActionListener(new ListenToAdd());
        jbtSubtract.addActionListener(new ListenToSubtract());
        jbtMultiply.addActionListener(new ListenToMultiply());
        jbtDivide.addActionListener(new ListenToDivide());
        jbtSolve.addActionListener(new ListenToSolve());
        jbtClear.addActionListener(new ListenToClear());
    } //JavaCaluclator()

    class ListenToClear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //display = jtfResult.getText();
            jtfResult.setText("");
            addBool = false;
            subBool = false;
            mulBool = false;
            divBool = false;
            operator = false;

            TEMP = 0;
            SolveTEMP = 0;
        }
    }

    class ListenToOne implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	DisplayNumber("1");
        }
    }

    class ListenToTwo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	DisplayNumber("2");
        }
    }

    class ListenToThree implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	DisplayNumber("3");
        }
    }

    class ListenToFour implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	DisplayNumber("4");
        }
    }

    class ListenToFive implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DisplayNumber("5");
        }
    }

    class ListenToSix implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	DisplayNumber("6");
        }
    }

    class ListenToSeven implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	DisplayNumber("7");
        }
    }

    class ListenToEight implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	DisplayNumber("8");
        }
    }

    class ListenToNine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	DisplayNumber("9");
        }
    }

    class ListenToZero implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	DisplayNumber("0");
        }
    }

    class ListenToDecimal implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	DisplayNumber(".");
        }
    }
    
    public void DisplayNumber(String s) {
    	try {
    		if(error) {
    			error = false;
    			display = "";
    		}
    		else {
        		display = jtfResult.getText();
    		}
    		
    		if(display.length() >= 15) {
    			error = true;
    			throw new LargeNumException();
    		}
    		
    		jtfResult.setText(display + s);
    	}
    	catch(Exception ex) {
        	error = true; 
        	jtfResult.setText(ex.toString());
    	}
    }

    class ListenToAdd implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	try {
        		SaveOperand();
                operator = addBool = true;
        	}
        	catch(Exception ex) {
            	error = true; 
            	jtfResult.setText(ex.toString());
        	}
        }
    }

    class ListenToSubtract implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	try {
        		SaveOperand();
	            operator = subBool = true;
        	}
        	catch(Exception ex) {
            	error = true; jtfResult.setText(ex.toString());
        	}
        }
    }

    class ListenToMultiply implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	try {
        		SaveOperand();
	            operator = mulBool = true;
        	}
        	catch(Exception ex) {
            	error = true; jtfResult.setText(ex.toString());
        	}
        }
    }

    class ListenToDivide implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	try {
        		SaveOperand();
	            operator = divBool = true;
        	}
        	catch(Exception ex) {
            	error = true; jtfResult.setText(ex.toString());
        	}
        }
    }
    
    public void SaveOperand() {
    	display = jtfResult.getText();
    	if(operator || error || display == "." || display.charAt(display.length()-1) == '.'|| display.charAt(0) == '.') {
    		operator = false;
    		throw new SyntaxErrorException();
    	}
        TEMP = Double.parseDouble(jtfResult.getText());
        jtfResult.setText("");
    }

    class ListenToSolve implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	try {
        		display = jtfResult.getText();
            	if( error || display == "." || display.charAt(display.length()-1) == '.'|| display.charAt(0) == '.') {
            		throw new SyntaxErrorException();
            	}
	        	
	        	SolveTEMP = Double.parseDouble(display);
	        	
            	if(divBool && SolveTEMP == 0) {
            		throw new ZeroDivisionException();
            	}
	        	
	            if (addBool)
	                SolveTEMP = SolveTEMP + TEMP;
	            else if ( subBool )
	                SolveTEMP = SolveTEMP - TEMP;
	            else if ( mulBool )
	                SolveTEMP = SolveTEMP * TEMP;
	            else if ( divBool )
	                            SolveTEMP = TEMP / SolveTEMP;
	            jtfResult.setText(  Double.toString(SolveTEMP));
            
        	}
        	catch(Exception ex) {
            	error = true; 
            	jtfResult.setText(ex.toString());
        	}
        	
            addBool = false;
            subBool = false;
            mulBool = false;
            divBool = false;
            operator = false;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JavaCalculator calc = new JavaCalculator();
        calc.pack();
        calc.setLocationRelativeTo(null);
                calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }

} //JavaCalculator