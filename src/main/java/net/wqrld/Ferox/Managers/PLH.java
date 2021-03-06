package net.wqrld.Ferox.Managers;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.jpountz.lz4.LZ4Utils;
import org.bukkit.entity.Player;

public class PLH extends PlaceholderExpansion {
    public String getIdentifier() {
        return "ferox";
    }

    public String getAuthor() {
        return "Wqrld";
    }

    public String getVersion() {
        return "1.1.0";
    }

    public String onPlaceholderRequest(Player player, String identifier) {

        // We check if the player is null (not online) before any player-related placeholder
        if (player == null) {
            return null;
        }
        if (identifier.equalsIgnoreCase("isstaff")) {
            return "true";
        }

        if (identifier.equalsIgnoreCase("nexuscount")) {

            return RotationManager.GetCurrentMap().getNexuscount().toString();

        }
//✅✅✅✘✔

        if (identifier.startsWith("nexusstatus_")) {
            String nexusname = identifier.split("_")[1];
            if (MatchManager.isBroken(nexusname)) {
                return "&c✘";
            } else {
                return "&a✔";
            }
        }
        if (identifier.equalsIgnoreCase("matchtime")) {
            return MatchManager.getMatchTime();
        }

        if (identifier.equalsIgnoreCase("team")) {

            if (TeamManager.getblue().contains(player)) {
                return "blue";
            } else if (TeamManager.getred().contains(player)) {
                return "red";
            } else {
                return "None";
            }


        }
        if (identifier.equalsIgnoreCase("map")) {
            return RotationManager.GetCurrentMap().getName();
        }


        if (identifier.equalsIgnoreCase("teams")) {
            return TeamManager.getblue().toString() + " b | r " + TeamManager.getred().toString();
        }
        // Placeholder: %exampleplugin_player_name%
        if (identifier.equalsIgnoreCase("color")) {
            if (TeamManager.getblue().contains(player)) {
                return "§9";
            } else if (TeamManager.getred().contains(player)) {
                return "§c";
            } else {
                return "§f";
            }
        }

        // We return null, if an invalid placeholder was called.
        return "null";
    }


}
