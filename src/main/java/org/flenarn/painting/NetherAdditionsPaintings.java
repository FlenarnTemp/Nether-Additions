package org.flenarn.painting;

import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.flenarn.NetherAdditions;

public class NetherAdditionsPaintings {
    public static final PaintingVariant PURSUIT = registerPainting("pursuit", new PaintingVariant(48,32));
    public static final PaintingVariant FAMILYMEETING = registerPainting("familymeeting", new PaintingVariant(32,32));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(NetherAdditions.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings(){
        NetherAdditions.LOGGER.debug("Registering Paintings for " + NetherAdditions.MOD_ID);
    }
}
