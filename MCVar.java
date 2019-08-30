package factions.util;

import net.minecraft.scoreboard.IScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.common.DimensionManager;

/**
 * Abstract supertype for world-saved data structures.
 * For use in storing global values in the world.
 * Automatically synced across client and server.
 * Uses the Minecraft scoreboard to store values.
 * 
 * @author Alec Dorrington
 */
public abstract class MCVar {
    
    /** The global scoreboard in which values are stored. */
    private static final Scoreboard SCOREBOARD =
            DimensionManager.getWorld(0).getScoreboard();
    
    /** The scoreboard table in which this variable is stored. */
    private final ScoreObjective TABLE;
    
    /** The name of this variable. */
    protected final String NAME;
    
    /**
     * Constructs a new variable in the given table.
     * @param table the table in which the variable should reside.
     * @param name the name of the variable.
     */
    protected MCVar(String table, String name) {
        TABLE = getTable(table);
        NAME = name.toLowerCase().replace(" ", "_");
    }
    
    /**
     * Sets the value of an entry in the table.
     * @param name the name/key of the entry.
     * @param value the value of the entry.
     */
    protected void setValue(String name, int value) {
        name = name.toLowerCase().replace(" ", "_");
        Score entry = SCOREBOARD.getOrCreateScore(name, TABLE);
        entry.setScorePoints(value);
    }
    
    /**
     * Gets the value of an entry in the table.
     * @param name the name/key of the entry.
     * @return the value of the entry.
     */
    protected int getValue(String name) {
        name = name.toLowerCase().replace(" ", "_");
        return SCOREBOARD.getOrCreateScore(name, TABLE).getScorePoints();
    }
    
    /**
     * Finds the table of a given name, creating one if necessary.
     * @param table the name of the table.
     * @return the table matching this name.
     */
    private static ScoreObjective getTable(String table) {
        ScoreObjective objective = SCOREBOARD.getObjective(table);
        return objective != null ? objective :
                SCOREBOARD.addScoreObjective(table, IScoreCriteria.DUMMY);
    }
    
    @Override
    public String toString() { return NAME; }
    
    @Override
    public boolean equals(Object o) {
        return o instanceof MCVar
                && ((MCVar)o).TABLE.equals(TABLE)
                && ((MCVar)o).NAME.equals(NAME);
    }
}