package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityPeacefulUntilAttacked;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Epiphite extends EntityPeacefulUntilAttacked {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/epiphite");

    public Epiphite(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 1.0F);
        this.isImmuneToFire = true;
        this.experienceValue = 40;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(14);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.rand.nextInt(5) == 0)
            this.world.spawnEntity(new EntityLightningBolt(this.world, entity.posX, entity.posY, entity.posZ, true));
        return super.attackEntityAsMob(entity);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.GROWL;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.GROWL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GROWL_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}