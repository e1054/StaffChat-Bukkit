package com.bondegaard.bukkit.staffchat;

import com.bondegaard.bukkit.staffchat.staffchat.AdminChat;
import com.bondegaard.bukkit.staffchat.staffchat.StaffChat;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Getter
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        // Commands
        getCommand("staffchat").setExecutor(new StaffChat());
        getCommand("adminchat").setExecutor(new AdminChat());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
