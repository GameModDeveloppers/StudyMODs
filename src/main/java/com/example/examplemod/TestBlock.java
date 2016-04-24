package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

//
//	ExampleBlockクラス
//	Blockクラス継承
//

public class TestBlock extends Block
{
	// MOD管理名：システムへの登録時に使用
	public static final String MOD_ENTRY_NAME = "TestBlock";


	// ブロックの元にするマテリアル情報
	private static final Material BASE_MATERIAL = Material.rock;				// 石ブロック
	// このブロックが表示されるクリエイティヴモードのタブ
	private static final CreativeTabs BLOCK_SHOW_TAB = CreativeTabs.tabBlock;		// ブロック系タブ

	// ブロックの硬さ
	private static final float BLOCK_HARDNESS = 1.0f;
	// ブロックの爆破耐性
	private static final float BLOCK_RESISTANCE = 500.0f;
	// ブロックを歩いた時の音
	private static final SoundType BLOCK_STEPSOUND = soundTypeStone;

	// ブロック透過係数(デフォルト=0)
	private static final int BLOCK_OPACITY = 1;
	// ブロックの明るさ(15 = 1.0f)
	private static final float BLOCK_BRIGHTLEVEL = 0;

	//
	//	コンストラクタ
	//
	public TestBlock()
	{
		// 継承元クラスのコンストラクタコール
		super(BASE_MATERIAL);

		// クリエイティブモードで表示されるタブの選択
		setCreativeTab(BLOCK_SHOW_TAB);
		setUnlocalizedName("BlockTest");

		//
		//	ブロックパラメータの設定
		//
		setHardness(BLOCK_HARDNESS);				// 硬さ
		setResistance(BLOCK_RESISTANCE);			// 爆破耐性
		setStepSound(BLOCK_STEPSOUND);			// 歩行音
		//setBlockUnbreakable();					// 破壊可能フラグ
		//setTickRandomly(true);					// ブロックのTick()処理をランダムにコール
		//disableStats();							// ブロックの統計情報を保存しない
		setLightOpacity(BLOCK_OPACITY);			// ブロック透過係数
		setLightLevel(BLOCK_BRIGHTLEVEL);			// ブロック明るさ

		// 初期ブロック状態の取得
		//this.setDefaultState(getBlockState().getBaseState());
	}
}

