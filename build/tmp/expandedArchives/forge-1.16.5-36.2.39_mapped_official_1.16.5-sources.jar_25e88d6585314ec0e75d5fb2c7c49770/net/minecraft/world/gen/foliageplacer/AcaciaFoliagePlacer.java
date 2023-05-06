package net.minecraft.world.gen.foliageplacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Random;
import java.util.Set;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;

public class AcaciaFoliagePlacer extends FoliagePlacer {
   public static final Codec<AcaciaFoliagePlacer> CODEC = RecordCodecBuilder.create((p_236737_0_) -> {
      return foliagePlacerParts(p_236737_0_).apply(p_236737_0_, AcaciaFoliagePlacer::new);
   });

   public AcaciaFoliagePlacer(FeatureSpread p_i241994_1_, FeatureSpread p_i241994_2_) {
      super(p_i241994_1_, p_i241994_2_);
   }

   protected FoliagePlacerType<?> type() {
      return FoliagePlacerType.ACACIA_FOLIAGE_PLACER;
   }

   protected void createFoliage(IWorldGenerationReader p_230372_1_, Random p_230372_2_, BaseTreeFeatureConfig p_230372_3_, int p_230372_4_, FoliagePlacer.Foliage p_230372_5_, int p_230372_6_, int p_230372_7_, Set<BlockPos> p_230372_8_, int p_230372_9_, MutableBoundingBox p_230372_10_) {
      boolean flag = p_230372_5_.doubleTrunk();
      BlockPos blockpos = p_230372_5_.foliagePos().above(p_230372_9_);
      this.placeLeavesRow(p_230372_1_, p_230372_2_, p_230372_3_, blockpos, p_230372_7_ + p_230372_5_.radiusOffset(), p_230372_8_, -1 - p_230372_6_, flag, p_230372_10_);
      this.placeLeavesRow(p_230372_1_, p_230372_2_, p_230372_3_, blockpos, p_230372_7_ - 1, p_230372_8_, -p_230372_6_, flag, p_230372_10_);
      this.placeLeavesRow(p_230372_1_, p_230372_2_, p_230372_3_, blockpos, p_230372_7_ + p_230372_5_.radiusOffset() - 1, p_230372_8_, 0, flag, p_230372_10_);
   }

   public int foliageHeight(Random p_230374_1_, int p_230374_2_, BaseTreeFeatureConfig p_230374_3_) {
      return 0;
   }

   protected boolean shouldSkipLocation(Random p_230373_1_, int p_230373_2_, int p_230373_3_, int p_230373_4_, int p_230373_5_, boolean p_230373_6_) {
      if (p_230373_3_ == 0) {
         return (p_230373_2_ > 1 || p_230373_4_ > 1) && p_230373_2_ != 0 && p_230373_4_ != 0;
      } else {
         return p_230373_2_ == p_230373_5_ && p_230373_4_ == p_230373_5_ && p_230373_5_ > 0;
      }
   }
}
