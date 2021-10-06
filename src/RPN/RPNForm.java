
package RPN;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RPNForm extends JFrame implements ActionListener {
  private Container contentPane;
  private JPanel displayPanel;
  private JLabel RPNLabel; 
  private JPanel buttonPanel;  
  private JButton[][] buttonGrid;
  private boolean activateHelp=false;
  public static RPNCalculator calc;
  public static RegisterStore regstore;
  public static RegisterRecall regcall;
  public static StackForm stack;
  public static RPNForm gui;
  public static JTextField displayTextField;
  
  public static void main(String[] args) {
    calc = new RPNCalculator();
    gui = new RPNForm();    
    gui.setVisible(true);
    regstore = new RegisterStore();
    regcall = new RegisterRecall();
    stack = new StackForm();    
  }

  
  
  
  public RPNForm() {      
    setSize(660, 330);
    setLocation(450,100);
    setDefaultCloseOperation(3);
    setTitle("  RPN Calculator");
    this.contentPane = getContentPane();
    this.contentPane.setLayout(new BorderLayout());
    
    this.displayPanel = new JPanel();
    this.displayPanel.setLayout(new BoxLayout(this.displayPanel, 0));
    this.displayPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(204, 153, 255)));
    
    this.RPNLabel = new JLabel(" RPN ");
    this.RPNLabel.setBackground(new Color(51, 0, 102));
    this.RPNLabel.setFont(new Font("Courier New", 1, 36));
    this.RPNLabel.setForeground(new Color(102, 51, 102));
    this.displayPanel.add(this.RPNLabel);
    
    this.displayTextField = new JTextField("");
    this.displayTextField.setFont(new Font("Courier New", 1, 24));
    this.displayTextField.setHorizontalAlignment(4);
    this.displayTextField.setActionCommand("Enter");
    this.displayTextField.addActionListener(this);
    this.displayPanel.add(this.displayTextField);
    this.contentPane.add(this.displayPanel, "North");
    
    this.buttonPanel = new JPanel();
    this.buttonPanel.setBackground(new Color(255, 239, 223));
    this.buttonPanel.setLayout(new GridLayout(4, 8));
    this.buttonPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(153, 255, 255)));
    
    this.buttonGrid = new JButton[4][8];
    
    for (int i = 0; i < 4; i++) {
      
      for (int j = 0; j < 8; j++) {
        
        this.buttonGrid[i][j] = new JButton();
        this.buttonGrid[i][j].setFont(new Font("Courier New", 1, 16));
        this.buttonGrid[i][j].addActionListener(this);
        this.buttonGrid[i][j].setBorder(BorderFactory.createBevelBorder(1));
        this.buttonPanel.add(this.buttonGrid[i][j]);
      } 
    } 
    this.buttonGrid[0][0].setText("eXit");
    this.buttonGrid[0][1].setText("C");
    this.buttonGrid[0][2].setText("CE");
    this.buttonGrid[0][3].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[0][3].setBackground(new Color(240, 246, 255));
    this.buttonGrid[0][3].setForeground(new Color(153, 0, 102));
    this.buttonGrid[0][3].setText("7");
    this.buttonGrid[0][4].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[0][4].setBackground(new Color(240, 246, 255));
    this.buttonGrid[0][4].setForeground(new Color(153, 0, 102));
    this.buttonGrid[0][4].setText("8");
    this.buttonGrid[0][5].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[0][5].setBackground(new Color(240, 246, 255));
    this.buttonGrid[0][5].setForeground(new Color(153, 0, 102));
    this.buttonGrid[0][5].setText("9");
    this.buttonGrid[0][6].setText("+");
    this.buttonGrid[0][7].setText("x");
    this.buttonGrid[1][0].setText("STO");
    this.buttonGrid[1][1].setText("RCL");
    this.buttonGrid[1][2].setText("Up");
    this.buttonGrid[1][3].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[1][3].setBackground(new Color(240, 246, 255));
    this.buttonGrid[1][3].setForeground(new Color(153, 0, 102));
    this.buttonGrid[1][3].setText("4");
    this.buttonGrid[1][4].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[1][4].setBackground(new Color(240, 246, 255));
    this.buttonGrid[1][4].setForeground(new Color(153, 0, 102));
    this.buttonGrid[1][4].setText("5");
    this.buttonGrid[1][5].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[1][5].setBackground(new Color(240, 246, 255));
    this.buttonGrid[1][5].setForeground(new Color(153, 0, 102));
    this.buttonGrid[1][5].setText("6");
    this.buttonGrid[1][6].setText("-");
    this.buttonGrid[1][7].setText("/");
    this.buttonGrid[2][0].setText("Load");
    this.buttonGrid[2][1].setText("Save");
    this.buttonGrid[2][2].setText("Down");
    this.buttonGrid[2][3].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[2][3].setBackground(new Color(240, 246, 255));
    this.buttonGrid[2][3].setForeground(new Color(153, 0, 102));
    this.buttonGrid[2][3].setText("1");
    this.buttonGrid[2][4].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[2][4].setBackground(new Color(240, 246, 255));
    this.buttonGrid[2][4].setForeground(new Color(153, 0, 102));
    this.buttonGrid[2][4].setText("2");
    this.buttonGrid[2][5].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[2][5].setBackground(new Color(240, 246, 255));
    this.buttonGrid[2][5].setForeground(new Color(153, 0, 102));
    this.buttonGrid[2][5].setText("3");
    this.buttonGrid[2][6].setText("^");
    this.buttonGrid[2][7].setText("%");
    this.buttonGrid[3][0].setText("BSP");
    this.buttonGrid[3][1].setText("Stack");
    this.buttonGrid[3][2].setText("?");
    this.buttonGrid[3][3].setText("+/-");
    this.buttonGrid[3][4].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[3][4].setBackground(new Color(240, 246, 255));
    this.buttonGrid[3][4].setForeground(new Color(153, 0, 102));
    this.buttonGrid[3][4].setText("0");
    this.buttonGrid[3][5].setText(".");
    this.buttonGrid[3][6].setText("1/n");
    this.buttonGrid[3][7].setFont(new Font("Courier New", 1, 15));
    this.buttonGrid[3][7].setBackground(new Color(246, 240, 255));
    this.buttonGrid[3][7].setForeground(new Color(153, 0, 102));
    this.buttonGrid[3][7].setText("Enter");
    
    this.contentPane.add(this.buttonPanel, "Center");
    
  }

  
  

    public void actionPerformed(ActionEvent event) {
        dealWith(event.getActionCommand());
    }
    public void dealWith(String actionCommand) {
        if (actionCommand.equals("eXit")) {
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "Exit from calculator", "Info for "+actionCommand, 1);
                activateHelp = false;
                return;
            }           
            System.exit(0);
        }else if(actionCommand.equals("C")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "Clear stack's elements", "Info for "+actionCommand, 1);
                activateHelp = false;
                return;
            }           
            calc.c();
            stack.setVisible(stack.isVisible());
                            
        }else if(actionCommand.equals("CE")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "delete the top of stack", "Info for "+actionCommand, 1);
                activateHelp = false;
                return;
            }           
            if(!calc.ce())
                JOptionPane.showMessageDialog(this,"add elements at first to delete it","",0);
            stack.setVisible(stack.isVisible());                        
        }else if(actionCommand.equals("STO")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "store the top of stack to specific memory alocation \"Register\"", "Info for "+actionCommand, 1);
                activateHelp = false;
                return;
            }           
            regstore.setVisible(true);             
        }else if(actionCommand.equals("RCL")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "get value from specific memory alocation \"Register\" and put it at top of stack", "Info for "+actionCommand, 1);
                activateHelp = false;
                return;
            }
            regcall.setVisible(true);
        }else if(actionCommand.equals("Up")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "move the top of stack elements to button", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            if(!calc.up())
                JOptionPane.showMessageDialog(this,"add elements at first","",0);            
            stack.setVisible(stack.isVisible());
        }else if(actionCommand.equals("Load")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "load last saved data of stack and registers", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            try {
                ObjectInputStream oi ;
                oi = new ObjectInputStream(new FileInputStream("RPNStack"));
                calc.theStack = (LinkedList<Double>)oi.readObject();
                oi.close();
                oi = new ObjectInputStream(new FileInputStream("RPNRegister"));
                calc.register = (Register[])oi.readObject();                
                oi.close();
            } catch (Exception ex) {
                
            }
            
        }else if(actionCommand.equals("Save")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "save data of stack and registers to use next time", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            try {
                ObjectOutputStream oo ;
                oo = new ObjectOutputStream(new FileOutputStream("RPNStack"));
                oo.writeObject(calc.theStack);
                oo.close();
                oo = new ObjectOutputStream(new FileOutputStream("RPNRegister"));
                oo.writeObject(calc.register);
                oo.close();
            } catch (Exception ex) {
                
            }
        }else if(actionCommand.equals("Down")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "move the button of stack elements to top", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            if(!calc.down())
                JOptionPane.showMessageDialog(this,"add elements at first","",0);
            stack.setVisible(stack.isVisible());
        }else if(actionCommand.equals("BSP")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "delete one digit from display number", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            String temp = displayTextField.getText();
            if(temp.length()==0)return;
            displayTextField.setText(temp.substring(0,temp.length()-1));
        }else if(actionCommand.equals("Stack")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "view stack elements form", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            stack.setVisible(true);
        }else if(actionCommand.equals("?")){
            activateHelp = !activateHelp;
        }else if(actionCommand.equals("+/-")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "change sign of the top os stack value", "Info for "+actionCommand, 1);
                activateHelp = false; return;}            
            if(!calc.inverseAdd())
                JOptionPane.showMessageDialog(this,"add enough elements for process","",0);            
            stack.setVisible(stack.isVisible());
        }else if(actionCommand.equals("0")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "write number 0 in display area", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            displayTextField.setText(displayTextField.getText()+actionCommand);
        }else if(actionCommand.equals(".")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "write number . in display area", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            displayTextField.setText(displayTextField.getText()+actionCommand);
        }else if(actionCommand.equals("1")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "write number 1 in display area", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            displayTextField.setText(displayTextField.getText()+actionCommand);
        }else if(actionCommand.equals("2")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "write number 2 in display area", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            displayTextField.setText(displayTextField.getText()+actionCommand);
        }else if(actionCommand.equals("3")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "write number 3 in display area", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            displayTextField.setText(displayTextField.getText()+actionCommand);
        }else if(actionCommand.equals("4")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "write number 4 in display area", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            displayTextField.setText(displayTextField.getText()+actionCommand);
        }else if(actionCommand.equals("5")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "write number 5 in display area", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            displayTextField.setText(displayTextField.getText()+actionCommand);
        }else if(actionCommand.equals("6")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "write number 6 in display area", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            displayTextField.setText(displayTextField.getText()+actionCommand);
        }else if(actionCommand.equals("7")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "write number 7 in display area", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            displayTextField.setText(displayTextField.getText()+actionCommand);
        }else if(actionCommand.equals("8")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "write number 8 in display area", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            displayTextField.setText(displayTextField.getText()+actionCommand);
        }else if(actionCommand.equals("9")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "write number 9 in display area", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            displayTextField.setText(displayTextField.getText()+actionCommand);
        }else if(actionCommand.equals("+")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "find sum of the first two numbers in stack", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            if(!calc.add())
                JOptionPane.showMessageDialog(this,"add enough elements for process","",0);            
            stack.setVisible(stack.isVisible());
        }else if(actionCommand.equals("x")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "find multiply of the first two numbers in stack", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            if(!calc.mul())
                JOptionPane.showMessageDialog(this,"add enough elements for process","",0);            
            stack.setVisible(stack.isVisible());
        }else if(actionCommand.equals("-")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "find substraction of the first two numbers in stack", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            if(!calc.sub())
                JOptionPane.showMessageDialog(this,"add enough elements for process","",0);            
            stack.setVisible(stack.isVisible());
        }else if(actionCommand.equals("/")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "find division of the first two numbers in stack", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            if(!calc.div())
                JOptionPane.showMessageDialog(this,"add enough elements for process which second one not zero","",0);            
            stack.setVisible(stack.isVisible());
        }else if(actionCommand.equals("^")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "find power of the first two numbers in stack", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            if(!calc.pow())
                JOptionPane.showMessageDialog(this,"add enough elements for process","",0);
            stack.setVisible(stack.isVisible());
        }else if(actionCommand.equals("%")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "find mod of the first two numbers in stack", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            if(!calc.mod())
                JOptionPane.showMessageDialog(this,"add enough elements for process","",0);            
            stack.setVisible(stack.isVisible());
        }else if(actionCommand.equals("1/n")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "find inverse of the top of stack", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            if(!calc.inverseMul())
                JOptionPane.showMessageDialog(this,"add enough elements for process which is not zero","",0);            
            stack.setVisible(stack.isVisible());
        }else if(actionCommand.equals("Enter")){
            if(activateHelp){
                JOptionPane.showMessageDialog(this, "push the number is display area to stack", "Info for "+actionCommand, 1);
                activateHelp = false; return;}
            if(!calc.push())
                JOptionPane.showMessageDialog(this,"Error input","",0);            
            stack.setVisible(stack.isVisible());
        }
    }
}