package org.flenarn.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.flenarn.NetherAdditions;

public class NetherAdditionsPaintings {

    public static final PaintingVariant PURSUIT = new PaintingVariant(48,32, Identifier.of(NetherAdditions.MOD_ID, "pursuit"));
    //public static final PaintingVariant FAMILY_MEETING = registerPainting("family_meeting", new PaintingVariant(32,32));
    //public static final PaintingVariant TWISTED_VINES = registerPainting("twisted_vines", new PaintingVariant(16,32));

    //private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        //return Registry.register(Registries.PAINTING_VARIANT, Identifier.of(NetherAdditions.MOD_ID, name), paintingVariant);
    //}

    public static void registerPaintings(){
        NetherAdditions.LOGGER.debug("Registering Paintings for " + NetherAdditions.MOD_ID);
    }
}
