package org.carp.essentials.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;
import org.carp.essentials.Anvil;

public class AnvilListener implements Listener {

    @EventHandler
    @SuppressWarnings("All")
    public void onAnvilPrepared(PrepareAnvilEvent event) {

        AnvilInventory inventory = event.getInventory();

        boolean no_repair_limit = Anvil.config.getBoolean("General.no-repair-limit");
        int repair_cost = Anvil.config.getInt("General.repair-cost");
        boolean isDebugging = Anvil.config.getBoolean("Miscellaneous.debug");

        inventory.setRepairCost(repair_cost);
        inventory.setRepairCostAmount(repair_cost);

        /**
         * Item that is going to be enchanting
         */
        ItemStack firstItem = inventory.getItem(0);
        if (firstItem != null) {

            if (no_repair_limit) {
                ItemMeta firstItemMeta = firstItem.getItemMeta();

                if (firstItemMeta instanceof Repairable) {
                    Repairable repairable = (Repairable) firstItemMeta;
                    repairable.setRepairCost(0); // Set the anvil use count to 0
                    firstItem.setItemMeta(firstItemMeta);
                }
            }

            if (isDebugging) {
                Anvil.getInstance().getLogger().warning("[DEBUG]: " + ((Repairable)firstItem.getItemMeta()).getRepairCost());
            }
        }

        /**
         * Result item after enchantment
         */
        ItemStack result = event.getResult();
        if (result != null) {

            if (no_repair_limit) {
                ItemMeta resultMeta = result.getItemMeta();

                if (resultMeta instanceof Repairable) {
                    Repairable repairable = (Repairable) resultMeta;
                    repairable.setRepairCost(0); // Set the anvil use count to 0
                    result.setItemMeta(resultMeta);
                }
            }

            if (isDebugging) {
                Anvil.getInstance().getLogger().warning("[DEBUG]: " + ((Repairable)result.getItemMeta()).getRepairCost());
            }
        }
    }
}
