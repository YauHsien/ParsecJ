package util;

public class Numeral implements Cloneable {

    @Override
    public Numeral clone() {
	Object o = null;
	try {
	    o = super.clone();
	} catch(Exception e) {
	    e.printStackTrace();
	}
	return (Numeral)o;
    }

    private Integer n_val = null;
    private Double f_val = null;

    @Override
    public String toString() {
	if (isInteger()) {
	    return "" + n_val;
	} else {
	    return "" + f_val;
	}
    }
    
    public Numeral(int n) {
	setInteger(n);
    }

    public Numeral(double f) {
	setDouble(f);
    }

    public boolean isInteger() {
	return n_val != null;
    }

    public boolean isDouble() {
	return n_val == null;
    }

    public void setInteger(int n) {
        n_val = n;
	f_val = new Double(n);
    }

    public int getInteger() {
	return n_val;
    }

    protected void addInteger(Integer n1) {
	if (isInteger()) {
	    n_val = n_val + n1;
	    f_val = f_val + n1;
	} else {
	    f_val = f_val + n1;
	}
    }

    protected void timesInteger(Integer n1) {
	if (isInteger()) {
	    n_val = n_val * n1;
	    f_val = f_val * n1;
	} else {
	    f_val = f_val * n1;
	}
    }

    protected void timesDouble(Double f1) {
	if (isInteger()) {
	    n_val = null;
	    f_val = f_val * f1;
	} else {
	    f_val = f_val * f1;
	}
    }

    public void setDouble(double f) {
	n_val = null;
	f_val = f;
    }

    public double getDouble() {
	return f_val;
    }

    protected void addDouble(Double f1) {
	if (isInteger()) {
	    n_val = null;
	    f_val = f_val + f1;
	} else {
	    f_val = f_val + f1;
	}
    }

    protected void divideInteger(Integer n1) {
	if (isInteger()) {
	    n_val = null;
	    f_val = f_val / n1;
	} else {
	    f_val = f_val / n1;
	}
    }
    
    protected void divideDouble(Double f1) {
	if (isInteger()) {
	    n_val = null;
	    f_val = f_val / f1;
	} else {
	    f_val = f_val / f1;
	}
    }

    public Numeral add(Numeral numeral) {
	Numeral me = this.clone();
	if (numeral.isInteger()) {
	    me.addInteger(numeral.getInteger());
	} else {
	    me.addDouble(numeral.getDouble());
	}
	return me;
    }

    public Numeral subtract(Numeral numeral) {
	Numeral me = this.clone();
	if (numeral.isInteger()) {
	    me.addInteger(-(numeral.getInteger()));
	} else {
	    me.addDouble(-(numeral.getDouble()));
	}
	return me;
    }

    public Numeral times(Numeral numeral) {
	Numeral me = this.clone();
	if (numeral.isInteger()) {
	    me.timesInteger(numeral.getInteger());
	} else {
	    me.timesDouble(numeral.getDouble());
	}
	return me;
    }

    public Numeral divide(Numeral numeral) {
	Numeral me = this.clone();
	if (numeral.isInteger()) {
	    me.divideInteger(numeral.getInteger());
	} else {
	    me.divideDouble(numeral.getDouble());
	}
	return me;
    }
}
