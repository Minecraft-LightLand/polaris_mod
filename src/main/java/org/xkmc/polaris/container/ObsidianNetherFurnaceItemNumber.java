package org.xkmc.polaris.container;

import net.minecraft.util.IIntArray;

public class ObsidianNetherFurnaceItemNumber implements IIntArray {
    int i = 0;
    @Override
    public int get(int index) {
        return i;
    }

    @Override
    public void set(int index, int value) {

    }

    @Override
    public int getCount() {
        return 4;
    }
}
