/*
 * Copyright (C) 2017 Karus Labs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.karuslabs.commons.menu.buttons;

import com.karuslabs.commons.menu.Menu;

import org.bukkit.event.inventory.InventoryClickEvent;


public abstract class CheckBox implements Button {
    
    private boolean checked;
    private boolean checkedByDefault;
    
    
    public CheckBox() {
        this(false);
    }
    
    public CheckBox(boolean checked) {
        this.checked = checked;
        this.checkedByDefault = checked;
    }
    
    
    @Override
    public void click(Menu menu, InventoryClickEvent event) {
        if (!checked) {
            checked = check(menu, event);
            
        } else {
            checked = uncheck(menu, event);
        }
    }
    
    protected boolean check(Menu menu, InventoryClickEvent event) {
        return true;
    }
    
    protected boolean uncheck(Menu menu, InventoryClickEvent event) {
        return false;
    }
    
    
    @Override
    public void reset(Menu menu) {
        checked = checkedByDefault;
    }
    
    
    public boolean isChecked() {
        return checked;
    }
    
    public boolean isCheckedByDefault() {
        return checkedByDefault;
    }
    
}
