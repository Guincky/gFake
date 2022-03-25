package me.guincky.fake;

import org.bukkit.event.EventHandler;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;
import org.kitteh.tag.TagAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Fake implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            if (!p.hasPermission("gfake.usar")) {
                p.sendMessage("§aVocê não possui permissão suficiente para usar esse comando!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§eModo correto de usar: /fake (nick).");
                return true;
            }
            String nome = "";
            for (final String arg : args) {
                nome = String.valueOf(nome) + arg + " ";
            }
            nome = nome.substring(0, nome.length() - 1);
            nome = nome.replaceAll("&", "§");
            p.sendMessage("§aSeu nick foi alterado com sucesso para " + ChatColor.GREEN + nome);
            p.setDisplayName("§f§7" + nome + "§f");
            p.setPlayerListName("§7" + nome);
            TagAPI.refreshPlayer(p);
        }
        return false;
    }
    
    @EventHandler
    public void QuandoMudar(final AsyncPlayerReceiveNameTagEvent e) {
        final Player p = e.getNamedPlayer();
        e.setTag(p.getDisplayName());
    }
}
