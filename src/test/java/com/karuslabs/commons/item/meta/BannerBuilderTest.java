/* 
 * The MIT License
 *
 * Copyright 2017 Karus Labs.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.karuslabs.commons.item.meta;

import java.util.*;

import org.bukkit.block.banner.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.bukkit.DyeColor.*;
import static org.bukkit.block.banner.PatternType.BASE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class BannerBuilderTest {
    
    private BannerMeta meta = mock(BannerMeta.class);
    private BannerBuilder builder = new BannerBuilder((ItemStack) when(mock(ItemStack.class).getItemMeta()).thenReturn(meta).getMock());
    
    
    @Test
    void build() {
        List<Pattern> patterns = singletonList(new Pattern(BLUE, BASE));                
        when(meta.getPatterns()).thenReturn(new ArrayList<>());
        
        builder.pattern(new Pattern(BLACK, BASE)).patterns(patterns);
        
        verify(meta).addPattern(new Pattern(BLACK, BASE));
        assertEquals(patterns, meta.getPatterns());
    }
    
}
