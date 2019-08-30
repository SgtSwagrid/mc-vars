package factions.util;

/**
 * Character for global storage in the world file.
 * @author Alec Dorrington
 */
public class MCChar extends MCVar {
    
    /**
     * Constructs a new character in the given table, with an initial value of '0'.
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     */
    public MCChar(String table, String name) {
        super(table, name);
        set('0');
    }
    
    /**
     * Constructs a new character in the given table.
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     * @param value the initial value of the variable.
     */
    public MCChar(String table, String name, char value) {
        super(table, name);
        set(value);
    }
    
    /**
     * @param value the new value for the variable.
     */
    public void set(char value) {
        setValue(NAME, value);
    }
    
    /**
     * @return the current value of the variable.
     */
    public char get() {
        return (char) getValue(NAME);
    }
    
    @Override
    public String toString() { return Character.toString(get()); }
    
    @Override
    public boolean equals(Object o) {
        return o instanceof MCChar && ((MCChar) o).get() == get();
    }
}