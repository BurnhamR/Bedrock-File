package cn.gcsbr.block;

import cn.gcsbr.item.Item;

/**
 * author: Angelic47
 * gcsbr Project
 */
public class BlockBedrock extends BlockSolid {

    public BlockBedrock() {
    }

    @Override
    public int getId() {
        return BEDROCK;
    }

    @Override
    public double getHardness() {
        return -1;
    }

    @Override
    public double getResistance() {
        return 18000000;
    }

    @Override
    public String getName() {
        return "Bedrock";
    }

    @Override
    public boolean isBreakable(Item item) {
        return false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }
}
