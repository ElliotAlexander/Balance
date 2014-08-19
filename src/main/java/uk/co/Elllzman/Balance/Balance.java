package uk.co.Elllzman.Balance;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Elliot on 19/08/2014.
 */
public class Balance extends JavaPlugin{

    private boolean currentState;

    public void onEnable(){
        Balance plugin = this;

        currentState = false;



        plugin.getServer().getPluginManager().registerEvents(new EatingListener(this), plugin);

        plugin.getCommand("BalanceHealth").setExecutor(new BalanceCommand(this));

    }


    public void setCurrentState(Boolean b)
    {
        currentState = b;
    }

    protected boolean getCurrentState(){
        return currentState;
    }
}
