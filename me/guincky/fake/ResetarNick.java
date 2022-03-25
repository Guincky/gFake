package me.guincky.fake;

import org.kitteh.tag.TagAPI;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.event.*;

public class ResetarNick implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("fakereset")) {
            if (p.hasPermission("gfake.usar")) {
                p.sendMessage("§aVocê está usando seu nick original novamente!");
            }
            p.setDisplayName("§f" + p.getName() + "§f");
            p.setPlayerListName("§f" + p.getName());
            TagAPI.refreshPlayer(p);
        }
        return false;
    }
}
