package szymecz.kostki2;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitTask;

import java.lang.Math;

public class ExampListener implements Listener {


    @EventHandler
    public void onPlayerInteract(BlockPlaceEvent event){
        if(PooPooModeCommand.ppmode) {
            Player player = event.getPlayer();
            PlayerInventory inv = player.getInventory();
            if(inv.getItemInMainHand().getType().equals(Material.BROWN_WOOL)) {

                Block block = event.getBlock();
                Location blockLoc = block.getLocation();
                if(event.getBlockAgainst().getType()==Material.BROWN_CARPET) {
                    event.getBlockAgainst().setType(Material.BROWN_WOOL);
                    event.setCancelled(true);
                } else {
                    block.setType(Material.BROWN_CARPET);
                }

                //Fart
                makeFart(player);

            }
        }
    }

    private void makeFart(Player player){
        Location loc = player.getLocation();
        player.playSound(loc, Sound.ENTITY_SALMON_FLOP, 3f, 0.2f);
        int rand = (int) (Math.random() * 4);
        String[] msgs = {"zesrales sie :/", "prrptpoohhrbrt", "umyj fotel:((", "fuj, pusciles smierdzioszka!! >.<"};
        BlockFace facing = player.getFacing();
        player.sendMessage(ChatColor.RED + msgs[rand]);
        if (facing.equals(BlockFace.NORTH)) {
            loc.add(0, 0, 1);
        } else if (facing.equals(BlockFace.SOUTH)) {
            loc.subtract(0, 0, 1);
        } else if (facing.equals(BlockFace.WEST)) {
            loc.add(1, 0, 0);
        } else if (facing.equals(BlockFace.EAST)) {
            loc.subtract(1, 0, 0);
        }
        AreaEffectCloud cloud = (AreaEffectCloud) loc.getWorld().spawnEntity(loc, EntityType.AREA_EFFECT_CLOUD);
        cloud.setColor(Color.GREEN);
        cloud.setRadius(1);
        cloud.setDuration(20 * 3);
    }

}
