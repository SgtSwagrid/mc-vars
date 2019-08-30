package factions.util;

/**
 * Floating-point number for global storage in the world file.
 * @author Alec Dorrington
 */
public class MCFloat extends MCVar {
    
    /**
     * Constructs a new float in the given table, with an initial value of 0.0.
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     */
    public MCFloat(String table, String name) {
        super(table, name);
        set(0.0F);
    }
    
    /**
     * Constructs a new float in the given table.
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     * @param value the initial value of the variable.
     */
    public MCFloat(String table, String name, float value) {
        super(table, name);
        set(value);
    }
    
    /**
     * @param value the new value for the variable.
     */
    public void set(float value) {
        int e = Math.getExponent(value);
        float m = (float)(value/Math.pow(2, e));
        setValue(NAME + "_m", (int)(m*(Integer.MAX_VALUE/2)));
        setValue(NAME + "_e", e);
    }
    
    /**
     * @return the current value of the variable.
     */
    public float get() {
        float m = (float)getValue(NAME + "_m")/(Integer.MAX_VALUE/2);
        return m * (float)Math.pow(2, getValue(NAME + "_e"));
    }
}