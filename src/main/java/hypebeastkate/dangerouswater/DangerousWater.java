package hypebeastkate.dangerouswater;

import org.bukkit.plugin.java.JavaPlugin;

public final class DangerousWater extends JavaPlugin {

  public DangerousWater() {}

  @Override
  public void onEnable() {
    // Plugin startup logic
    // 1) Start logging encounters with water (method of JavaPlugin class)
    this.getServer().getPluginManager().registerEvents(new ListenAtEncounter(this), this);
    this.getConfig();  // 2) run getConfig from parent class (JavaPlugin)
    this.saveConfig(); // 3) Save the config that's been set up
    this.getLogger().info("Enabled firewater plugin");
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
    this.getLogger().info("Disabled firewater plugin");

  }
}
