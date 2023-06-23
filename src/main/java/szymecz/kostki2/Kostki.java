package szymecz.kostki2;

import org.bukkit.plugin.java.JavaPlugin;

public final class Kostki extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ExampListener(), this);
        this.getCommand("poopoo").setExecutor(new PooPooModeCommand(this));
    }
}
