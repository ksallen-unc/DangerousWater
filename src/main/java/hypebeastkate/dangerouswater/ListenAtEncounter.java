package hypebeastkate.dangerouswater;

import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTag.BlockType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ListenAtEncounter implements Listener {
  DangerousWater plugin;

  public ListenAtEncounter(DangerousWater instance) {
    instance = plugin;
  }

  @EventHandler
  public void encounterWater(PlayerMoveEvent event) {
    Player myPlayer = event.getPlayer();
    // Bukkit.broadcastMessage(ChatColor.RED + "[DangerousWater] " + ChatColor.WHITE + "Player moved");
    if (!((myPlayer.getGameMode()).equals(GameMode.CREATIVE))) {
      Material currBlock = event.getTo().getBlock().getType();
      if (currBlock.equals(Material.WATER)) {
        Bukkit.broadcastMessage(
            ChatColor.RED + "[DangerousWater] " + ChatColor.WHITE + "Water encountered");
        // check if other water materials exist (Stationary_Water deprecated)
        // to poison player, probably best way bc water extinguishes fire in mc
        PotionEffect poison = new PotionEffect(PotionEffectType.POISON, 60, 1);
        // for duration 20, measured in ticks, 60 ticks = 3s
        // 1 = amplifier
        event.getPlayer().addPotionEffect(poison);
        // or this instead? to set on fire for 1s = 20 ticks
        event.getPlayer().setFireTicks(20);
      }
    }

  }

}
