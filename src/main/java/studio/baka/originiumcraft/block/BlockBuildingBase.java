package studio.baka.originiumcraft.block;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import studio.baka.originiumcraft.OriginiumCraft;
import studio.baka.originiumcraft.client.gui.GuiPRTSTerminal;
import studio.baka.originiumcraft.client.gui.GuiProcessBuilding;
import studio.baka.originiumcraft.item.OCItems;
import studio.baka.originiumcraft.util.IHasModel;
import studio.baka.originiumcraft.util.OCCreativeTabs;
import studio.baka.originiumcraft.util.ReferenceConsts;

/* This block is used for TEST ONLY. */
public class BlockBuildingBase extends BlockHorizontal implements IHasModel {
    public BlockBuildingBase(){
        super(Material.IRON);
        setTranslationKey("building_base");
        setRegistryName(ReferenceConsts.MODID,"building_base");

        OCBlocks.BLOCKS.add(this);
        OCItems.ITEMS.add(new ItemBlock(this).setRegistryName("building_base"));
        this.setSoundType(SoundType.STONE);
        this.setHardness(5.0f);
        this.setResistance(15.0f);
        this.setHarvestLevel("pickaxe", 2);
    }


    @Override
    public void registerModels() {
        OriginiumCraft.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }


    @SideOnly(Side.CLIENT)
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!worldIn.isRemote) {
            return true;
        }else {
            Minecraft.getMinecraft().displayGuiScreen(new GuiProcessBuilding());
            return true;
        }
    }
}
