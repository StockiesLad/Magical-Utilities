package net.fluffybumblebee.terrains.common.world.inbuilt_features.raw;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class ScatteredBlockFeature extends Feature<RandomPatchFeatureConfig> {
    public ScatteredBlockFeature(Codec<RandomPatchFeatureConfig> codec) {
        super(codec);
    }


    @Override
    public boolean generate(FeatureContext<RandomPatchFeatureConfig> context) {
        RandomPatchFeatureConfig randomPatchFeatureConfig = context.getConfig();
        Random random = context.getRandom();
        BlockPos blockPos = context.getOrigin();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        int i = 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int j = randomPatchFeatureConfig.xzSpread() + 1;
        int k = randomPatchFeatureConfig.ySpread() + 1;

        for(int l = 0; l < 1; ++l) {
            mutable.set(blockPos, random.nextInt(j) - random.nextInt(j), random.nextInt(k) - random.nextInt(k), random.nextInt(j) - random.nextInt(j));
            if (randomPatchFeatureConfig.feature().value().generateUnregistered(structureWorldAccess, context.getGenerator(), random, mutable)) {
                ++i;
            }
        }

        return i > 0;
    }
}
