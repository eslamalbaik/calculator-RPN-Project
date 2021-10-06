package RPN;
import java.util.Deque;
import java.util.LinkedList;
public class RPNCalculator{ 
  public static final int NUMBER_OF_REGISTERS = 26;
  public Deque<Double> theStack = new LinkedList<>();  
  public Register[] register = new Register[NUMBER_OF_REGISTERS];

    public RPNCalculator() {
        for(int i=0;i<register.length;++i){
            register[i]= new Register(0.0,"no lable",""+(char)('A'+i));     
        }
    } 
    public boolean add(){
        if(theStack.size()<2)return false;
        Double x = theStack.removeFirst();
        Double y = theStack.removeFirst();
        theStack.addFirst(x+y);
        return true;
    }
    public boolean sub(){
        if(theStack.size()<2)return false;
        Double x = theStack.removeFirst();
        Double y = theStack.removeFirst();
        theStack.addFirst(x-y);
        return true;
    }
    public boolean mul(){
        if(theStack.size()<2)return false;
        Double x = theStack.removeFirst();
        Double y = theStack.removeFirst();
        theStack.addFirst(x*y);
        return true;
    }
    public boolean div(){
        if(theStack.size()<2)return false;
        Double x = theStack.removeFirst();
        Double y = theStack.removeFirst();        
        if(y!=0){
            theStack.addFirst(x/y);
            return true;
        }else{
            theStack.addFirst(y);
            theStack.addFirst(x);
            return false;
        }            
    }    
    public boolean pow(){
        if(theStack.size()<2)return false;
        Double x = theStack.removeFirst();
        Double y = theStack.removeFirst();
        theStack.addFirst(Math.pow(x, y));
        return true;
    }
    public boolean mod(){
        if(theStack.size()<2)return false;
        Double x = theStack.removeFirst();
        Double y = theStack.removeFirst();
        theStack.addFirst(x%y);
        return true;
    }
    public boolean inverseMul(){
        if(theStack.size()<1)return false;
        Double temp =theStack.removeFirst();
        if(temp!=0)
            theStack.addFirst( 1/temp);
        return true;
    }
    public boolean inverseAdd(){
        if(theStack.size()<1)return false;        
        theStack.addFirst(-theStack.removeFirst());
        return true;
    }
    public boolean inverseAdd5(){
        if(theStack.size()<1)return false;        
        theStack.addFirst(-theStack.removeFirst());
        return true;
    }
    public boolean up(){
        if(theStack.isEmpty())return false;
        theStack.addLast(theStack.removeFirst());
        return true;    
    }
    public boolean down(){
        if(theStack.isEmpty())return false;
        theStack.addFirst(theStack.removeLast());
        return true;    
    }
    
    public boolean push(){
        String temp = RPNForm.displayTextField.getText();
        if(temp.length()==0)return false;
        if(temp.endsWith("."))temp = temp.substring(0,temp.length()-1);
        if(temp.length()==0)return false;
        theStack.addFirst(new Double(temp));
        RPNForm.displayTextField.setText("");
        return true;        
    }
    public void c(){
        theStack.clear();        
    }
    public boolean ce(){
        if(theStack.isEmpty())return false;
        theStack.removeFirst();
        return true;
    }
}





