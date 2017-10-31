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

import com.karuslabs.commons.graphics.ClickContext;

import org.bukkit.event.inventory.InventoryCloseEvent;


public abstract class CyclicButton<State> implements Button {
    
    State[] states;
    int index;

    
    public CyclicButton(State... states) {
        if (states.length == 0) {
            throw new IllegalArgumentException("Button must be initialised with at least one state");
        }
        this.states = states;
        this.index = 0;
    }
    
    
    @Override
    public void click(ClickContext context) {
        onClick(context, states[index]);
        next();
    }
    
    protected void onClick(ClickContext context, State state) {
        
    }
    
    @Override
    public void reset(InventoryCloseEvent event) {
        onReset(event);
        index = 0;
    }
    
    protected void onReset(InventoryCloseEvent event) {
        
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