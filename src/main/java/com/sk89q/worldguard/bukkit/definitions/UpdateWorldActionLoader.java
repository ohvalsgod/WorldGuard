// $Id$
/*
 * This file is a part of WorldGuard.
 * Copyright (c) sk89q <http://www.sk89q.com>
 * Copyright (c) the WorldGuard team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.sk89q.worldguard.bukkit.definitions;

import com.sk89q.rebar.config.AbstractNodeLoader;
import com.sk89q.rebar.config.ConfigurationNode;
import com.sk89q.rebar.util.LoggerUtils;
import com.sk89q.rulelists.DefinitionException;
import com.sk89q.rulelists.RuleListUtils;

public class UpdateWorldActionLoader extends AbstractNodeLoader<UpdateWorldAction> {

    @Override
    public UpdateWorldAction read(ConfigurationNode node) throws DefinitionException {
        Boolean storm = node.getBoolean("set-storm");
        Boolean thunderstorm = node.getBoolean("set-thunderstorm");

        UpdateWorldAction action = new UpdateWorldAction();
        action.setStorm(storm);
        action.setThunderstorm(thunderstorm);

        RuleListUtils.warnUnknown(node, LoggerUtils.getLogger(getClass()),
                                  "set-storm", "set-thunderstorm");

        return action;
    }

}