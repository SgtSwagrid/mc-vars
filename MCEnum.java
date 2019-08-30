package factions.util;

import java.util.EnumSet;
import java.util.List;
import java.util.ArrayList;

/**
 * Enum for global storage in the world file.
 * @author Alec Dorrington
 */
public class MCEnum<T extends Enum<T>> extends MCVar {
    
    /** The enum representing the set of values the variable may take. */
    private final List<T> DOMAIN;
    
    /**
     * Constructs a new integer in the given table, with an initial value of 0.
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     * @param domain the enum representing the set of values the variable may take.
     */
    public MCEnum(String table, String name, Class<T> domain) {
        super(table, name);
        DOMAIN = new ArrayList<>(EnumSet.allOf(domain));
        setValue(NAME, 0);
    }
    
    /**
     * Constructs a new integer in the given table.
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     * @param domain the enum representing the set of values the variable may take.
     * @param value the initial value of the variable.
     */
    public MCEnum(String table, String name, Class<T> domain, Enum<T> value) {
        super(table, name);
        DOMAIN = new ArrayList<>(EnumSet.allOf(domain));
        set(value);
    }
    
    /**
     * @param value the new value for the variable.
     */
    public void set(Enum<T> value) {
        setValue(NAME, value.ordinal());
    }
    
    /**
     * @return the current value of the variable.
     */
    public T get() {
        return DOMAIN.get(getValue(NAME));
    }
}