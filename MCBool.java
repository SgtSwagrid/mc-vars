package factions.util;

/**
 * Boolean for global storage in the world file.
 * @author Alec Dorrington
 */
public class MCBool extends MCVar {
    
    /**
     * Constructs a new boolean in the given table, with an initial value of false.
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     */
    public MCBool(String table, String name) {
        super(table, name);
        set(false);
    }
    
    /**
     * Constructs a new boolean in the given table.
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     * @param value the initial value of the variable.
     */
    public MCBool(String table, String name, boolean value) {
        super(table, name);
        set(value);
    }
    
    /**
     * @param value the new value for the variable.
     */
    public void set(boolean value) {
        setValue(NAME, value ? 1 : 0);
    }
    
    /**
     * @return the current value of the variable.
     */
    public boolean get() {
        return getValue(NAME) == 1;
    }
    
    @Override
    public String toString() { return Boolean.toString(get()); }
    
    @Override
    public boolean equals(Object o) {
        return o instanceof MCBool && ((MCBool) o).get() == get();
    }
}