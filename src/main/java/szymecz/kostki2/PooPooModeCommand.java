package szymecz.kostki2;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitTask;

public class PooPooModeCommand implements CommandExecutor {
    public static boolean ppmode = false;
    private final Kostki plugin;
    public PooPooModeCommand(Kostki plugin) {
        this.plugin=plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        Player player = (Player) sender;
        if (args.length==1) {
            int arg1;
            try {
                arg1 = Integer.parseInt(args[0]);
            } catch (Throwable t) {
                return false;
            }
            if (arg1>=1 && arg1<=64) {
                ItemStack itemStack = new ItemStack(Material.BROWN_WOOL, arg1);
                PlayerInventory inv = player.getInventory();
                inv.setItem(0, itemStack);
                ppmode = true;
                BukkitTask task = new TestScheduler(plugin, player).runTaskTimer(this.plugin, 10, 400);
                return true;
            }

        }

        return false;
    }
}
