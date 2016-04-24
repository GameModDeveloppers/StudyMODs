package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ExampleMod.MOD_ID,
	 name = ExampleMod.MOD_NAME,
	 version = ExampleMod.MOD_VERSION,
	 dependencies = ExampleMod.MOD_DEPENDENCIES,
	 acceptedMinecraftVersions = ExampleMod.MOD_ACCEPTED_MC_VERSIONS,
	 useMetadata = true)		// metadata使用
public class ExampleMod
{
	// MOD-ID文字列
	public static final String MOD_ID = "examplemod";
	// MOD名称
	public static final String MOD_NAME = "ExampleMod";
	// MODバージョン
	public static final String MOD_VERSION = "1.0";
	// 前提MOD(少なくとも開発に使用するForgeのバージョンを入れる)
	public static final String MOD_DEPENDENCIES = "required-after:Forge@[1.8.9-11.15.0.1705,)";
	// 起動できるMinecraft本体バージョン
	// 記法はMavenのVersion Range Specificationを検索すること
	public static final String MOD_ACCEPTED_MC_VERSIONS = "[1.8, 1.8.9]";

	// 追加したいブロックのインスタンス格納先
	// レシピ等で利用する
	public static Block addBlock;
	//test
	public static Block addBlock2;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// 追加するブロックインスタンス作成
		addBlock = new ExampleBlock();
		addBlock2 = new TestBlock();

		// ゲームレジストリに登録
		GameRegistry.registerBlock(addBlock, ExampleBlock.MOD_ENTRY_NAME);
		GameRegistry.registerBlock(addBlock2, TestBlock.MOD_ENTRY_NAME);

		// テクスチャモデル指定JSONファイル名の登録(クライアント起動の場合)
		if (true == event.getSide().isClient()) {
			// モデル情報登録
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(addBlock), 0,
															new ModelResourceLocation(MOD_ID + ":" + ExampleBlock.MOD_ENTRY_NAME, "inventory"));
			// モデル情報登録
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(addBlock2), 0,
															new ModelResourceLocation(MOD_ID + ":" + TestBlock.MOD_ENTRY_NAME, "inventory"));
		}
	}
}
