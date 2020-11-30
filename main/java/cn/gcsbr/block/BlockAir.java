package cn.gcsbr.block;

import cn.gcsbr.item.Item;
import cn.gcsbr.math.AxisAlignedBB;
import cn.gcsbr.utils.BlockColor;

/**
 * author: MagicDroidX
 * gcsbr Project
 */
public class BlockAir extends BlockTransparent {

    public BlockAir() {}

    @Override
    public int getId() {
        return AIR;
    }

    @Override
    public String getName() {
        return "Air";
    }

    @Override
    public boolean canPassThrough() {
        return true;
    }

    @Override
    public boolean isBreakable(Item item) {
        return false;
    }

    @Override
    public boolean canBeFlowedInto() {
        return true;
    }

    @Override
    public boolean canBePlaced() {
        return false;
    }

    @Override
    public boolean canBeReplaced() {
        return true;
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
        return null;
    }

    @Override
    public double getHardness() {
        return 0;
    }

    @Override
    public double getResistance() {
        return 0;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.AIR_BLOCK_COLOR;
    }
}
