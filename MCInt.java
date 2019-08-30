package factions.util;

/**
 * Integer for global storage in the world file.
 * @author Alec Dorrington
 */
public class MCInt extends MCVar {
    
    /**
     * Constructs a new integer in the given table, with an initial value of 0.
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     */
    public MCInt(String table, String name) {
        super(table, name);
        set(0);
    }
    
    /**
     * Constructs a new integer in the given table.
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     * @param value the initial value of the variable.
     */
    public MCInt(String table, String name, int value) {
        super(table, name);
        set(value);
    }
    
    /**
     * @param value the new value for the variable.
     */
    public void set(int value) {
        setValue(NAME, value);
    }
    
    /**
     * @return the current value of the variable.
     */
    public int get() {
        return getValue(NAME);
    }
}