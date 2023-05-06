package net.minecraft.world.gen.feature;

import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;

public class BlueIceFeature extends Feature<NoFeatureConfig> {
   public BlueIceFeature(Codec<NoFeatureConfig> p_i231933_1_) {
      super(p_i231933_1_);
   }

   public boolean place(ISeedReader p_241855_1_, ChunkGenerator p_241855_2_, Random p_241855_3_, BlockPos p_241855_4_, NoFeatureConfig p_241855_5_) {
      if (p_241855_4_.getY() > p_241855_1_.getSeaLevel() - 1) {
         return false;
      } else if (!p_241855_1_.getBlockState(p_241855_4_).is(Blocks.WATER) && !p_241855_1_.getBlockState(p_241855_4_.below()).is(Blocks.WATER)) {
         return false;
      } else {
         boolean flag = false;

         for(Direction direction : Direction.values()) {
            if (direction != Direction.DOWN && p_241855_1_.getBlockState(p_241855_4_.relative(direction)).is(Blocks.PACKED_ICE)) {
               flag = true;
               break;
            }
         }

         if (!flag) {
            return false;
         } else {
            p_241855_1_.setBlock(p_241855_4_, Blocks.BLUE_ICE.defaultBlockState(), 2);

            for(int i = 0; i < 200; ++i) {
               int j = p_241855_3_.nextInt(5) - p_241855_3_.nextInt(6);
               int k = 3;
               if (j < 2) {
                  k += j / 2;
               }

               if (k >= 1) {
                  BlockPos blockpos = p_241855_4_.offset(p_241855_3_.nextInt(k) - p_241855_3_.nextInt(k), j, p_241855_3_.nextInt(k) - p_241855_3_.nextInt(k));
                  BlockState blockstate = p_241855_1_.getBlockState(blockpos);
                  if (blockstate.getMaterial() == Material.AIR || blockstate.is(Blocks.WATER) || blockstate.is(Blocks.PACKED_ICE) || blockstate.is(Blocks.ICE)) {
                     for(Direction direction1 : Direction.values()) {
                        BlockState blockstate1 = p_241855_1_.getBlockState(blockpos.relative(direction1));
                        if (blockstate1.is(Blocks.BLUE_ICE)) {
                           p_241855_1_.setBlock(blockpos, Blocks.BLUE_ICE.defaultBlockState(), 2);
                           break;
                        }
                     }
                  }
               }
            }

            return true;
         }
      }
   }
}
