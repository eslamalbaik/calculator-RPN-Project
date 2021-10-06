 
package RPN;
 
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class StackForm extends JFrame implements ActionListener{   
    private Container contentPane;
    private JLabel top,stack;
    private JList<Double> list;
    private JScrollPane scroll;
    private JButton up,down,copy,edit,delete,clear,close;    
    public StackForm(){
        setSize(450, 400);
        setDefaultCloseOperation(3);
        setTitle("  RPN Stack");
        contentPane = getContentPane();
        contentPane.setLayout(null);
        top = new JLabel("Top>>");
        
        stack = new JLabel("The Stack");
        list = new JList();
        scroll = new JScrollPane(list);
        up = new JButton("Up");
        down = new JButton("Down");
        copy = new JButton("Copy");
        edit = new JButton("Edit");
        delete = new JButton("Delete");
        clear = new JButton("Clear");
        close = new JButton("Close");
        
        top.setForeground(new Color(0,150,0));
        stack.setForeground(Color.BLUE);
        
        up.addActionListener(this);
        down.addActionListener(this);
        copy.addActionListener(this);
        edit.addActionListener(this);
        delete.addActionListener(this);
        clear.addActionListener(this);
        close.addActionListener(this);
        contentPane.add(top);contentPane.add(stack);
        contentPane.add(list);contentPane.add(up);
        contentPane.add(down);contentPane.add(copy);
        contentPane.add(edit);contentPane.add(delete);
        contentPane.add(clear);contentPane.add(close); 
        stack.setBounds(100, 20, 100, 30);
        top.setBounds(10, 70, 70, 20);
        list.setBounds(80, 70, 220, 230);
        up.setBounds(320, 70, 100, 30);
        down.setBounds(320, 110, 100, 30);
        copy.setBounds(320, 150, 100, 30);
        edit.setBounds(320, 190, 100, 30);
        delete.setBounds(320, 230, 100, 30);
        clear.setBounds(320, 270, 100, 30);
        close.setBounds(150, 310, 100, 30);
        
    }
    public void setVisible(boolean x){         
        list.removeAll();
        list.setListData(RPNForm.calc.theStack.toArray(new Double[]{}));               
        super.setVisible(x);
    }
    public void actionPerformed(ActionEvent event) { 
        Double selected = list.getSelectedValue();
        if(event.getSource() == up){  
            if(RPNForm.calc.theStack.isEmpty())return;
            RPNForm.calc.theStack.addLast(RPNForm.calc.theStack.removeFirst());
            this.setVisible(true);
        }else if(event.getSource() == down){
            if(RPNForm.calc.theStack.isEmpty())return;
            RPNForm.calc.theStack.addFirst(RPNForm.calc.theStack.removeLast());
            this.setVisible(true);
        }else if(event.getSource() == copy){               
            if(selected == null)return;
            StringSelection str = new StringSelection(selected+"");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);            
        }else if(event.getSource() == edit){
            if(selected == null)return;     
            String str = JOptionPane.showInputDialog(this, "Enter new double value insted of "+selected, "Edit stack",-1);                        
            ((List)RPNForm.calc.theStack).set(list.getSelectedIndex(), new Double(str));             
            this.setVisible(true);
        }else if(event.getSource() == delete){
            if(selected == null)return;            
            RPNForm.calc.theStack.remove(selected);
            this.setVisible(true);
        }else if(event.getSource() == clear){
            RPNForm.calc.theStack.clear();
            this.setVisible(true);
        }else if(event.getSource() == close){
            this.setVisible(false);
        }        
    }    
}
