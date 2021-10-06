
package RPN;

import java.io.Serializable;


public class Register implements Serializable {
    public static final long serialVersionID = 512L;
    private double value;
   private String label;
  private  String name;

    public Register(double value, String label, String name) {
        this.value = value;
        this.label = label;
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setLable(String label) {
        this.label = label;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%2s = %-30.2f {%-8s}",name,value,label); 
    }
    
    
    
}
