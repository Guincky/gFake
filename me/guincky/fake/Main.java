package me.guincky.fake;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
        this.RegisterEvents();
        this.getServer().getConsoleSender().sendMessage("§f[gFake] O plugin foi ativado com êxito.");
        this.getServer().getConsoleSender().sendMessage("&f[gFake] github.com/Guincky");
    }
    
    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage("§f[gFake] O plugin foi desativado com êxito.");
        this.getServer().getConsoleSender().sendMessage("&f[gFake] github.com/Guincky");
    }
    
    private void RegisterEvents() {
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new Fake(), (Plugin)this);
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new ResetarNick(), (Plugin)this);
        this.getCommand("fake").setExecutor((CommandExecutor)new Fake());
        this.getCommand("fakereset").setExecutor((CommandExecutor)new ResetarNick());
    }
}
