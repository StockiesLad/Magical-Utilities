package net.fluffybumblebee.terrains.common.registry.sets;

import net.fluffybumblebee.terrains.common.registry.sets.crystal_geodes.CrystalGeodeSetConfig;
import net.fluffybumblebee.terrains.common.registry.sets.crystal_geodes.CrystalGeodeTypes;
import net.fluffybumblebee.terrains.common.registry.sets.experimental.MapleTreeSetConfig;
import net.fluffybumblebee.terrains.common.registry.sets.tree.stained.StainedTreeTypes;
import net.fluffybumblebee.terrains.common.registry.sets.tree.stained.OakLikeSetConfig;
import net.fluffybumblebee.terrains.util.registration.feature_set.FeatureSet;

public final class AllFeatureSets {
    public static final FeatureSet<StainedTreeTypes, OakLikeSetConfig<StainedTreeTypes>> STAINED_TREES;
    public static final FeatureSet<CrystalGeodeTypes, CrystalGeodeSetConfig<CrystalGeodeTypes>> CRYSTAL_GEODES;

    static {
        STAINED_TREES = new FeatureSet<>(StainedTreeTypes.values(), OakLikeSetConfig::new);
        CRYSTAL_GEODES = new FeatureSet<>(CrystalGeodeTypes.values(), CrystalGeodeSetConfig::new);
    }

    private AllFeatureSets() {}
    public static void register() {
        MapleTreeSetConfig.register();
    }
}
