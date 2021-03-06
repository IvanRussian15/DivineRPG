package divinerpg.structure.vethea.crypt1;

import divinerpg.structure.base.DivineStructureStart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureComponentTemplate;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class Crypt1Start extends DivineStructureStart {

    public Crypt1Start() {
    }

    public Crypt1Start(ResourceLocation location, TemplateManager manager, Rotation rotation, int chunkX, int y, int chunkZ) {
        super(location, manager, rotation, chunkX, y, chunkZ, 2, 2);
    }

    @Override
    protected StructureComponentTemplate getComponent(TemplateManager manager, ResourceLocation location, Rotation rotation, BlockPos pos) {
        return new Crypt1Component(manager, location, rotation, pos);
    }
}
