package divinerpg.objects.entities.entity.npc;

import divinerpg.objects.entities.entity.EntityDivineMerchant;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ArmorRegistry;
import divinerpg.registry.SoundRegistry;
import divinerpg.registry.WeaponRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityJackOMan extends EntityDivineMerchant {
    public EntityJackOMan(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 2f);
    }

    protected int getGuiId() {
        return GUIHandler.JACK_O_MAN_GUI_ID;
    }

    protected String[] getChatMessages() {
        return new String[] {
                "message.jackoman.boo",
                "message.jackoman.lost",
                "message.jackoman.hurah",
                "message.jackoman.seen"
        };
    }

    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add(new MerchantRecipe(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60),
                new ItemStack(ArmorRegistry.skelemanHelmet, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60),
                new ItemStack(ArmorRegistry.skelemanChestplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60),
                new ItemStack(ArmorRegistry.skelemanLeggings, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(Items.BONE, 40), new ItemStack(Items.SPIDER_EYE, 60),
                new ItemStack(ArmorRegistry.skelemanBoots, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10),
                new ItemStack(ArmorRegistry.jackOManHelmet)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10),
                new ItemStack(ArmorRegistry.jackOManChestplate)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10),
                new ItemStack(ArmorRegistry.jackOManLeggings)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10),
                new ItemStack(ArmorRegistry.jackOManBoots)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 3, 1), new ItemStack(ArmorRegistry.witherReaperHelmet)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 5, 1), new ItemStack(ArmorRegistry.witherReaperChestplate)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 4, 1), new ItemStack(ArmorRegistry.witherReaperLeggings)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 2, 1), new ItemStack(ArmorRegistry.witherReaperBoots)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 6, 1), new ItemStack(Items.ENDER_EYE, 60),
                new ItemStack(WeaponRegistry.scythe)));
        return list;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public boolean canDespawn() {
        return true;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && this.isValidLightLevel() && super.getCanSpawnHere();
    }

    public boolean isValidLightLevel() {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32)) {
            return false;
        } else {
            int i = this.world.getLightFromNeighbors(blockpos);

            if (this.world.isThundering()) {
                int j = this.world.getSkylightSubtracted();
                this.world.setSkylightSubtracted(10);
                i = this.world.getLightFromNeighbors(blockpos);
                this.world.setSkylightSubtracted(j);
            }

            return i <= this.rand.nextInt(8);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.JACKOMAN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.JACKOMAN;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.JACKOMAN;
    }
}
