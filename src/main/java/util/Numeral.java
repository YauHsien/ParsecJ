package util;

public class Numeral {

    private int n_val = null;
    private double f_val = null;

    @Override
    public String toString() {
	if (isNumber()) {
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
	f_val = n;
    }

    public int getInteger() {
	return n_val;
    }

    protected void addInteger(int n1) {
	if (isInteger()) {
	    n_val = n_val + n1;
	    f_val = f_val + n1;
	} else {
	    f_val = f_val + n1;
	}
    }

    protected void timesInteger(int n1) {
	if (isInteger()) {
	    n_val = n_val * n1;
	    f_val = f_val * n1;
	} else {
	    f_val = f_val * n1;
	}
    }

    public void setDouble(double f) {
	n_val = null;
	f_val = f;
    }

    public double getDouble() {
	return f_val;
    }

    protected void addDouble(double f1) {
	if (isInteger()) {
	    n_val = null;
	    f_val = f_val + f1;
	} else {
	    f_val = f_val + f1;
	}
    }

    protected void divideDouble(double f1) {
	if (isInteger()) {
	    n_val = null;
	    f_val = f_val / f1;
	} else {
	    f_val = f_val / f1;
	}
    }

    public Numeral add(Numeral numeral) {
	if (numeral.isInteger()) {
	    addInteger(numeral.getInteger());
	} else {
	    addDouble(numeral.getDouble());
	}
	return this;
    }

    public Numeral subtract(Numeral numeral) {
	if (numeral.isInteger()) {
	    addInteger(-(numeral.getInteger()));
	} else {
	    addDouble(-(numeral.getDouble()));
	}
	return this;
    }

    public Numeral times(Numeral numeral) {
	if (numeral.isInteger()) {
	    timesInteger(numeral.getInteger());
	} else {
	    timesDouble(numeral.getDouble());
	}
	return this;
    }

    public Numeral divide(Numeral numeral) {
	if (numeral.isInteger()) {
	    divideInteger(numeral.getInteger());
	} else {
	    divideDouble(numeral.getDouble());
	}
	return this;
    }
}
