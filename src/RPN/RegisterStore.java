 
package RPN;
import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
public class RegisterStore extends JFrame implements ActionListener{
    private Container contentPane;
    private Button mul,add,sub,div,store,edit,close,clear;
    private JList<Register> list;
    private JScrollPane scroll;    
    public RegisterStore(){
        setSize(350, 470);      
        setLocation(1000,50);
        setTitle("  RPN Store");
        contentPane = getContentPane();
        contentPane.setLayout(null);
        list = new JList();
        scroll = new JScrollPane(list);
        
        mul = new Button("x");
        add = new Button("+");
        sub = new Button("-");
        div = new Button("÷");
        store = new Button("Store");
        edit = new Button("Edit Label");
        close = new Button("Close");
        clear = new Button("Clear");
        
        mul.addActionListener(this);
        add.addActionListener(this);
        div.addActionListener(this);
        sub.addActionListener(this);
        store.addActionListener(this);
        edit.addActionListener(this);
        close.addActionListener(this);
        clear.addActionListener(this);
        
        scroll.setBounds(20,20,270,300);
        add.setBounds(50,350,40,30);
        sub.setBounds(100,350,40,30);
        mul.setBounds(150,350,40,30);
        div.setBounds(200,350,40,30);
        store.setBounds(30,400,45,30);
        edit.setBounds(85,400,70,30);        
        clear.setBounds(165,400,55,30);
        close.setBounds(230,400,55,30);
        contentPane.add(mul);contentPane.add(add);
        contentPane.add(sub);contentPane.add(div);
        contentPane.add(store);contentPane.add(edit);
        contentPane.add(close);contentPane.add(clear);
        contentPane.add(scroll);
        
        
    }
    public void setVisible(boolean x){
        list.removeAll();
        list.setListData(RPNForm.calc.register);                                
        super.setVisible(x);
    }
    public void actionPerformed(ActionEvent event) { 
        int index = list.getSelectedIndex();
        if(event.getSource() == add){  
            if(RPNForm.calc.theStack.isEmpty()||index==-1)return;            
            Double x = RPNForm.calc.theStack.getFirst();
            Double y = RPNForm.calc.register[index].getValue();
            RPNForm.calc.register[index].setValue(x+y); 
            this.setVisible(true);
        }else if(event.getSource() == sub){  
            if(RPNForm.calc.theStack.isEmpty()||index==-1)return;
            Double x = RPNForm.calc.theStack.getFirst();
            Double y = RPNForm.calc.register[index].getValue();
            RPNForm.calc.register[index].setValue(x-y); 
            this.setVisible(true);
        }else if(event.getSource() == mul){  
            if(RPNForm.calc.theStack.isEmpty()||index==-1)return;
            Double x = RPNForm.calc.theStack.getFirst();
            Double y = RPNForm.calc.register[index].getValue();
            RPNForm.calc.register[index].setValue(x*y); 
            this.setVisible(true);
        }else if(event.getSource() == div){ 
            if(RPNForm.calc.theStack.isEmpty()||index==-1)return;
            Double x = RPNForm.calc.theStack.getFirst();
            Double y = RPNForm.calc.register[index].getValue();
            if(y!=0)
                RPNForm.calc.register[index].setValue(x/y); 
            else
                JOptionPane.showMessageDialog(this, "can't divide by zero");
            this.setVisible(true);
        }else if(event.getSource() == store){ 
            if(RPNForm.calc.theStack.isEmpty()||index==-1)return;
            RPNForm.calc.register[index].setValue(RPNForm.calc.theStack.getFirst());
            this.setVisible(true);
        }else if(event.getSource() == edit){  
            if(index==-1)return;
            String str = JOptionPane.showInputDialog(this, "Enter label for register "+(char)('A'+index), "Edit Label",-1);            
            RPNForm.calc.register[index].setLable(str);
            this.setVisible(true);
        }else if(event.getSource() == close){  
            this.setVisible(false);
        }else if(event.getSource() == clear){  
            for(Register r:RPNForm.calc.register)
                r.setValue(0);
            this.setVisible(true);
        }
    }
}
