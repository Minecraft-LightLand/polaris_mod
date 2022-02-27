package org.xkmc.polaris.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import org.xkmc.polaris.util.Registration;
import org.xkmc.polaris.util.PolarisItemGroup;
import org.xkmc.polaris.util.PolarisArmorMaterial;

public class PolarisItems {


    public static final RegistryObject<Item> HeartOfOre = Registration.ITEMS.register("heart_of_ore",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS).durability(300)));

    public static final RegistryObject<Item> PurgatorySoil = Registration.ITEMS.register("purgatory_soil",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> DemonSoul = Registration.ITEMS.register("demon_soul",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> TheSoilOfEverything = Registration.ITEMS.register(
            "the_soil_of_everything",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS).durability(500)));

    public static final RegistryObject<Item> NetherStar = Registration.ITEMS.register("nether_star",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> NetherStarEssence = Registration.ITEMS.register("nether_star_essence",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> EndAlloyIngot = Registration.ITEMS.register("end_alloy_ingot",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> EndEssence = Registration.ITEMS.register(
            "end_essence",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> NetherAlloyIngotEssence = Registration.ITEMS.register(
            "nether_alloy_ingot_essence",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> NetherAlloyEssence = Registration.ITEMS.register(
            "nether_alloy_essence",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> ActivatingCore1 = Registration.ITEMS.register("activating_core_1",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> ActivatingCore2 = Registration.ITEMS.register("activating_core_2",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> ActivatingCore3 = Registration.ITEMS.register("activating_core_3",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> ActivatingCore4 = Registration.ITEMS.register("activating_core_4",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> ActivatingCorePower = Registration.ITEMS.register(
            "activating_core_power",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> InactiveCore1 = Registration.ITEMS.register("inactive_core_1",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> InactiveCore2 = Registration.ITEMS.register("inactive_core_2",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> InactiveCore3 = Registration.ITEMS.register("inactive_core_3",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> InactiveCore4 = Registration.ITEMS.register("inactive_core_4",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> InactiveCorePower = Registration.ITEMS.register("inactive_core_power",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> TheVoidOfSource = Registration.ITEMS.register("the_void_of_source",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> FlameOfTheSoul = Registration.ITEMS.register("flame_of_the_soul",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> SpiritOfDivinity = Registration.ITEMS.register("spirit_of_divinity",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS).durability(300)));

    public static final RegistryObject<Item> LifeOfSeeds = Registration.ITEMS.register("life_of_seeds",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS).durability(300)));

    public static final RegistryObject<Item> CryingGhost = Registration.ITEMS.register("crying_ghost",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> StarCoin1 = Registration.ITEMS.register("star_coin_1",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> StarCoin2 = Registration.ITEMS.register("star_coin_2",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> StarCoin3 = Registration.ITEMS.register("star_coin_3",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> StarCoin4 = Registration.ITEMS.register("star_coin_4",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> StarCoin5 = Registration.ITEMS.register("star_coin_5",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> StarCoin6 = Registration.ITEMS.register("star_coin_6",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> StarCoin7 = Registration.ITEMS.register("star_coin_7",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

    public static final RegistryObject<Item> StarCoin8 = Registration.ITEMS.register("star_coin_8",
            () -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));


    public static final RegistryObject<ArmorItem> StardustHelmet = Registration.ITEMS.register("stardust_helmet",
            () -> new PolarisArmors(PolarisArmorMaterial.STARDUST, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> StardustChest = Registration.ITEMS.register("stardust_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.STARDUST, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> StardustLeggings = Registration.ITEMS.register("stardust_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.STARDUST, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> StardustBoots = Registration.ITEMS.register("stardust_boots",
            () -> new ArmorItem(PolarisArmorMaterial.STARDUST, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));


    public static final RegistryObject<ArmorItem> StarburstHelmet = Registration.ITEMS.register("starburst_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.STARBURST, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> StarburstChest = Registration.ITEMS.register("starburst_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.STARBURST, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> StarburstLeggings = Registration.ITEMS.register("starburst_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.STARBURST, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> StarburstBoots = Registration.ITEMS.register("starburst_boots",
            () -> new ArmorItem(PolarisArmorMaterial.STARBURST, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));


    public static final RegistryObject<ArmorItem> StarLordHelmet = Registration.ITEMS.register("star_lord_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.STAR_LORD, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> StarLordChest = Registration.ITEMS.register("star_lord_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.STAR_LORD, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> StarLordLeggings = Registration.ITEMS.register("star_lord_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.STAR_LORD, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> StarLordBoots = Registration.ITEMS.register("star_lord_boots",
            () -> new ArmorItem(PolarisArmorMaterial.STAR_LORD, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));


    public static final RegistryObject<ArmorItem> MSBaseHelmet = Registration.ITEMS.register("ms_base_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.MSBase, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSBaseChest = Registration.ITEMS.register("ms_base_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.MSBase, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSBaseLeggings = Registration.ITEMS.register("ms_base_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.MSBase, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSBaseBoots = Registration.ITEMS.register("ms_base_boots",
            () -> new ArmorItem(PolarisArmorMaterial.MSBase, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));


    public static final RegistryObject<ArmorItem> MSWhiteTigerHelmet = Registration.ITEMS.register("ms_white_tiger_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.MSWhiteTiger, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSWhiteTigerChest = Registration.ITEMS.register("ms_white_tiger_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.MSWhiteTiger, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSWhiteTigerLeggings = Registration.ITEMS.register("ms_white_tiger_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.MSWhiteTiger, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSWhiteTigerBoots = Registration.ITEMS.register("ms_white_tiger_boots",
            () -> new ArmorItem(PolarisArmorMaterial.MSWhiteTiger, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));


    public static final RegistryObject<ArmorItem> MSBlueDragonHelmet = Registration.ITEMS.register("ms_blue_dragon_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.MSBlueDragon, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSBlueDragonChest = Registration.ITEMS.register("ms_blue_dragon_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.MSBlueDragon, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSBlueDragonLeggings = Registration.ITEMS.register("ms_blue_dragon_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.MSBlueDragon, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSBlueDragonBoots = Registration.ITEMS.register("ms_blue_dragon_boots",
            () -> new ArmorItem(PolarisArmorMaterial.MSBlueDragon, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));


    public static final RegistryObject<ArmorItem> MSVermilionBirdHelmet = Registration.ITEMS.register("ms_vermilion_bird_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.MSVermilionBird, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSVermilionBirdChest = Registration.ITEMS.register("ms_vermilion_bird_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.MSVermilionBird, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSVermilionBirdLeggings = Registration.ITEMS.register("ms_vermilion_bird_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.MSVermilionBird, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSVermilionBirdBoots = Registration.ITEMS.register("ms_vermilion_bird_boots",
            () -> new ArmorItem(PolarisArmorMaterial.MSVermilionBird, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));


    public static final RegistryObject<ArmorItem> MSBlackTortoiseHelmet = Registration.ITEMS.register("ms_black_tortoise_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.MSBlackTortoise, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSBlackTortoiseChest = Registration.ITEMS.register("ms_black_tortoise_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.MSBlackTortoise, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSBlackTortoiseLeggings = Registration.ITEMS.register("ms_black_tortoise_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.MSBlackTortoise, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> MSBlackTortoiseBoots = Registration.ITEMS.register("ms_black_tortoise_boots",
            () -> new ArmorItem(PolarisArmorMaterial.MSBlackTortoise, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));


    public static final RegistryObject<ArmorItem> SupremeGenesisHelmet = Registration.ITEMS.register("supreme_genesis_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.SupremeGenesis, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> SupremeGenesisChest = Registration.ITEMS.register("supreme_genesis_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.SupremeGenesis, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> SupremeGenesisLeggings = Registration.ITEMS.register("supreme_genesis_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.SupremeGenesis, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> SupremeGenesisBoots = Registration.ITEMS.register("supreme_genesis_boots",
            () -> new ArmorItem(PolarisArmorMaterial.SupremeGenesis, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));
    public static final RegistryObject<ArmorItem> SupremeGenesisWhiteHelmet = Registration.ITEMS.register("supreme_genesis_white_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.SupremeGenesisWhite, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> SupremeGenesisWhiteChest = Registration.ITEMS.register("supreme_genesis_white_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.SupremeGenesisWhite, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> SupremeGenesisWhiteLeggings = Registration.ITEMS.register("supreme_genesis_white_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.SupremeGenesisWhite, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> SupremeGenesisWhiteBoots = Registration.ITEMS.register("supreme_genesis_white_boots",
            () -> new ArmorItem(PolarisArmorMaterial.SupremeGenesisWhite, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));


    public static final RegistryObject<ArmorItem> EmperorsNewClothesHelmet = Registration.ITEMS.register("emperors_new_clothes_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.EmperorsNewClothes, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> EmperorsNewClothesChest = Registration.ITEMS.register("emperors_new_clothes_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.EmperorsNewClothes, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> EmperorsNewClothesLeggings = Registration.ITEMS.register("emperors_new_clothes_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.EmperorsNewClothes, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> EmperorsNewClothesBoots = Registration.ITEMS.register("emperors_new_clothes_boots",
            () -> new ArmorItem(PolarisArmorMaterial.EmperorsNewClothes, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));


    public static final RegistryObject<ArmorItem> LittleCatPinkHelmet = Registration.ITEMS.register("little_cat_pink_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.LittleCatPink, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> LittleCatPinkChest = Registration.ITEMS.register("little_cat_pink_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.LittleCatPink, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> LittleCatPinkLeggings = Registration.ITEMS.register("little_cat_pink_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.LittleCatPink, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> LittleCatPinkBoots = Registration.ITEMS.register("little_cat_pink_boots",
            () -> new ArmorItem(PolarisArmorMaterial.LittleCatPink, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));


    public static final RegistryObject<ArmorItem> LittleCatBlueHelmet = Registration.ITEMS.register("little_cat_blue_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.LittleCatBlue, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> LittleCatBlueChest = Registration.ITEMS.register("little_cat_blue_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.LittleCatBlue, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> LittleCatBlueLeggings = Registration.ITEMS.register("little_cat_blue_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.LittleCatBlue, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> LittleCatBlueBoots = Registration.ITEMS.register("little_cat_blue_boots",
            () -> new ArmorItem(PolarisArmorMaterial.LittleCatBlue, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));


    public static final RegistryObject<ArmorItem> LittleCatYellowHelmet = Registration.ITEMS.register("little_cat_yellow_helmet",
            () -> new ArmorItem(PolarisArmorMaterial.LittleCatYellow, EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> LittleCatYellowChest = Registration.ITEMS.register("little_cat_yellow_chestplate",
            () -> new ArmorItem(PolarisArmorMaterial.LittleCatYellow, EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> LittleCatYellowLeggings = Registration.ITEMS.register("little_cat_yellow_leggings",
            () -> new ArmorItem(PolarisArmorMaterial.LittleCatYellow, EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static final RegistryObject<ArmorItem> LittleCatYellowBoots = Registration.ITEMS.register("little_cat_yellow_boots",
            () -> new ArmorItem(PolarisArmorMaterial.LittleCatYellow, EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));

    public static void register() {
    }

}
