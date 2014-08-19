package uk.co.Elllzman.Balance;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Elliot on 19/08/2014.
 */
public class EatingListener implements Listener {

    private Balance balance;

    public EatingListener(Balance balance){
        this.balance = balance;
    }


    @EventHandler
    public void onEat(PlayerItemConsumeEvent event)
    {
        if(event.getItem().getType().equals(Material.GOLDEN_APPLE)||balance.getCurrentState()==true){
            Player p = event.getPlayer();

            for (PotionEffect effect : p.getActivePotionEffects()){
                p.removePotionEffect(effect.getType());
            }


            double oldHealth = p.getMaxHealth();

            if(event.getItem().hasItemMeta()){
                if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("Golden Head"));
                {
                    double toHeal = oldHealth/2.5;
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (int)(toHeal*25), 1 ));

                }
            } else {
                double toHeal = oldHealth/5;
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (int) (toHeal * 25), 1));
            }


        }
    }
}
