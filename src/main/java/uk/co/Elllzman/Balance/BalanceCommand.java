package uk.co.Elllzman.Balance;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Elliot on 19/08/2014.
 */
public class BalanceCommand implements CommandExecutor {

    Balance balance;



    public BalanceCommand(Balance balance) {
        this.balance = balance;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length<1){
            sender.sendMessage(ChatColor.RED + "Invalid args!");
            return true;
        }

        if(args[0].equalsIgnoreCase("enable")||args[0].equalsIgnoreCase("on")){
            balance.setCurrentState(true);
            balance.getServer().broadcastMessage(ChatColor.GREEN + "Balance enabled by " + sender.getName());
            return true;
        }
        if(args[0].equalsIgnoreCase("disable")||args[0].equalsIgnoreCase("off")){
            balance.setCurrentState(true);
            balance.getServer().broadcastMessage(ChatColor.RED + "Balance disabled by " + sender.getName());
            return true;
        }

        if(args[0].equalsIgnoreCase("state")){
            sender.sendMessage(ChatColor.GOLD + "Balance is currently " + balance.getCurrentState());
            return true;
        }
        else {
            sender.sendMessage(ChatColor.RED + "Invalid arguments!");
            return true;
        }
    }
}
