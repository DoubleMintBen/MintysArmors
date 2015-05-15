package com.doublemintben.mintysarmors;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = MintysArmors.MODID, name=MintysArmors.MODNAME, version = MintysArmors.VERSION)

public class MintysArmors
{
	public static final String MODID = "mintysarmors";
    public static final String MODNAME = "Minty's Utilities";
    public static final String VERSION = "1.0_1.7.10";
    
    //Items
	public static Item tannedLeather;
	public static Item stirrups;
	public static Item diamondArmorBody;
	public static Item diamondArmorHead;
	public static Item goldArmorBody;
	public static Item goldArmorHead;
	public static Item ironArmorBody;
	public static Item ironArmorHead;
    
    @Instance(value = MintysArmors.MODID)
    public static MintysArmors Instance;
    
    @SidedProxy(clientSide="com.doublemintben.mintysarmors.client.ClientProxy",
    			serverSide="com.doublemintben.mintysarmors.CommonProxy")
    public static CommonProxy proxy;
    

    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {    	
    	//init items
    	stirrups = new Stirrups()
    		.setTextureName("mintysarmorsr:stirrup");
    	tannedLeather = new TannedLeather()
    		.setTextureName("mintysarmors:tannedleather");
		diamondArmorBody = new DiamondArmorBody()
			.setTextureName("mintysarmors:DiamondBody");
		diamondArmorHead = new DiamondArmorHead()
			.setTextureName("mintysarmors:DiamondHead");
		goldArmorBody = new GoldArmorBody()
			.setTextureName("mintysarmors:GoldBody");
		goldArmorHead = new GoldArmorHead()
			.setTextureName("mintysarmors:GoldHead");
		ironArmorBody = new IronArmorBody()
			.setTextureName("mintysarmors:IronBody");
		ironArmorHead = new IronArmorHead()
			.setTextureName("mintysarmors:IronHead");
    	
		//register
    	GameRegistry.registerItem(stirrups, "Stirrups");
    	GameRegistry.registerItem(tannedLeather, "Tanned Leather");
		GameRegistry.registerItem(diamondArmorBody, "Diamond Horse Armor Body");
		GameRegistry.registerItem(diamondArmorHead, "Diamond Horse Armor Head");
		GameRegistry.registerItem(goldArmorBody, "Gold Horse Armor Body");
		GameRegistry.registerItem(goldArmorHead, "Gold Horse Armor Head");
		GameRegistry.registerItem(ironArmorBody, "Iron Horse Armor Body");
		GameRegistry.registerItem(ironArmorHead, "Iron Horse Armor Head");
    }
    
    @EventHandler
    public void Init(FMLServerStartingEvent event)
    {
    	//do something smart
    }
  
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	FMLCommonHandler.instance().bus().register(Instance);
    	proxy.registerRenderers();
    	craftingRecipies();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	//do something smart after other smart things
    }
    
    private void craftingRecipies()
    {
    	//vanilla itemstacks
    	ItemStack ironStack = new ItemStack(Items.iron_ingot);
    	ItemStack goldStack = new ItemStack(Items.gold_ingot);
    	ItemStack stringStack = new ItemStack(Items.string);
    	ItemStack saddleStack = new ItemStack(Items.saddle);
    	ItemStack fleshStack = new ItemStack(Items.rotten_flesh);
    	ItemStack leatherStack = new ItemStack(Items.leather);
    	ItemStack signStack = new ItemStack(Items.sign);
    	ItemStack ntStack = new ItemStack(Items.name_tag);
    	ItemStack diamondStack = new ItemStack(Items.diamond);
    	ItemStack woolStack = new ItemStack(Blocks.wool);
    	ItemStack diamondHA = new ItemStack(Items.diamond_horse_armor);
    	ItemStack goldHA = new ItemStack(Items.golden_horse_armor);
    	ItemStack ironHA = new ItemStack(Items.iron_horse_armor);
    	
    	//minty's itemstacks
    	ItemStack tlStack = new ItemStack(MintysArmors.tannedLeather);
    	ItemStack stirrupStack = new ItemStack(MintysArmors.stirrups, 2);
		ItemStack dab = new ItemStack(MintysArmors.diamondArmorBody);
		ItemStack dah = new ItemStack(MintysArmors.diamondArmorHead);
		ItemStack gab = new ItemStack(MintysArmors.goldArmorBody);
		ItemStack gah = new ItemStack(MintysArmors.goldArmorHead);
		ItemStack iab = new ItemStack(MintysArmors.ironArmorBody);
		ItemStack iah = new ItemStack(MintysArmors.ironArmorHead);
    	
    	//smelting Rotten Flesh
    	GameRegistry.addSmelting(fleshStack, leatherStack, .1f);
    	
    	//leather tanning
		GameRegistry.addSmelting(leatherStack, tlStack, .1f);
		
		//saddle recipe
		GameRegistry.addShapedRecipe(saddleStack, "TTT", "TWT", "U U",
				'T', tlStack, 'W', woolStack, 'U', stirrupStack);
				
		//stirrup recipe
		GameRegistry.addShapedRecipe(stirrupStack, "SSS", "I I", "III",
				'S', stringStack, 'I', ironStack);
		
		//nametag recipe
		GameRegistry.addShapedRecipe(ntStack, "SSS", " I ", " T ",
				'S', stringStack, 'I', ironStack, 'T', signStack);
		
		//***DIAMOND
		//horse body armor
		GameRegistry.addShapedRecipe(dab, "DDD", "DWD", "DDD",
				'D', diamondStack, 'W', woolStack);
		//horse head armor
		GameRegistry.addShapedRecipe(dah, "SDD", "DDD", "DDS",
				'S', stringStack, 'D', diamondStack);		
		//horse armor
		GameRegistry.addShapelessRecipe(diamondHA, dab, dah);
		//***END DIAMOND
		
		//***GOLD
		//body armor
		GameRegistry.addShapedRecipe(gab, "GGG", "GWG", "GGG",
				'G', goldStack, 'W', woolStack);
		//head armor
		GameRegistry.addShapedRecipe(gah, "SGG", "GGG", "GGS",
				'S', stringStack, 'G', goldStack);
		//armor
		GameRegistry.addShapelessRecipe(goldHA, gab, gah);		
		//***END GOLD
		
		//***IRON
		//body armor
		GameRegistry.addShapedRecipe(iab, "III", "IWI", "III",
				'I', ironStack, 'W', woolStack);
		//head armor
		GameRegistry.addShapedRecipe(iah, "SII", "III", "IIS",
				'S', stringStack, 'I', ironStack);
		//armor
		GameRegistry.addShapelessRecipe(ironHA, iab, iah);
		//***END IRON
    }
    

}
