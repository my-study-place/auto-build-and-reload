package me.saidbysolo.study;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

public class Cuboid {
    public final Player player;
    public final Vector firstVector;
    public final Vector secondVector;
    public final World world;

    public Cuboid(Location firstLocation, Location secondLocation, Player player) {
        if (!firstLocation.getWorld().equals(firstLocation.getWorld())) {
            player.sendMessage("월드는 다를수 없습니다.");
        }
        this.player = player;
        this.world = firstLocation.getWorld();
        this.firstVector = firstLocation.toVector();
        this.secondVector = secondLocation.toVector();
    }

    public void bi() {
        Vector subVector = this.firstVector.subtract(this.secondVector);
        BlockIterator bi = new BlockIterator(this.world, this.secondVector, subVector, 0, 20);
        while (bi.hasNext()) {
            Block block = bi.next();
            this.player.sendMessage("Block found: " + block.getType() + " at: " + block.getX() + ", " + block.getY()
                    + ", " + block.getZ());
        }
    }

}
