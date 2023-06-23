package szymecz.kostki2;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class TestScheduler extends BukkitRunnable {

    private final JavaPlugin plugin;
    private final Player player;

    public TestScheduler(JavaPlugin plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }

    @Override
    public void run() {
        Vector vector = player.getLocation().toVector();
        int range=1;
        for (int x = -range; x<=range; x++){
            for (int z = -range; z<=range; z++){
                if(x==0&&z==0) {
                    continue;
                }
                Vector offset = new Vector(x, 0, z);
                Vector currentLocation = vector.clone();
                currentLocation.add(offset).toLocation(player.getWorld()).getBlock().setType(Material.BROWN_WOOL);
            }

        }
    }
}
