package randommcsomethin.fallingleaves.util;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;
import randommcsomethin.fallingleaves.FallingLeavesClient;

import java.util.Optional;

import static randommcsomethin.fallingleaves.FallingLeavesClient.LOGGER;

/**
 * TODO - Explore ParticleTypes in the registry. Should we be using it to
 *        define more precisely what kind of particles we are adding?
 */
public class RegistryUtil {

    public static DefaultParticleType registerNewLeafParticle(String leafParticleName) {
        LOGGER.debug("Registering particle: {}", leafParticleName);

        return Registry.register(
            Registry.PARTICLE_TYPE,
            makeId(leafParticleName),
            FabricParticleTypes.simple()
        );
    }

    public static Identifier makeId(String path) {
        return new Identifier(FallingLeavesClient.MOD_ID, path);
    }

    public static Identifier getBlockId(BlockState blockState) {
        return Registry.BLOCK.getId(blockState.getBlock());
    }

    @Nullable
    public static Block getBlock(Identifier blockId) {
        Optional<Block> maybeBlock = Registry.BLOCK.getOrEmpty(blockId);
        return maybeBlock.orElse(null);
    }

}
