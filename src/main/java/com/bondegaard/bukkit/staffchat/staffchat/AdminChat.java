package com.bondegaard.bukkit.staffchat.staffchat;

import com.bondegaard.bukkit.staffchat.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChat implements CommandExecutor {

    protected String message = Main.getInstance().getConfig().getString("AdminChat-Format");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
        {
            return true;
        }

        final Player player = (Player) sender;
        String message = getMessage(args, 0);

        Bukkit.getOnlinePlayers().stream().filter(onlinePlayer -> onlinePlayer.hasPermission("adminchat.use")).forEach(onlinePlayer ->
        {
            onlinePlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', this.message.replace("{player}", player.getName()).replace("{message}", message)));
        });
        return  true;
    }
    private String getMessage(String[] args, int x)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = x; i < args.length; i++)
        {
            stringBuilder.append(args[i]).append( x >= args.length - 1 ? "" : " " );
        }
        return stringBuilder.toString();
    }
}
