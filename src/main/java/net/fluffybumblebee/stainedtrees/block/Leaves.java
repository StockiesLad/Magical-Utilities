package net.fluffybumblebee.stainedtrees.block;

import net.fluffybumblebee.stainedtrees.util.STUtil;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.sound.BlockSoundGroup;

public class Leaves extends LeavesBlock {
    public Leaves() {
        super(Settings
                .copy(Blocks.OAK_LEAVES)
                .nonOpaque()
                .ticksRandomly()
                .strength(0.2F)
                .sounds(BlockSoundGroup.GRASS)
                .suffocates(STUtil::never)
                .allowsSpawning(STUtil::canSpawnOnLeaves)
                .blockVision(STUtil::never));
    }
}
