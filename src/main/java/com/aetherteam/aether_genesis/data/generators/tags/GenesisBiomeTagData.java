package com.aetherteam.aether_genesis.data.generators.tags;

import com.aetherteam.aether_genesis.Genesis;
import com.aetherteam.aether_genesis.GenesisTags;
import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class GenesisBiomeTagData extends BiomeTagsProvider {
    public GenesisBiomeTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper helper) {
        super(output, registries, Genesis.MODID, helper);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(GenesisTags.Biomes.HAS_GREEN_AERCLOUDS)
                .addOptional(AetherBiomes.SKYROOT_MEADOW.location())
                .addOptional(AetherBiomes.SKYROOT_GROVE.location())
                .addOptional(AetherBiomes.SKYROOT_WOODLAND.location())
                .addOptional(AetherBiomes.SKYROOT_FOREST.location());
        this.tag(GenesisTags.Biomes.HAS_PURPLE_AERCLOUDS)
                .addOptional(AetherBiomes.SKYROOT_MEADOW.location())
                .addOptional(AetherBiomes.SKYROOT_GROVE.location())
                .addOptional(AetherBiomes.SKYROOT_WOODLAND.location())
                .addOptional(AetherBiomes.SKYROOT_FOREST.location());
        this.tag(GenesisTags.Biomes.HAS_STORM_AERCLOUDS)
                .addOptional(AetherBiomes.SKYROOT_MEADOW.location())
                .addOptional(AetherBiomes.SKYROOT_GROVE.location())
                .addOptional(AetherBiomes.SKYROOT_WOODLAND.location())
                .addOptional(AetherBiomes.SKYROOT_FOREST.location());
        this.tag(GenesisTags.Biomes.HAS_MEADOW_TREES)
                .addOptional(AetherBiomes.SKYROOT_MEADOW.location());
        this.tag(GenesisTags.Biomes.HAS_GROVE_TREES)
                .addOptional(AetherBiomes.SKYROOT_GROVE.location());
        this.tag(GenesisTags.Biomes.HAS_WOODLAND_TREES)
                .addOptional(AetherBiomes.SKYROOT_WOODLAND.location());
        this.tag(GenesisTags.Biomes.HAS_FOREST_TREES)
                .addOptional(AetherBiomes.SKYROOT_FOREST.location());
        this.tag(GenesisTags.Biomes.HAS_DARK_SWET)
                .addOptional(AetherBiomes.SKYROOT_MEADOW.location())
                .addOptional(AetherBiomes.SKYROOT_GROVE.location())
                .addOptional(AetherBiomes.SKYROOT_WOODLAND.location())
                .addOptional(AetherBiomes.SKYROOT_FOREST.location());
    }
}
