package com.aetherteam.aether_genesis.data.resources.registries;

import com.aetherteam.aether_genesis.Genesis;
import com.aetherteam.aether_genesis.data.resources.GenesisFeatureStates;
import com.aetherteam.aether_genesis.world.foliageplacer.AetherPineFoliagePlacer;
import com.aetherteam.aether_genesis.world.foliageplacer.HookedFoliagePlacer;
import com.aetherteam.aether_genesis.world.treedecorator.TrunkDecorator;
import com.aetherteam.aether_genesis.world.trunkplacer.HookedTrunkPlacer;
import com.aetherteam.aether_genesis.world.trunkplacer.SkinnyHookedTrunkPlacer;
import com.aetherteam.aether.data.resources.AetherFeatureStates;
import com.aetherteam.aether.data.resources.builders.AetherConfiguredFeatureBuilders;
import com.aetherteam.aether.world.feature.AetherFeatures;
import com.aetherteam.aether.world.foliageplacer.GoldenOakFoliagePlacer;
import com.aetherteam.aether.world.trunkplacer.GoldenOakTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class GenesisConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_AERCLOUD_4_CONFIGURATION = createKey("green_aercloud_4");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_AERCLOUD_8_CONFIGURATION = createKey("green_aercloud_8");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_AERCLOUD_CONFIGURATION = createKey("purple_aercloud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STORM_AERCLOUD_CONFIGURATION = createKey("storm_aercloud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_GREEN_SKYROOT_TREE_CONFIGURATION = createKey("large_green_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_SKYROOT_TREE_CONFIGURATION = createKey("blue_skyroot_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_SKYROOT_PINE_CONFIGURATION = createKey("green_skyroot_pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_SKYROOT_PINE_CONFIGURATION = createKey("blue_skyroot_pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DARK_BLUE_HOOKED_SKYROOT_CONFIGURATION = createKey("dark_blue_hooked_skyroot");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_HOOKED_SKYROOT_CONFIGURATION = createKey("green_hooked_skyroot");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_CRYSTAL_TREE_CONFIGURATION = createKey("purple_crystal_tree");

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Genesis.MODID, name));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, GREEN_AERCLOUD_4_CONFIGURATION, AetherFeatures.AERCLOUD.get(), AetherConfiguredFeatureBuilders.aercloud(4, GenesisFeatureStates.GREEN_AERCLOUD));
        register(context, GREEN_AERCLOUD_8_CONFIGURATION, AetherFeatures.AERCLOUD.get(), AetherConfiguredFeatureBuilders.aercloud(8, GenesisFeatureStates.GREEN_AERCLOUD));
        register(context, PURPLE_AERCLOUD_CONFIGURATION, AetherFeatures.AERCLOUD.get(), AetherConfiguredFeatureBuilders.aercloud(4, GenesisFeatureStates.PURPLE_AERCLOUD));
        register(context, STORM_AERCLOUD_CONFIGURATION, AetherFeatures.AERCLOUD.get(), AetherConfiguredFeatureBuilders.aercloud(4, GenesisFeatureStates.STORM_AERCLOUD));
        register(context, LARGE_GREEN_SKYROOT_TREE_CONFIGURATION, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new GoldenOakTrunkPlacer(10, 0, 0),
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LEAVES),
                        new GoldenOakFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), ConstantInt.of(7)),
                        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
                ).ignoreVines().build());
        register(context, BLUE_SKYROOT_TREE_CONFIGURATION, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new StraightTrunkPlacer(4, 2, 0),
                        BlockStateProvider.simple(GenesisFeatureStates.BLUE_SKYROOT_LEAVES),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).ignoreVines().build());
        register(context, GREEN_SKYROOT_PINE_CONFIGURATION, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new StraightTrunkPlacer(5, 5, 0),
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LEAVES),
                        new AetherPineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2)),
                        new TwoLayersFeatureSize(2, 0, 2)
                ).ignoreVines().build());
        register(context, BLUE_SKYROOT_PINE_CONFIGURATION, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new StraightTrunkPlacer(5, 5, 0),
                        BlockStateProvider.simple(GenesisFeatureStates.BLUE_SKYROOT_LEAVES),
                        new AetherPineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2)),
                        new TwoLayersFeatureSize(2, 0, 2)
                ).ignoreVines().build());
        register(context, DARK_BLUE_HOOKED_SKYROOT_CONFIGURATION, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new HookedTrunkPlacer(8, 14, 14),
                        BlockStateProvider.simple(GenesisFeatureStates.DARK_BLUE_SKYROOT_LEAVES),
                        new HookedFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2)),
                        new TwoLayersFeatureSize(2, 1, 4)
                ).decorators(List.of(new TrunkDecorator(BlockStateProvider.simple(GenesisFeatureStates.SKYROOT_LOG_WALL)))).ignoreVines().build());
        register(context, GREEN_HOOKED_SKYROOT_CONFIGURATION, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new HookedTrunkPlacer(8, 14, 14),
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LEAVES),
                        new HookedFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2)),
                        new TwoLayersFeatureSize(2, 1, 4)
                ).decorators(List.of(new TrunkDecorator(BlockStateProvider.simple(GenesisFeatureStates.SKYROOT_LOG_WALL)))).ignoreVines().build());
        register(context, PURPLE_CRYSTAL_TREE_CONFIGURATION, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(AetherFeatureStates.SKYROOT_LOG),
                        new SkinnyHookedTrunkPlacer(8, 5, 0, BlockStateProvider.simple(GenesisFeatureStates.SKYROOT_LOG_WALL)),
                        new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(GenesisFeatureStates.PURPLE_CRYSTAL_LEAVES, 4).add(GenesisFeatureStates.PURPLE_CRYSTAL_FRUIT_LEAVES, 1).build()),
                        new HookedFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2)),
                        new TwoLayersFeatureSize(2, 1, 4)
                ).ignoreVines().build());
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
