
package RPN;
import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JFrame; 
import javax.swing.JList;
import javax.swing.JScrollPane;
public class RegisterRecall extends JFrame implements ActionListener{
    private Container contentPane;
    private Button recall,close;
    private JList<Register> list;
    private JScrollPane scroll;    
    public RegisterRecall(){
        setSize(320, 440);    
        setLocation(1000,50);
        setTitle("  RPN Recall");
        contentPane = getContentPane();
        contentPane.setLayout(null);        
        list = new JList();
        scroll = new JScrollPane(list);
        close = new Button("Close");
        recall = new Button("Recall");        
        close.addActionListener(this);
        recall.addActionListener(this);
        scroll.setBounds(20,20,270,300);
        recall.setBounds(80,350,70,30);
        close.setBounds(160,350,70,30);        
        contentPane.add(close);contentPane.add(recall);
        contentPane.add(scroll);
        
    }
    public void setVisible(boolean x){        
        list.removeAll();
        list.setListData(RPNForm.calc.register);                                
        super.setVisible(x);
    }
    public void actionPerformed(ActionEvent event) { 
        int index = list.getSelectedIndex();
        if(event.getSource() == close){  
            this.setVisible(false);
        }else if(event.getSource() == recall){  
            if(index==-1)return;
            double val = RPNForm.calc.register[index].getValue();
            RPNForm.calc.theStack.addFirst(val);
            RPNForm.stack.setVisible(RPNForm.stack.isVisible());
            RPNForm.displayTextField.setText(val+"");
        }
    }
}
