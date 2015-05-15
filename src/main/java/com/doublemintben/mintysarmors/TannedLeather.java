package com.doublemintben.mintysarmors;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class TannedLeather extends Item
{
	public TannedLeather()
	{
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("TannedLeather");
	}
}
