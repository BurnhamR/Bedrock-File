package cn.gcsbr.block;

import cn.gcsbr.Player;
import cn.gcsbr.blockentity.BlockEntity;
import cn.gcsbr.blockentity.BlockEntityBeacon;
import cn.gcsbr.inventory.BeaconInventory;
import cn.gcsbr.item.Item;
import cn.gcsbr.item.ItemTool;
import cn.gcsbr.math.BlockFace;
import cn.gcsbr.nbt.tag.CompoundTag;
import cn.gcsbr.utils.BlockColor;

/**
 * author: Angelic47 gcsbr Project
 */
public class BlockBeacon extends BlockTransparent {

    public BlockBeacon() {
    }

    @Override
    public int getId() {
        return BEACON;
    }

    @Override
    public double getHardness() {
        return 3;
    }

    @Override
    public double getResistance() {
        return 15;
    }

    @Override
    public int getLightLevel() {
        return 15;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public String getName() {
        return "Beacon";
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @Override
    public boolean onActivate(Item item, Player player) {
        if (player != null) {
            BlockEntity t = this.getLevel().getBlockEntity(this);
            BlockEntityBeacon beacon;
            if (t instanceof BlockEntityBeacon) {
                beacon = (BlockEntityBeacon) t;
            } else {
                CompoundTag nbt = new CompoundTag("")
                        .putString("id", BlockEntity.BEACON)
                        .putInt("x", (int) this.x)
                        .putInt("y", (int) this.y)
                        .putInt("z", (int) this.z);
                beacon = (BlockEntityBeacon) BlockEntity.createBlockEntity(BlockEntity.BEACON, this.getLevel().getChunk((int) (this.x) >> 4, (int) (this.z) >> 4), nbt);
                if (beacon == null) {
                    return false;
                }
            }

            player.addWindow(new BeaconInventory(player.getUIInventory(), this), Player.BEACON_WINDOW_ID);
        }
        return true;
    }

    @Override
    public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player) {
        boolean blockSuccess = super.place(item, block, target, face, fx, fy, fz, player);

        if (blockSuccess) {
            CompoundTag nbt = new CompoundTag("")
                    .putString("id", BlockEntity.BEACON)
                    .putInt("x", (int) this.x)
                    .putInt("y", (int) this.y)
                    .putInt("z", (int) this.z);
            BlockEntityBeacon beacon = (BlockEntityBeacon) BlockEntity.createBlockEntity(BlockEntity.BEACON, this.getLevel().getChunk((int) (this.x) >> 4, (int) (this.z) >> 4), nbt);
            if (beacon == null) {
                return false;
            }
        }

        return blockSuccess;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.DIAMOND_BLOCK_COLOR;
    }
}
