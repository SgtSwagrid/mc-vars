package factions.util;

import net.minecraft.util.math.BlockPos;

/**
 * Position for global storage in the world file.
 * @author Alec Dorrington
 */
public class MCPosition extends MCVar {
    
    /**
     * Constructs a new position in the given table, with an initial value of (0, 0, 0).
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     */
    public MCPosition(String table, String name) {
        super(table, name);
        set(new BlockPos(0, 0, 0));
    }
    
    /**
     * Constructs a new position in the given table.
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     * @param value the initial value of the variable.
     */
    public MCPosition(String table, String name, BlockPos value) {
        super(table, name);
        set(value);
    }
    
    /**
     * @param value the new value for the variable.
     */
    public void set(BlockPos value) {
        setValue(NAME + "_x", value.getX());
        setValue(NAME + "_y", value.getY());
        setValue(NAME + "_z", value.getZ());
    }
    
    /**
     * @return the current value of the variable.
     */
    public BlockPos get() {
        return new BlockPos(
                getValue(NAME + "_x"),
                getValue(NAME + "_y"),
                getValue(NAME + "_z"));
    }
    
    @Override
    public String toString() { return get().toString(); }
    
    @Override
    public boolean equals(Object o) {
        return o instanceof MCPosition && ((MCPosition) o).get().equals(get());
    }
}