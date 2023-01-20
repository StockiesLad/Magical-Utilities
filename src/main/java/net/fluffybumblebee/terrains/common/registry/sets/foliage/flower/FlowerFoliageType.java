package net.fluffybumblebee.terrains.common.registry.sets.foliage.flower;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fluffybumblebee.terrains.common.registry.sets.foliage.TypesFoliage;
import net.fluffybumblebee.terrains.util.registration.registry_set.registrars.RegistryTypes;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Arrays;

import static net.fluffybumblebee.terrains.common.registry.sets.foliage.component.FoliageSet.FeatureCreator;
import static net.fluffybumblebee.terrains.util.registration.world.feature.TerrainsFeatureRegistrar.registerConfiguredFeature;
import static net.fluffybumblebee.terrains.util.registration.world.feature.TerrainsFeatureRegistrar.registerPlacedFeature;
import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.modifiers;

public final  class FlowerFoliageType {
    public static final TypesFoliage<FlowerBlock, FlowerTypes, FlowerFeatures> ALL_FLOWERS = new TypesFoliage<>(
            Arrays.asList(FlowerTypes.values()),
            (types) -> new FlowerBlock(
                    types.EFFECT, types.EFFECT_TIME,
                    FabricBlockSettings
                            .of(Material.PLANT)
                            .breakInstantly()
                            .noCollision()
                            .sounds(BlockSoundGroup.GRASS)
            ),
            "flower",
            true,
            FlowerFeatures::new,
            RegistryTypes.FLOWER
    );

    public enum FlowerTypes {
        LAVENDER(StatusEffects.REGENERATION, 3);




        private final StatusEffect EFFECT;
        private final int EFFECT_TIME;

        FlowerTypes(StatusEffect effect, int effectTime) {
            EFFECT = effect;
            EFFECT_TIME = effectTime;
        }
    }

    public static class FlowerFeatures implements FeatureCreator {
        public final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig,?>> CONFIGURED_FLOWER_PATCH;

        public final RegistryEntry<PlacedFeature> PLACED_FLOWER_PATCH;

        public FlowerFeatures(Block block, String name) {
            CONFIGURED_FLOWER_PATCH = registerConfiguredFeature(
                    name  + "_patch",
                    Feature.RANDOM_PATCH,
                    new RandomPatchFeatureConfig(96, 6, 2,
                            PlacedFeatures.createEntry(
                                    Feature.SIMPLE_BLOCK,
                                    new SimpleBlockFeatureConfig(BlockStateProvider.of(block))
                            )
                    )
            );
            PLACED_FLOWER_PATCH = registerPlacedFeature(
                     name + "_patch",
                    CONFIGURED_FLOWER_PATCH,
                    modifiers(16)
            );
        }
    }
}
