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
package com.karuslabs.commons.graphics.buttons;

import com.karuslabs.commons.graphics.ResettableComponent;
import com.karuslabs.commons.graphics.*;
import com.karuslabs.commons.locale.MessageTranslation;

import org.bukkit.event.inventory.*;


public abstract class CyclicButton<State> extends ResettableComponent implements Button {
    
    protected State[] states;
    protected int index;

    
    public CyclicButton(State... states) {
        this(false, states);
    } 
    
    public CyclicButton(boolean reset, State... states) {
        super(reset);
        if (states.length == 0) {
            throw new IllegalArgumentException("Button must be initialised with at least one state");
        }
        this.states = states;
        this.index = 0;
    }
    
    
    @Override
    public void click(Point clicked, InventoryClickEvent event, MessageTranslation translation) {
        onClick(clicked, event, translation, states[index]);
        next();
    }
    
    protected void onClick(Point clicked, InventoryClickEvent event, MessageTranslation translation, State state) {
        
    }
    

    @Override
    public void reset(InventoryCloseEvent event, MessageTranslation translation) {
        if (reset) {
            onReset(event, translation);
            index = 0;
        }
    }
    
    
    public State current() {
        return states[index];
    }
    
    public State next() {
        index = ++index < states.length ? index : 0;
        return states[index];
    }
    
    public int index() {
        return index;
    }
    
    public int length() {
        return states.length;
    }
    
}
